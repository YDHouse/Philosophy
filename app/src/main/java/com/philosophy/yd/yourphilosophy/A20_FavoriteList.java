package com.philosophy.yd.yourphilosophy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class A20_FavoriteList extends AppCompatActivity {

    //DB 관련
    private ArrayList<C20_ItemsAll> favoriteDB = null;  //쿼리 결과가 저정될 리스트

    //리스트뷰 관련
    private C11_AdapterFavoriteList adapter;            //리스트뷰 어댑터
    private ListView listView;                          //리스트뷰

    //버튼 활성.비활성 여부 판단을 위한 버튼 호출
    private Button btnSelectAll;
    private Button btnSelectCancel;
    private Button btnSelectDelete;

    //어댑터에서 가지고 온 contentId가 저장되어 있는 리스트
    private ArrayList<String> listContentId = null;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a20_1_favorite_list);

        //커스텀 액션바 메인
        C00_ActionBarMain actionBarMain = new C00_ActionBarMain(this);
        actionBarMain.onCustomActionBar();

        //커스텀 액션바 서브
        C01_ActionBarSub actionBarSub = new C01_ActionBarSub(this);
        actionBarSub.onCustomActionBarSub(2);

        //커스텀 내비게이션 메뉴 드로어
        C02_MenuDrawer menuDrawer = new C02_MenuDrawer(this);
        menuDrawer.onCustomDrawer();

        //소제목 입력
        TextView title = (TextView)findViewById(R.id.textCategoryTitle);
        title.setText("내가 좋아하는 글");

        //내가 좋아하는 글 목록을 불러오기 위해 querySelect 0을 입력해서 쿼리를 실행하고 그 결과를 favoriteDB에 저장
        favoriteDB = D00_DBManager.dbManager.querySelect(0);

        //어댑터 클래스로 context, 커스텀 리스트뷰 레이아웃, 쿼리결과값(resultDB) 전송
        adapter = new C11_AdapterFavoriteList(this, R.layout.a20_2_favorite_list_adapter_items, favoriteDB, checkboxCheckedListener);

        //최종적으로 리스트뷰에 표시 될 값들을 배치한다.
        listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(adapter);

        //리스트뷰 클릭 이벤트
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                //내가 좋아하는 글을 등록하지 않았을 경우를 대비해서 contentId의 값이 null 인지 확인한다.
                //실제로는 contentId 뿐만 아니라 내가 좋아하는 글이 등록되어 있지 않을 경우에는 dbManager 에서
                //content, author, favorite 값 모두 null 로 지정하지만 확인은 하나만 하면 되기 때문에 contentId만 확인한다.
                if (favoriteDB.get(0).getContentId() != null) {
                    //전달할 인텐트 지정
                    Intent i = new Intent(A20_FavoriteList.this, A12_ContentsAndFavoriteView.class);

                    //새로운 인텐트를 띄울 때 DB의 값을 함께 전달한다.
                    i.putExtra("position", position);
                    i.putExtra("categoryTitle", "내가 좋아하는 글");
                    //원래는 섹션넘버도 함께 보내야 하지만 자식 클래스에서 인텐트 값을 받을 때
                    //섹션넘버 디폴트 값을 0으로 지정해 놓기 때문에 굳이 보낼 필요는 없다.

                    //새로운 액티비티 화면에 띄우기
                    startActivity(i);
                } else {
                    //contentId가 null 인 경우에는 토스트를 띄운다.
                    Toast.makeText(A20_FavoriteList.this, "먼저 좋아하는 글의 별을 눌러서 좋아하는 글로 등록해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //어댑터의 checkedItems() 메소드의 값을 리턴 받아와서
        //선택된 항목들의 contentId 값을 list 배열에 저장한다.
        listContentId = adapter.checkedItems();

        //모두 선택, 선택 해제, 선택 항목 삭제 버튼의 활성.비활성 여부를 결정하기 위해 버튼 호출
        btnSelectAll = (Button)findViewById(R.id.btnSelectAll);
        btnSelectCancel = (Button)findViewById(R.id.btnSelectCancel);
        btnSelectDelete = (Button)findViewById(R.id.btnSelectDelete);

        //DB 쿼리 결과 값에 null 이 들어가 있으면 내가 좋아하는 글이 하나도 없는 것이므로
        if (favoriteDB.get(0).getContentId() == null) {
            //모두 선택 버튼을 비활성화
            btnSelectAll.setEnabled(false);
        } else {
            //null 이 아니면 모두 선택 버튼을 활성화
            btnSelectAll.setEnabled(true);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //현 클래스로 다시 돌아왔을 때 내가 좋아하는 글 목록을
        //새로고침 하기 위하여 DB 값을 다시 받아오고, 어댑터도 다시 실행한다.
        favoriteDB = D00_DBManager.dbManager.querySelect(0);
        adapter = new C11_AdapterFavoriteList(this, R.layout.a20_2_favorite_list_adapter_items, favoriteDB, checkboxCheckedListener);
        listView.setAdapter(adapter);

        //상세보기에서 뒤로 왔을 때 체크박스는 모두 체크가 되지 않은 상태로 되기 때문에
        //모두 선택, 선택 항목 삭제 버튼을 비활성화 시켜야 한다.
        btnSelectCancel.setEnabled(false);
        btnSelectDelete.setEnabled(false);
    }

    //어댑터와의 리스너를 통해서 체크박스에 체크가 되거나 해제가 되면
    //리스트의 사이즈에 따라서 버튼의 활성.비활성 여부를 결정한다.
    private View.OnClickListener checkboxCheckedListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //onCreate() 메소드에서 값을 받아오지만 onRestart() 메소드 구동 시에도
            //갱신해야 하므로 여기에서 다시 값을 받아야 한다.
            listContentId = adapter.checkedItems();

            //리스트의 수가 1 이상이면 버튼 활성화
            if (listContentId.size() <= 1) {
                btnSelectCancel.setEnabled(true);
                btnSelectDelete.setEnabled(true);
            }
            //리스트의 수가 0이 되면 버튼 비활성
            if (listContentId.size() == 0) {
                btnSelectCancel.setEnabled(false);
                btnSelectDelete.setEnabled(false);
            }
        }
    };

    //모두 선택, 선택 해제, 선택 항목 삭제 버튼 이벤트
    public void onClickedFavorite(View v) {
        switch (v.getId()) {
            // *** 모두 선택 ***
            case R.id.btnSelectAll:
                adapter.setAllChecked(true);    //어댑터에 true 값을 보낸다.
                adapter.notifyDataSetChanged(); //어댑터 새로고침

                //선택 해제, 선택 항목 삭제 버튼을 활성화
                btnSelectCancel.setEnabled(true);
                btnSelectDelete.setEnabled(true);

                break;

            // *** 선택 해제 ***
            case R.id.btnSelectCancel:
                adapter.setAllChecked(false);   //어댑터에 false 값을 보낸다.
                adapter.notifyDataSetChanged(); //어댑터 새로고침

                //선택 해제, 선택 항목 삭제 버튼을 비활성화
                btnSelectCancel.setEnabled(false);
                btnSelectDelete.setEnabled(false);

                break;

            // *** 선택 항목 삭제 ***
            case R.id.btnSelectDelete:
                //어댑터의 checkedItems() 메소드의 값을 리턴 받아와서
                //선택된 항목들의 contentId 값을 list 배열에 저장한다.
                //onCreate() 메소드에서 값을 받아오지만 선택 항목 삭제 버튼을 누를 때마다
                //갱신해야 하므로 여기에서 다시 값을 받아야 한다.
                listContentId = adapter.checkedItems();

                //listContentId 의 크기만큼 반복해서 업데이트 쿼리를 실행
                for (int i=0; i<listContentId.size(); i++) {
                    //contentId 별로 update 쿼리를 실행해서 favorite 컬럼의 값을 0으로 변경 (1로 보내야 조건문에서 0으로 변경된다.)
                    D00_DBManager.dbManager.favoriteUpdate(1, Integer.parseInt(listContentId.get(i)));
                }
                //리스트뷰의 상태를 최신의 상태로 보여주기 위해
                //notifyDataSetChanged() 함수를 사용해도 갱신이 되지 않는다.
                //갱신을 위해서는 DB 와의 연동 작업이 필요하므로 notifyDataSetChanged() 함수는
                //사용하지 않고 아래의 작업을 다시 한 번 실행한다.
                favoriteDB = D00_DBManager.dbManager.querySelect(0);
                adapter = new C11_AdapterFavoriteList(A20_FavoriteList.this, R.layout.a20_2_favorite_list_adapter_items, favoriteDB, checkboxCheckedListener);
                listView.setAdapter(adapter);

                //DB 쿼리 결과 값에 null 이 들어가 있으면 내가 좋아하는 글이 하나도 없는 것이므로
                if (favoriteDB.get(0).getContentId() == null) {
                    //모두 선택 버튼을 비활성화
                    btnSelectAll.setEnabled(false);
                }

                //선택 해제, 선택 항목 삭제 버튼을 비활성화
                btnSelectCancel.setEnabled(false);
                btnSelectDelete.setEnabled(false);

                break;
        }
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
}