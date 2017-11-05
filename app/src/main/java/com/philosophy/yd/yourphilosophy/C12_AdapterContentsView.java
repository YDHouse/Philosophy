package com.philosophy.yd.yourphilosophy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;


class C12_AdapterContentsView extends android.support.v4.view.PagerAdapter {

    //A12_ContentsAndFavoriteView 클래스와 인터페이스 구축 (뷰페이저의 별 아이콘 클릭 시 이벤트 발생)
    interface ViewPagerFavoriteClickListener {
        ArrayList<C20_ItemsAll> onPagerFavoriteClick();
    }

    private LayoutInflater inflater;
    private int layout;
    private ArrayList<C20_ItemsAll> data;
    private ViewPagerFavoriteClickListener viewPagerFavoriteClickListener;    //즐겨찾기 인터페이스

    C12_AdapterContentsView(Context context, int layout, ArrayList<C20_ItemsAll> data, ViewPagerFavoriteClickListener favoriteClickListener) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layout = layout;
        this.data = data;
        this.viewPagerFavoriteClickListener = favoriteClickListener;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //뷰를 생성해서 파라메터로 가져온 레이아웃(여기서는 a12_2_contents_view_adapter_items.xmlView_adapterItems.xml)을 배치한다.
        View view = inflater.inflate(layout, container, false);

        //data 리스트에 있는 값을 position 별로 꺼내서 items 변수에 저장한다.
        C20_ItemsAll items = data.get(position);

        //글의 내용
        TextView textContent = (TextView) view.findViewById(R.id.textContent);
        textContent.setText((items.getContent()));

        //글의 저자
        TextView textAuthor = (TextView) view.findViewById(R.id.textAuthor);
        textAuthor.setText((items.getAuthor()));

        //글의 주석 (주석은 null 이 허용되기 때문에 null 일 경우에는 아무것도 표시되지 않는다.)
        TextView textAnnotation = (TextView) view.findViewById(R.id.textAnnotation);
        textAnnotation.setText((items.getAnnotation()));

        /* ******************************************************
         * 즐겨찾기 기능 관련 - 초기 즐겨찾기 아이콘 모양 결정
         * ******************************************************/
        //즐겨찾기 아이콘 온,오프 값 설정 (1:온, 0:오프)
        int favoriteNo = Integer.parseInt(items.getFavorite());

        //즐겨찾기 아이콘의 이미지뷰 아이디 호출
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.favorite);

        //즐겨찾기 아이콘 모양 결정
        if (favoriteNo == 0) {
            //favorite 칼럼의 값이 0인 경우에는 아이콘의 모양을 클릭하지 않은 별의 모양으로 설정
            checkBox.setChecked(false);
        } else {
            //favorite 칼럼의 값이 1인 경우에는 아이콘의 모양을 클릭한 별의 모양으로 설정
            checkBox.setChecked(true);
        }

        //즐겨찾기 아이콘 클릭 시 인터페이스 실행
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인터페이스가 연결된 A12_ContentsAndFavoriteView 클래스의 onPagerFavoriteClick() 메소드를 실행시켜서 최신의 DB 값을 리턴 받는다.
                data = viewPagerFavoriteClickListener.onPagerFavoriteClick();
            }
        });

        //ViewPager 에서 만든 View 를 추가해서 이미지화 하여 페이지 넘기는 효과를 줄 수 있다.
        container.addView(view);

        return view;
    }

    //메모리 관리를 위한 화면에 보이지 않는 view 삭제
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    //instantiateItem() 메소드에서 리턴 된 오브젝트가 뷰가 맞는지 확인
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}