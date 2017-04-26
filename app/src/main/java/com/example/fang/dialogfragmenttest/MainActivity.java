package com.example.fang.dialogfragmenttest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginDialogFragment.LoginInputListener {
    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDo();
    }

    private void initView() {
        btn1= (Button) findViewById(R.id.btn1);
        btn2= (Button) findViewById(R.id.btn2);
    }

    private void initDo() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initFra();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initFra2();
            }
        });
    }

    private void initFra2() {
        LoginDialogFragment loginDialogFragment=new LoginDialogFragment();
        loginDialogFragment.show(getFragmentManager(),"LoginDialogFragment");
    }

    private void initFra() {
        MyDialogFragement myDialogFragement=new MyDialogFragement();
        myDialogFragement.show(getFragmentManager(),"MyDialogFragement");

    }

    public void onLoginInputComplete(String username, String password)
    {
        Toast.makeText(this, "帐号：" + username + ",  密码 :" + password,
                Toast.LENGTH_SHORT).show();
    }

}
