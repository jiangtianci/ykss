package com.example.jiangtianci20171221;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jiangtianci20171221.presenter.LoginPresenter;
import com.example.jiangtianci20171221.view.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    private EditText et_name;
    private EditText et_pass;
    private Button btn;
    LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        initView();
        presenter = new LoginPresenter(this, (ILoginView) this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.login();
            }
        });

    }

    private void initView() {
        et_name = (EditText) findViewById(R.id.et_name);
        et_pass = (EditText) findViewById(R.id.et_pass);
        btn = (Button) findViewById(R.id.btn_login);
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
