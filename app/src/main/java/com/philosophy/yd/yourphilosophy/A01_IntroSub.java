package com.philosophy.yd.yourphilosophy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class A01_IntroSub extends Activity{

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a01_1_intro_sub);

        //시작, 종료 버튼 호출
        Button btnAppStart = (Button)findViewById(R.id.btnAppStart);
        Button btnAppEnd = (Button)findViewById(R.id.btnAppEnd);

        //시작 버튼 클릭 시 카테고리 액티비티 호출
        btnAppStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(A01_IntroSub.this, A10_Category.class);
                startActivity(i);
                finish();
            }
        });

        //종료 버튼 클릭 시 앱 종료
        btnAppEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
