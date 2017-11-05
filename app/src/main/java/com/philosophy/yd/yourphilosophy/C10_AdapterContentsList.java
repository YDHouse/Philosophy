package com.philosophy.yd.yourphilosophy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;


class C10_AdapterContentsList extends BaseAdapter {

    //A11_ContentsList 클래스와 인터페이스 구축 (리스트뷰의 항목 위치 값을 전송)
    interface ListViewFavoriteClickListener {
        void onFavoriteClick(int position);
    }

    //생성자에서 사용할 값들
    private LayoutInflater inflater;        //MainCategory01의 context
    private int layout;                     //리스트뷰 아이템의 커스텀뷰 (listView_item.xml)
    public ArrayList<C20_ItemsAll> data;    //DB 쿼리 결과 값 (resultDB)
    private ListViewFavoriteClickListener listViewFavoriteClickListener;    //즐겨찾기 인터페이스

    //생성자
    C10_AdapterContentsList(Context context, int layout, ArrayList<C20_ItemsAll> data, ListViewFavoriteClickListener favoriteClickListener) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layout = layout;
        this.data = data;
        this.listViewFavoriteClickListener = favoriteClickListener;
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

        //리스트뷰에 표시 될 아이템들의 id를 호출
        TextView mNumber = (TextView) convertView.findViewById(R.id.textNumber);    //글의 번호
        TextView mContent = (TextView) convertView.findViewById(R.id.textContent);  //글의 내용
        TextView mAuthor = (TextView) convertView.findViewById(R.id.textAuthor);    //출처
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.favorite);     //즐겨찾기

        //내가 좋아하는 글을 등록하지 않았을 경우를 대비해서 contentId의 값이 null 인지 확인한다.
        //실제로는 contentId 뿐만 아니라 내가 좋아하는 글이 등록되어 있지 않을 경우에는 dbManager 에서
        //content, author, favorite 값 모두 null 로 지정하지만 확인은 하나만 하면 되기 때문에 contentId만 확인한다.
        if (data.get(0).getContentId() != null) {

            //data 리스트에 있는 값을 position 별로 꺼내서 items 변수에 저장한다.
            C20_ItemsAll items = data.get(position);

            //리스트뷰에 표시 될 아이템들에 값 지정
            mNumber.setText((items.getNumber()));    //글의 번호
            mContent.setText(items.getContent());    //글의 내용
            mAuthor.setText((items.getAuthor()));    //출처

            //즐겨찾기 아이콘 온,오프 값 설정 (1:온, 0:오프)
            int favoriteNo = Integer.parseInt(items.getFavorite());

            //아이콘의 초기 표시를 위해
            if (favoriteNo == 0) {
                //favorite 칼럼의 값이 0인 경우에는 아이콘의 모양을 클릭하지 않은 별의 모양으로 설정
                checkBox.setChecked(false);
            } else {
                //favorite 칼럼의 값이 1인 경우에는 아이콘의 모양을 클릭한 별의 모양으로 설정
                checkBox.setChecked(true);
            }

            //즐겨찾기의 태그에 리스트뷰 항목의 위치 값을 설정
            checkBox.setTag(position);

            //즐겨찾기 아이콘 클릭 이벤트
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //위에서 설정한 setTag 값(위치값)을 인터페이스로 연결된 A11_ContentsList 클래스로 보낸다.
                    listViewFavoriteClickListener.onFavoriteClick((int)v.getTag());
                }
            });
        } else {
            //즐겨찾기 목록에 대상이 하나도 없는 경우
            //리스트뷰에 표시되는 아이템들을 표시하지 않는다.
            mNumber.setVisibility(View.INVISIBLE);  //글의 번호
            mAuthor.setVisibility(View.INVISIBLE);  //출처
            checkBox.setVisibility(View.INVISIBLE); //즐겨찾기

            //글의 내용이 지정되는 mContent 아이템에 즐겨찾기로 등록한 글이 없다는 것을 표시
            mContent.setText("아직 등록한 좋아하는 글이 없으시군요.");
        }

        return convertView;
    }
}