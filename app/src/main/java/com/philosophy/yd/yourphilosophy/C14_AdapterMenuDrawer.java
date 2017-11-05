package com.philosophy.yd.yourphilosophy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


class C14_AdapterMenuDrawer extends BaseAdapter {

    //생성자에서 사용할 값들
    private LayoutInflater inflater;
    private int layout;
    public ArrayList<C21_ItemsDrawer> data;

    //생성자
    C14_AdapterMenuDrawer(Context context, int layout, ArrayList<C21_ItemsDrawer> data) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layout = layout;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = inflater.inflate(layout, parent, false);
        }

        //data 리스트에 있는 값을 position 별로 꺼내서 items 변수에 저장한다.
        C21_ItemsDrawer items = data.get(position);

        //리스트뷰에 표시 될 아이템들의 id를 호출
        ImageView navIcon = (ImageView)convertView.findViewById(R.id.navIcon);   //아이콘
        TextView navTitle = (TextView) convertView.findViewById(R.id.navTitle);  //제목
        TextView navFavoriteCount = (TextView) convertView.findViewById(R.id.navFavoriteCount);  //내가 좋아하는 글의 총 수

        //리스트뷰에 표시 될 아이템들에 값 지정
        navIcon.setImageDrawable(items.getIconDrawable());  //이미지
        navTitle.setText(items.getNavTitle());              //타이틀
        navFavoriteCount.setText(items.getFavoriteCount()); //내가 좋아하는 글의 총 수

        return convertView;
    }
}