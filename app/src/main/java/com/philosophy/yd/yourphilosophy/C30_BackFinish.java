package com.philosophy.yd.yourphilosophy;

import android.app.Activity;
import android.widget.Toast;


class C30_BackFinish {
    private long backKeyPressedTime = 0;
    private Toast toast;
    private Activity activity;

    C30_BackFinish(Activity context) {
        this.activity = context;
    }

    void onBackPressed() {
        //currentTimeMillis 함수를 이용하여 2초 이내에 백버튼이 눌러졌는지 판단
        //currentTimeMillis 함수는 표준시간(UTC)과의 사이에 발생하는 차이를 long 타입으로 반환
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            showGuide();
        } else if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            activity.finish();
            toast.cancel();
        }
    }

    private void showGuide() {
        toast = Toast.makeText(activity,
                "\'뒤로\'버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT);
        toast.show();
    }
}
