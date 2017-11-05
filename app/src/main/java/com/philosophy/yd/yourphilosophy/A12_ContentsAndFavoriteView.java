package com.philosophy.yd.yourphilosophy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.*;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class A12_ContentsAndFavoriteView extends AppCompatActivity implements C12_AdapterContentsView.ViewPagerFavoriteClickListener {

    //DB 관련
    private int sectionNumber = 0;                      //실행 될 쿼리의 section 번호
    private ArrayList<C20_ItemsAll> resultDB = null;    //쿼리 결과가 저정될 리스트

    //뷰페이저 관련
    private ViewPager viewPager;                        //뷰페이저
    private int count;                                  //뷰페이저 총 글의 수를 저장

    //커스텀 다이얼로그
    private C40_CustomDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a12_1_contents_view);

        //커스텀 액션바 메인
        C00_ActionBarMain actionBarMain = new C00_ActionBarMain(this);
        actionBarMain.onCustomActionBar();

        //커스텀 액션바 서브
        C01_ActionBarSub actionBarSub = new C01_ActionBarSub(this);
        actionBarSub.onCustomActionBarSub(2);

        //커스텀 내비게이션 메뉴 드로어
        C02_MenuDrawer menuDrawer = new C02_MenuDrawer(this);
        menuDrawer.onCustomDrawer();

        //부모 클래스에서 보낸 인텐트 값 받기
        Intent i = getIntent();
        sectionNumber = i.getIntExtra("sectionNumber", 0);          //section 번호
        String categoryTitle = i.getStringExtra("categoryTitle");   //소제목
        int position = i.getIntExtra("position", 0);                //리스트뷰 항목 중 클릭된 글의 위치 값

        //소제목을 쓰기 위한 텍스트뷰를 호출하고 가지고 온 인텐트 값을 배치
        TextView title = (TextView) findViewById(R.id.textCategoryTitle);
        title.setText(categoryTitle);

        //queryNumber 값을 기준으로 쿼리를 실행하고 그 결과를 resultDB에 저장
        resultDB = D00_DBManager.dbManager.querySelect(sectionNumber);

        //어댑터 선택
        viewPager = (ViewPager) findViewById(R.id.viewPager);   //뷰페이저 호출
        if (sectionNumber == 0) {
            //색션번호가 0이면 내가 좋아하는 글 처리이므로 C13을 호출하고
            //어댑터 클래스로 context, 커스텀 리스트뷰 레이아웃 정보, 쿼리결과값(resultDB)
            C13_AdapterFavoriteView adapter = new C13_AdapterFavoriteView(this, R.layout.a12_2_contents_view_adapter_items, resultDB);
            //뷰페이저에 어댑터 배치
            viewPager.setAdapter(adapter);
            //[다음 글 or 이전 글] 버튼을 눌렀을 때 더이상 다음 글 (or 이전 글) 이 없으면 토스트 호출하기 위해 글의 갯수를 저장
            count = adapter.getCount();
            //내가 좋아하는 글 목록에서 제거 버튼 표시
            Button btnFavoriteDelete = (Button)findViewById(R.id.btnFavoriteDelete);
            btnFavoriteDelete.setVisibility(View.VISIBLE);
        } else {
            //색션번호가 0이외의 것이면 카테고리 별 처리이므로 C12를 호출한다.
            C12_AdapterContentsView adapter = new C12_AdapterContentsView(this, R.layout.a12_2_contents_view_adapter_items, resultDB, this);
            viewPager.setAdapter(adapter);
            count = adapter.getCount();
        }

        //리스트뷰에서 선택한 글의 번호를 기준으로 처음 표시 될 항목을 결정한다.
        viewPager.setCurrentItem(position);

        //페이지를 넘길 때 좀 더 멋진 효과를 주기 위해 페이지 트랜스포머를 설정
        viewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                float normalizedPosition = Math.abs(1 - Math.abs(position));

                page.setAlpha(normalizedPosition);  //투명도
                page.setScaleX(normalizedPosition); //x축 크기 조절
                page.setScaleY(normalizedPosition); //y축 크기 조절
                page.setRotation(position * 80);    //Y축(세로축) 회전 각도
            }
        });
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

    //이전 글, 다음 글, 즐겨찾기 버튼 클릭 시 액션 적용
    public void onClickedAction(View v) {
        int position;   //현재 위치 값이 저장 될 변수
        switch (v.getId()) {
            //*** 이전 글 ***
            case R.id.btnPrevious:
                position = viewPager.getCurrentItem();              //현재 글의 위치 저장
                if (position > 0) {                                 //현재 글 위치 값이 0보다 크면
                    viewPager.setCurrentItem(position - 1, true);   //포지션 값을 1 빼서 이전 글을 호출
                } else {
                    //첫 번째 글이면 토스트 호출
                    Toast.makeText(this, "첫 번째 글 입니다.", Toast.LENGTH_SHORT).show();
                }
                break;
            //*** 다음 글 ***
            case R.id.btnNext:
                position = viewPager.getCurrentItem();              //현재 글의 위치 저장
                if (position < count -1) {                          //글의 갯수가 저장되어 있는 count 변수보다 포지션 값이 작으면
                    //count 값에 1을 빼는 이유는 ViewPager 에서 글을 불러올 때
                    //0번 글을 호출할 때 다음 글인 1번 글도 함게 가져오기 때문이다.
                    viewPager.setCurrentItem(position + 1, true);   //포지션 값을 1 더해서 다음 글을 호출
                } else {
                    //마지막 글이면 토스트 호출
                    Toast.makeText(this, "마지막 글 입니다.", Toast.LENGTH_SHORT).show();
                }
                break;

            //*** 내가 좋아하는 글 목록에서 제거 ***
            case R.id.btnFavoriteDelete:
                //커스텀 다이얼로그 생성 (context, 내용, 리스너)
                dialog = new C40_CustomDialog(this, "제거", "내가 좋아하는 글 목록에서 제거하시겠습니까?", btnYesListener);
                //다이얼로그 보이기
                dialog.show();
                break;
        }
    }

    //내가 좋아하는 글 목록에서 제거 버튼을 클릭하면 나오는 다이얼로그에서
    //확인 버튼 클릭 시 발생하는 이벤트 리스너
    private View.OnClickListener btnYesListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //내가 좋아하는 글 목록에서 제거하기 위해 DB 업데이트를 한다.
            onPagerFavoriteClick();

            //다이얼로그 닫기
            dialog.dismiss();

            //현재 액티비티 닫기
            A12_ContentsAndFavoriteView.this.finish();
            //현재 액티비티를 닫은 후 A20 클래스의 onRestart() 메소드에서 리스트 목록을 갱신한다.
        }
    };

    //어댑터와의 인터페이스 (페이저뷰의 별 아이콘이 클릭되면  항목의 위치 값을 가져와서 처리)
    @Override
    public ArrayList<C20_ItemsAll> onPagerFavoriteClick() {
        //현재 표시되고 있는 항목을 기준으로 포지션 값을 정한다.
        int position = viewPager.getCurrentItem();

        //내가 좋아하는 글의 별 아이콘 온.오프 값 가져오기 (1:온, 0:오프)
        int favoriteValue = Integer.parseInt(resultDB.get(position).getFavorite());

        //변경 대상이 되는 항목의 고유 ID 가져오기
        int contentId = Integer.parseInt(resultDB.get(position).getContentId());

        //favoriteValue, contentId 값을 전송해서 업데이트 쿼리 실행
        D00_DBManager.dbManager.favoriteUpdate(favoriteValue, contentId);

        //별 아이콘의 최신의 상태를 반영하기 위해 select 쿼리를 다시 한 번 실행하고
        //그 결과를 resultDB에 저장한 후 어댑터로 리턴한다.
        resultDB = D00_DBManager.dbManager.querySelect(sectionNumber);

        return resultDB;
    }
}