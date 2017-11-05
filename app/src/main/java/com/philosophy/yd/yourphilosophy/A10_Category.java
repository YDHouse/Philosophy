package com.philosophy.yd.yourphilosophy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class A10_Category extends AppCompatActivity {

    //뒤로가기 두 번 클릭 시 앱 종료
    private C30_BackFinish backFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a10_1_category);

        //데이터베이스 삭제
        //getApplication().deleteDatabase("YourPhilosophy.db");

        //데이터베이스 생성
        //(메뉴 드로어에서 DB를 사용하기 때문에 A10에서 DB 생성을 해 주어야 한다.)
        new D00_DBManager(this);

        //뒤로가기 두 번 클릭 시 앱 종료
        backFinish = new C30_BackFinish(this);

        //커스텀 액션바 메인
        C00_ActionBarMain actionBarMain = new C00_ActionBarMain(this);
        actionBarMain.onCustomActionBar();

        //커스텀 액션바 서브
        C01_ActionBarSub actionBarSub = new C01_ActionBarSub(this);
        actionBarSub.onCustomActionBarSub(1);

        //커스텀 내비게이션 메뉴 드로어
        C02_MenuDrawer menuDrawer = new C02_MenuDrawer(this);
        menuDrawer.onCustomDrawer();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //현 클래스로 다시 돌아왔을 때 메뉴 드로어의 내가 좋아하는 글 총 수를
        //새로고침 하기 위하여 메뉴 드로어를 다시 실행한다.
        C02_MenuDrawer menuDrawer = new C02_MenuDrawer(this);
        menuDrawer.onCustomDrawer();
    }

    //뒤로가기 두 번 클릭하면 앱 종료
    //onCreate 메소드에 뒤로가기 효과를 적용하면 액티비티가 호출되면서 뒤로가기 버튼 효과가 먹기 때문에 따로 빼야 한다.
    public void onBackPressed() {
        //드로어 레이아웃을 불러와서
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //만약 드로어 레이아웃 오픈된 상태일 경우에는
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            //드로어 레이아웃을 닫고
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            //드로어 레이아웃 닫힌 상태일 경우에는 백버튼 이벤트를 실행한다.
            backFinish.onBackPressed();
        }
    }

    //카테고리 버튼 클릭 이벤트
    public void onClickCategory(View v) {
        //클릭 된 버튼을 구분하기 위해 버튼 별 태그 값을 가져온다.
        String getTag = (String) v.getTag();

        //가져 온 태그 값을 "/"를 기준으로 분할한다.
        String[] tagSplit = getTag.split("/");

        //0번 방에는 섹션 번호가
        int sectionNumber = Integer.parseInt(tagSplit[0]);

        //1번 방에는 카테고리 소제목이 들어있다.
        String categoryTitle = tagSplit[1];

        //인텐트 생성
        Intent i = new Intent(A10_Category.this, A11_ContentsList.class);

        //인텐트를 넘길 때 카테고리 별로 구분할 수 있게 태그 값과 소제목 값을 전달
        i.putExtra("sectionNumber", sectionNumber);
        i.putExtra("categoryTitle", categoryTitle);
        startActivity(i);
    }
}
