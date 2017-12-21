package com.example.jiangtianci20171221;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.jiangtianci20171221.adapter.MyAdapter;
import com.example.jiangtianci20171221.api.API;
import com.example.jiangtianci20171221.bean.Bean;
import com.example.jiangtianci20171221.presenter.Persenter;
import com.example.jiangtianci20171221.view.Iview;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Iview {
    private RecyclerView recycler;
    private MyAdapter adapter;
    private Persenter presenter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(linearLayoutManager);
        presenter = new Persenter(this);
        presenter.loadlist(API.Demo);
    }
    @Override
    public void Success(List<Bean.DataBean> list) {
        adapter=new MyAdapter(MainActivity.this,list);
        recycler.setAdapter(adapter);
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener(

        ){
            @Override
            public void onItemClick(View view , int position){
                Toast.makeText(MainActivity.this, "您点击了第"+position+"条数据", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(MainActivity.this,GouwucheActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.distory();
    }
}
