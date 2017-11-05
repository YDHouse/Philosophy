package com.philosophy.yd.yourphilosophy;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;


class C02_MenuDrawer {
    //액티비티 선언
    private AppCompatActivity appCompatActivity;

    //메뉴 드로어
    private DrawerLayout drawerLayout;

    //메뉴 드로어가 위치 할 레이아웃
    private LinearLayout navLayout;

    //커스텀 다이얼로그
    private C40_CustomDialog dialog;

    //생성자
    C02_MenuDrawer(AppCompatActivity context) {
        this.appCompatActivity = context;
    }

    //커스텀 액션바 서브 (커스텀 액션바 밑에 레이아웃을 추가해서 툴바처럼 사용)
    void onCustomDrawer() {
        //드로어 레이아웃 호출
        drawerLayout = (DrawerLayout)appCompatActivity.findViewById(R.id.drawer_layout);
        //내비게이션 드로어가 있는 레이아웃의 아이디를 가져와서 layout 변수에 담아둔다.
        LinearLayout layout = (LinearLayout) View.inflate(appCompatActivity, R.layout.c02_1_menu_drawer, null);
        //현재 액티비티의 특정위치(여기서는 navigation_layout)에 가지고 온 layout 을 배치하기 위해 호출
        navLayout = (LinearLayout)appCompatActivity.findViewById(R.id.navigation_layout);
        //호출한 레이아웃에 내비게이션 드로어가 있는 레이아웃을 넣는다.
        navLayout.addView(layout);

        //리스트뷰와 내가 좋아하는 글 총 수 관련
        ArrayList<C21_ItemsDrawer> list = new ArrayList<>();
        loadItems(list);            //내가 좋아하는 글의 총 수 DB 쿼리 실행도 포함
        //리스트뷰 어댑터 생성
        C14_AdapterMenuDrawer adapter = new C14_AdapterMenuDrawer(appCompatActivity, R.layout.c02_2_menu_drawer_adapter_items, list);
        ListView listView = (ListView)appCompatActivity.findViewById(R.id.drawer_listView);
        listView.setAdapter(adapter);

        //리스트뷰 클릭 이벤트
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                if (position == 0) {
                    //********* 내가 좋아하는 글 *********
                    Intent intentFavorite = new Intent(appCompatActivity, A20_FavoriteList.class);
                    //띄우려는 액티비티가 스택 맨위에 실행 중이라면 다시 호출하지 않고 재사용한다.
                    intentFavorite.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    appCompatActivity.startActivity(intentFavorite);
                } else if (position == 1) {
                    //********* 메인 화면으로 이동 *********
                    Intent intentHome = new Intent(appCompatActivity, A10_Category.class);
                    //현재 액티비티에서 어느 액티비티로 이동할 때, 중간에 남아있는 액티비티들이 있다면 삭제한다.
                    intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    //띄우려는 액티비티가 스택 맨위에 실행 중이라면 다시 호출하지 않고 재사용한다.
                    intentHome.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    appCompatActivity.startActivity(intentHome);
                } else {
                    //********* 앱 완전 종료 *********
                    //커스텀 다이얼로그 생성 (context, 내용, 리스너)
                    dialog = new C40_CustomDialog(appCompatActivity, "종료", "앱을 종료하시겠습니까?", btnYesListener);
                    //다이얼로그 보이기
                    dialog.show();
                }
                //리스트뷰 항목을 클릭하면 내비게이션 드로어가 닫힌다.
                drawerLayout.closeDrawer(navLayout);
            }
        });

        //커스텀 액션바 서브의 리스트 버튼 클릭 시 내비게이션 드로어 오픈
        Button btnList = (Button)appCompatActivity.findViewById(R.id.iconMenu);
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        //메뉴 드로어의 닫기 버튼을 누르면 드로어 닫기
        Button btnCloseDrawer = (Button)appCompatActivity.findViewById(R.id.btnCloseDrawer);
        btnCloseDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
    }

    //앱 종료 버튼을 클릭하면 나오는 다이얼로그에서 확인 버튼 클릭 시 발생하는 이벤트 리스너
    private View.OnClickListener btnYesListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //다이얼로그 닫기
            dialog.dismiss();
            //앱 완전 종료 (열려 있는 모든 액티비티 종료)
            appCompatActivity.finishAffinity();
        }
    };

    //리스트뷰에 들어갈 아이템 생성
    private boolean loadItems(ArrayList<C21_ItemsDrawer> list) {
        //list 배열에 담을 item 변수 선언
        C21_ItemsDrawer item;

        //내가 좋아하는 글의 총 수 DB 쿼리 실행하고 변수에 저장
        int favoriteCount = D00_DBManager.dbManager.favoriteCount();

        if (list == null) {
            list = new ArrayList<>();
        }

        item = new C21_ItemsDrawer();
        item.setIconDrawable(ContextCompat.getDrawable(appCompatActivity, R.drawable.icon_star));
        item.setNavTitle("내가 좋아하는 글");
        item.setFavoriteCount("" + favoriteCount);
        list.add(item);

        item = new C21_ItemsDrawer();
        item.setIconDrawable(ContextCompat.getDrawable(appCompatActivity, R.drawable.nav_icon_home));
        item.setNavTitle("메인 화면으로 이동");
        list.add(item);

        item = new C21_ItemsDrawer();
        item.setIconDrawable(ContextCompat.getDrawable(appCompatActivity, R.drawable.nav_icon_end));
        item.setNavTitle("앱 종료");
        list.add(item);

        return true;
    }
}