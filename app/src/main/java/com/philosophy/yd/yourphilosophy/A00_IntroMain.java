package com.philosophy.yd.yourphilosophy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class A00_IntroMain extends Activity{
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a00_1_intro_main);

        handler = new Handler();

        //1초 후에 runActivity 함수 실행
        handler.postDelayed(runActivity, 1000);
    }

    //1초 후에 인트로 메인 클래스는 닫고 인트로 서브 클래스를 호출
    Runnable runActivity = new Runnable() {
        @Override
        public void run() {
            Intent i = new Intent(A00_IntroMain.this, A01_IntroSub.class);
            startActivity(i);
            finish();
        }
    };
}
