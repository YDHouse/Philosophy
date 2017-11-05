package com.philosophy.yd.yourphilosophy;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;


class C00_ActionBarMain {
    //액티비티 선언
    private AppCompatActivity appCompatActivity;

    //생성자
    C00_ActionBarMain(AppCompatActivity context) {
        this.appCompatActivity = context;
    }

    //커스텀 액션바
    void onCustomActionBar() {
        //커스텀 액션바 선언
        ActionBar actionBar = appCompatActivity.getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayShowCustomEnabled(true);    //커스텀 액션바 사용 여부
            actionBar.setDisplayHomeAsUpEnabled(false);     //내비게이션 아이콘 표시 여부
            actionBar.setDisplayShowTitleEnabled(false);    //타이틀 표시 여부
            actionBar.setDisplayShowHomeEnabled(false);     //홈 아이콘 표시 여부

            //커스텀 액션바 호출
            LayoutInflater inflater = (LayoutInflater) appCompatActivity.getSystemService(LAYOUT_INFLATER_SERVICE);
            View main = inflater.inflate(R.layout.c00_1_actionbar_main, null);

            //액션바 영역에 커스텀 액션바를 삽입
            actionBar.setCustomView(main);
        }
    }
}