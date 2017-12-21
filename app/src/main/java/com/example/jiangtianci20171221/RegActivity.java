package com.example.jiangtianci20171221;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jiangtianci20171221.presenter.RegPresenter;
import com.example.jiangtianci20171221.view.IRegView;


public class RegActivity extends AppCompatActivity implements IRegView {

    private EditText et_name;
    private EditText et_pass;
    private Button btn;

    RegPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        initView();
        presenter = new RegPresenter(this,this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.reg();
            }
        });

    }

    private void initView() {
        et_name = (EditText) findViewById(R.id.et_namereg);
        et_pass = (EditText) findViewById(R.id.et_passreg);
        btn = (Button) findViewById(R.id.btn_reg);
    }

    @Override
    public void setName(String name) {
        et_name.setText(name);
    }

    @Override
    public String getName() {
        return et_name.getText().toString();
    }

    @Override
    public void setPass(String pass) {
        et_pass.setText(pass);
    }

    @Override
    public String getPass() {
        return et_pass.getText().toString();
    }
}
