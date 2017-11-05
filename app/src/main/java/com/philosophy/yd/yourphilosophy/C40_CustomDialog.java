package com.philosophy.yd.yourphilosophy;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;


class C40_CustomDialog extends Dialog {

    private String dialogTitle;                     //다이얼로그에 반영할 제목
    private String dialogContent;                   //다이얼로그에 반영할 내용
    private View.OnClickListener btnYesListener;    //확인 버튼 클릭 리스너

    C40_CustomDialog(Context context, String dialogTitle, String dialogContent, View.OnClickListener btnYesListener) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.dialogTitle = dialogTitle;
        this.dialogContent = dialogContent;
        this.btnYesListener = btnYesListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //다이얼로그 외부영역 흐리게 표시
        WindowManager.LayoutParams window = new WindowManager.LayoutParams();
        window.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        window.dimAmount = 0.8f;
        getWindow().setAttributes(window);

        //레이아웃 배치
        setContentView(R.layout.a12_3_custom_dialog);

        //텍스트뷰 호출
        TextView textDialogTitle = (TextView)findViewById(R.id.textDialogTitle);        //타이틀
        TextView textDialogContent = (TextView)findViewById(R.id.textDialogContent);    //내용

        //확인, 취소 버튼 호출
        Button btnYes = (Button)findViewById(R.id.btnYes);
        Button btnCancel = (Button)findViewById(R.id.btnCancel);

        //생성자에서 가져온 텍스트 반영
        textDialogTitle.setText(dialogTitle);
        textDialogContent.setText(dialogContent);

        //확인 버튼 클릭 이벤트
        btnYes.setOnClickListener(btnYesListener);

        //취소 버튼 클릭 이벤트
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                C40_CustomDialog.this.cancel();
            }
        });
    }
}
