package com.philosophy.yd.yourphilosophy;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


class C01_ActionBarSub {
    //액티비티 선언
    private AppCompatActivity appCompatActivity;

    //뒤로가기 연속으로 두 번 눌렀을 때 앱 종료
    private C30_BackFinish backFinish;

    //생성자
    C01_ActionBarSub(AppCompatActivity context) {
        this.appCompatActivity = context;
    }

    //커스텀 액션바 서브 (커스텀 액션바 밑에 레이아웃을 추가해서 툴바처럼 사용)
    void onCustomActionBarSub(int changeValue) {

        //액션바 서브가 있는 레이아웃의 아이디를 가져와서 layout 변수에 담아둔다.
        LinearLayout layout = (LinearLayout) View.inflate(appCompatActivity, R.layout.c01_1_actionbar_sub, null);

        //현재 액티비티의 특정위치(여기서는 custom_actionbar_sub_layout)에 가지고 온 layout 을 배치하기 위해 호출
        LinearLayout linear = (LinearLayout)appCompatActivity.findViewById(R.id.custom_actionbar_sub_layout);

        //호출한 레이아웃에 액션바 서브가 있는 레이아웃을 넣는다.
        linear.addView(layout);

        //각 각의 액티비티에 필요한 커스텀 액선바 서브의 메뉴만 보이게 하기 위해 조건문 설정
        //디폴트가 invisible 이기 때문에 필요한 것만 visible 로 변경, 메뉴버튼은 항상 visible 이기 때문에 제외
        if (changeValue == 1) {
            //뒤로가기 두 번 클릭 시 앱 종료 효과 호출
            backFinish = new C30_BackFinish(appCompatActivity);

            //값이 1인 경우에는 종료하기 아이콘을 표시
            Button button_exit = (Button)appCompatActivity.findViewById(R.id.iconExit);
            button_exit.setVisibility(View.VISIBLE);
            button_exit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    backFinish.onBackPressed();
                }
            });
        } else {
            //값이 2인 경우에는 뒤로가기 아이콘을 표시
            Button button_back = (Button)appCompatActivity.findViewById(R.id.iconBack);
            button_back.setVisibility(View.VISIBLE);
            button_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    appCompatActivity.onBackPressed();
                }
            });
        }
    }
}