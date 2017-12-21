package com.example.jiangtianci20171221;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jiangtianci20171221.adapter.MyAdapter;
import com.example.jiangtianci20171221.adapter.MyAdapter1;
import com.example.jiangtianci20171221.bean.DataBean;
import com.example.jiangtianci20171221.bean.MsgBean;
import com.example.jiangtianci20171221.event.MessageEvent;
import com.example.jiangtianci20171221.event.PriceAndCountEvent;
import com.example.jiangtianci20171221.event.SomeId;
import com.example.jiangtianci20171221.presenter.Present;
import com.example.jiangtianci20171221.view.IView1;
import com.facebook.drawee.backends.pipeline.Fresco;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class GouwucheActivity extends AppCompatActivity implements IView1 {
    private String uid = "75";
    private Present presenter;
    private CheckBox mCheckbox2;
    private ExpandableListView mElv;
    private TextView mTvPrice;
    private TextView mTvNum;
    private MyAdapter1 adapter1;
    private List<DataBean> groupList = new ArrayList<>();
    private List<List<DataBean.ListBean>> childList = new ArrayList<>();
    private String pid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_gouwuche);
        EventBus.getDefault().register(this);
        presenter = new Present(this);
        presenter.getcont(uid);

        initView();
        adapter1 = new MyAdapter1(this, groupList, childList);
        mElv.setAdapter(adapter1);


        mCheckbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter1.changeAllListCbState(mCheckbox2.isChecked());
            }
        });


    }

    private void initView() {
        mElv = (ExpandableListView) findViewById(R.id.elv);
        mCheckbox2 = (CheckBox) findViewById(R.id.checkbox2);
        mTvPrice = (TextView) findViewById(R.id.tv_price);
        mTvNum = (TextView) findViewById(R.id.tv_num);
    }
    @Override
    public void onSuccess(MsgBean<List<DataBean>> listMsgBean) {
//        List<SelectBean.DataBean> data = selectBean.getData();

        if (listMsgBean != null) {
            List<DataBean> list = listMsgBean.getData();;
            if (list != null) {
                groupList.addAll(list);
                for (int i = 0; i < list.size(); i++) {
                    List<DataBean.ListBean> datas = list.get(i).getList();
                    childList.add(datas);
                }
                Log.i("====", childList.get(0).get(0).getImages().toString());
                adapter1.notifyDataSetChanged();
                mCheckbox2.setChecked(true);

                adapter1.changeAllListCbState(true);
                mElv.setGroupIndicator(null);
                for (int i = 0; i < groupList.size(); i++) {
                    mElv.expandGroup(i);
                }

            }
        }
    }

    @Override
    public void onFailed(Exception e) {

    }

    @Override
    public void delSuccess(MsgBean msgBean) {
        Toast.makeText(this, msgBean.getMsg(), Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();

    }
    @Subscribe
    public void onMessageEvent(MessageEvent event) {
        mCheckbox2.setChecked(event.isChecked());
    }

    @Subscribe
    public void onMessageEvent(PriceAndCountEvent event) {
        mTvNum.setText("结算(" + event.getCount() + ")");
        mTvPrice.setText("￥" + event.getPrice());
    }

    @Subscribe
    public void onMessageEvent(SomeId event) {
        pid = event.getPid();
        Log.e("==", "我得到了pid:" + pid);
        presenter.delcont(uid, pid);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        if (presenter != null) {
            presenter.detachView();
        }
    }
}