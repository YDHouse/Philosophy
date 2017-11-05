package com.philosophy.yd.yourphilosophy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;


class C11_AdapterFavoriteList extends BaseAdapter {

    //체크박스 체크 true 인 항목의 contentId가 저장될 list
    private ArrayList<String> list = new ArrayList<>();

    //체크박스 체크 리스너
    private View.OnClickListener checkboxCheckedListener;

    //생성자에서 사용할 값들
    private LayoutInflater inflater;
    private int layout;
    public ArrayList<C20_ItemsAll> data;
    private boolean[] isCheckedValue;       //체크박스의 true/false 상태가 저장될 boolean 배열

    //생성자
    C11_AdapterFavoriteList(Context context, int layout, ArrayList<C20_ItemsAll> data, View.OnClickListener checkboxCheckedListener) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layout = layout;
        this.data = data;
        this.isCheckedValue = new boolean[data.size()]; //데이타의 크기만큼 boolean 배열의 크기를 설정
        this.checkboxCheckedListener = checkboxCheckedListener; //체크박스 체크 리스너
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = inflater.inflate(layout, parent, false);
        }

        //리스트뷰에 표시 될 아이템들의 id를 호출
        TextView mNumber = (TextView) convertView.findViewById(R.id.textNumber);    //글의 번호
        TextView mContent = (TextView) convertView.findViewById(R.id.textContent);  //글의 내용
        TextView mAuthor = (TextView) convertView.findViewById(R.id.textAuthor);    //출처
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkbox1);    //즐겨찾기

        //체크박스가 체크가 되면 리스너 동작
        checkBox.setOnClickListener(checkboxCheckedListener);

        //내가 좋아하는 글을 등록하지 않았을 경우를 대비해서 contentId의 값이 null 인지 확인한다.
        //실제 contentId 뿐만 아니라 내가 좋아하는 글이 등록되어 있지 않을 경우에는 D00_DBManager 에서
        //content, author, favorite 값 모두 null 로 지정한다.
        if (data.get(0).getContentId() != null) {
            //data 리스트에 있는 값을 position 별로 꺼내서 items 변수에 저장한다.
            final C20_ItemsAll items = data.get(position);

            //리스트뷰에 표시 될 아이템들에 값 지정
            mNumber.setText((items.getNumber()));    //글의 번호
            mContent.setText(items.getContent());    //글의 내용
            mAuthor.setText((items.getAuthor()));    //출처

            //체크박스의 체크여부를 isCheckedValue 배열의 값으로 설정한다.
            //초기값은 false 이기 때문에 모두 선택 해제되어있다.
            checkBox.setChecked(isCheckedValue[position]);

            //체크박스 체크여부 확인
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    //체크박스에 체크가 되면
                    if (isChecked) {
                        //리스트에 해당 항목의 contentId를 저장한다.
                        list.add(items.getContentId());
                    }
                    //체크박스에 체크가 해제되면
                    if (!isChecked) {
                        //리스트에 해당 항목의 contentId를 삭제한다.
                        list.remove(items.getContentId());
                    }
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

    //체크박스 모두 선택 / 해제
    void setAllChecked(boolean isChecked) {
        //A20_FavoriteList 클래스에서 모두 선택 버튼을 클릭하면 true 값을 받아온다.
        //한 번 더 누르면 false 값을 보내오기 때문에 모두 해제가 된다.
        //isCheckedValue 값을 길이만큼 반복해서 모든 체크박스를 선택 or 해제할 수 있다.
        //isChecked 값이 true 이면 모두 선택, false 이면 모두 해제
        for (int i=0; i<isCheckedValue.length; i++) {
            isCheckedValue[i] = isChecked;
        }
    }

    //A20_FavoriteList 클래스에서 '선택 항목 삭제' 버튼을 클릭하면
    //선택된 체크박스의 contentId 값 리턴
    ArrayList<String> checkedItems () {
        return list;
    }

}