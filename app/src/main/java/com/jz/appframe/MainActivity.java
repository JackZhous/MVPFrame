package com.jz.appframe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jz.appframe.helper.ActBuilder;
import com.jz.appframe.helper.Config;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);



    }


    @OnClick({R.id.btn_click})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_click:
                gotoLogin();
                break;
        }
    }


    private void gotoLogin(){
        new ActBuilder().setSrc(this)
                        .setStringValue("data", "jump to login page")
                        .setTarget(Config.ACT_LOGIN)
                        .toAct(true);
    }
}
