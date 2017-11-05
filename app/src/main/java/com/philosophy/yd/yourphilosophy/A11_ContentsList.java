package com.philosophy.yd.yourphilosophy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class A11_ContentsList extends AppCompatActivity implements C10_AdapterContentsList.ListViewFavoriteClickListener {

    //DB 관련
    private int sectionNumber = 0;                      //실행 될 쿼리의 section 번호
    private ArrayList<C20_ItemsAll> resultDB = null;    //쿼리 결과가 저정될 리스트

    //리스트뷰 관련
    private C10_AdapterContentsList adapter;            //리스트뷰 어댑터
    private ListView listView;                          //리스트뷰

    private String categoryTitle = "";                  //소제목

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a11_1_contents_list);

        //커스텀 액션바 메인
        C00_ActionBarMain actionBarMain = new C00_ActionBarMain(this);
        actionBarMain.onCustomActionBar();

        //커스텀 액션바 서브
        C01_ActionBarSub actionBarSub = new C01_ActionBarSub(this);
        actionBarSub.onCustomActionBarSub(2);

        //커스텀 내비게이션 메뉴 드로어
        C02_MenuDrawer menuDrawer = new C02_MenuDrawer(this);
        menuDrawer.onCustomDrawer();

        //부모 액티비티에서 보낸 인텐트 값 받기
        Intent i = getIntent();
        sectionNumber = i.getIntExtra("sectionNumber", 0); //카테고리 구분 태그
        categoryTitle = i.getStringExtra("categoryTitle"); //소제목

        //소제목을 쓰기 위한 텍스트뷰를 호출하고 가지고 온 인텐트 값을 배치
        TextView title = (TextView)findViewById(R.id.textCategoryTitle);
        title.setText(categoryTitle);

        //sectionNumber 를 기준으로 쿼리를 실행하고 그 결과를 resultDB에 저장
        resultDB = D00_DBManager.dbManager.querySelect(sectionNumber);

        //어댑터로 context, 커스텀 리스트뷰 레이아웃, 쿼리 결과 값(resultDB), 리스너 인터페이스를 전송
        adapter = new C10_AdapterContentsList(this, R.layout.a11_2_contents_list_adapter_items, resultDB, this);

        //최종적으로 리스트뷰에 표시 될 값들을 배치한다.
        listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(adapter);

        //리스트뷰 클릭 이벤트
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                //전달할 인텐트 지정
                Intent i = new Intent(A11_ContentsList.this, A12_ContentsAndFavoriteView.class);

                //새로운 인텐트를 띄울 때 DB의 값을 함께 전달한다.
                i.putExtra("sectionNumber", sectionNumber);
                i.putExtra("categoryTitle", categoryTitle);
                i.putExtra("position", position);

                //새로운 액티비티 화면에 띄우기
                startActivity(i);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //현 클래스로 다시 돌아왔을 때 별 아이콘의 상태를 최신 상태로
        //새로고침 하기 위하여 어댑터를 다시 호출한다.
        resultDB = D00_DBManager.dbManager.querySelect(sectionNumber);
        adapter = new C10_AdapterContentsList(this, R.layout.a11_2_contents_list_adapter_items, resultDB, this);
        listView.setAdapter(adapter);
    }

    //물리적 백버튼 클릭 이벤트
    @Override
    public void onBackPressed() {
        //드로어 레이아웃을 불러와서
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //만약 드로어 레이아웃 오픈된 상태일 경우에는
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            //드로어 레이아웃을 닫고
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            //드로어 레이아웃 닫힌 상태일 경우에는 백버튼 이벤트를 실행한다.
            super.onBackPressed();
        }
    }

    //어댑터와의 인터페이스 (리스트뷰의 별 아이콘이 클릭되면 항목의 위치 값을 가져와서 처리)
    @Override
    public void onFavoriteClick(int position) {
        //내가 좋아하는 글의 별 아이콘 온.오프 값 가져오기 (1:온, 0:오프)
        int favoriteValue = Integer.parseInt(resultDB.get(position).getFavorite());

        //변경 대상이 되는 항목의 고유 ID 가져오기
        int contentId = Integer.parseInt(resultDB.get(position).getContentId());

        //favoriteValue, contentId 값을 전송해서 업데이트 쿼리 실행
        D00_DBManager.dbManager.favoriteUpdate(favoriteValue, contentId);

        //별 아이콘의 최신의 상태를 반영하기 위해 select 쿼리를 다시 한 번 실행하고 그 결과를 resultDB에 저장한다.
        resultDB = D00_DBManager.dbManager.querySelect(sectionNumber);
    }
}