package com.philosophy.yd.yourphilosophy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;


class C13_AdapterFavoriteView extends android.support.v4.view.PagerAdapter {

    private LayoutInflater inflater;
    private int layout;
    private ArrayList<C20_ItemsAll> data;

    C13_AdapterFavoriteView(Context context, int layout, ArrayList<C20_ItemsAll> data) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layout = layout;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //뷰를 생성해서 파라메터로 가져온 레이아웃을 배치한다.
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

        //별 아이콘(체크박스)은 불필요하므로 비표시
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.favorite);
        checkBox.setVisibility(View.INVISIBLE);

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