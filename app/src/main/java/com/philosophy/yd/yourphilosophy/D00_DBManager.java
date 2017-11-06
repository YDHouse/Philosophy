package com.philosophy.yd.yourphilosophy;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


class D00_DBManager extends SQLiteOpenHelper {

    //다른 클래스에서 현 클래스를 호출할 수 있게 스태틱으로 선언
    static D00_DBManager dbManager;

    D00_DBManager(Context context) {
        super(context, "YourPhilosophy.db", null, 1);

        //onCreate() 메소드가 실행되면서 (혹은 생성자로 클래스를 호출할 때)
        //현 클래스가 스태틱으로 메모리에 등록된다.
        //이 구문이 빠지면 스태틱 선언을 해도 this 로 지정된 곳이 없기 때문에
        //nullPointerException 이 발생하므로 반드시 지정해 주어야 한다.
        dbManager = this;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE `PHILOSOPHY` ( `ID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `SECTION` INTEGER NOT NULL, `CONTENT` TEXT NOT NULL, 'AUTHOR' TEXT NOT NULL, 'ANNOTATION' TEXT NOT NULL, 'FAVORITE' INTEGER NOT NULL )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DELETE FROM PHILOSOPHY");
    }

    //카테고리 별 쿼리 실행
    ArrayList<C20_ItemsAll> querySelect(int queryNumber) {
        //쿼리 실행 후 쿼리 값을 각 각의 컬럼 별로 나누기 위해 변수 선언
        String mContentId = "";     //ID
        String mContent = "";       //글의 내용
        String mAuthor = "";        //출처
        String mAnnotation = "";    //주석
        String mFavorite = "";      //즐겨찾기

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor;

        //DB 값들이 최종적으로 저장될 리스트
        ArrayList<C20_ItemsAll> resultDB = new ArrayList<>();

        if (queryNumber == 0 ) {
            //쿼리넘버가 0이면 내가 좋아하는 글 쿼리를 실행하고
            cursor = db.rawQuery("select * from PHILOSOPHY where favorite = 1", null);
        } else {
            //쿼리넘버가 0이 아니면 섹션 별 쿼리를 실행한다.
            cursor = db.rawQuery("select * from PHILOSOPHY where SECTION = " + queryNumber + "", null);
        }

        //섹션 별 쿼리에서는 null 값이 나올 경우가 없지만
        //즐겨찾기 쿼리에서는 null 값이 나올 수 있기 때문에 cursor 값을 확인한다.
        if (cursor != null && cursor.getCount() != 0) {
            while (cursor.moveToNext()) {
                //나중에 데이터를 나누기 위해 기호(/)를 추가해서 각 변수에 담는다.
                //참고로 1번은 section
                mContentId += cursor.getString(0) + "/";    //0번은 ID
                mContent += cursor.getString(2) + "/";      //2번은 글의 내용
                mAuthor += cursor.getString(3) + "/";       //3번은 출처
                mAnnotation += cursor.getString(4) + "/";   //4번은 주석
                mFavorite += cursor.getString(5) + "/";     //5번은 즐겨찾기
            }

            //하나의 변수에 DB의 값이 전부 들어가 있기 때문에 기호 '/' 를 기준으로 나누어 준다.
            String[] contentIdSplit = mContentId.split("/");
            String[] contentSplit = mContent.split("/");
            String[] authorSplit = mAuthor.split("/");
            String[] annotationSplit = mAnnotation.split("/");
            String[] favoriteSplit = mFavorite.split("/");

            //배열의 크기만큼 반복을 돌리기 위해 글의 내용을 나눈 contentSplit 길이의 값을 변수 k에 저장
            int k = contentSplit.length;

            int number = 1;
            for (int i=0; i<k; i++){
                //content, author, favorite 컬럼 값을 C20_ItemsAll 에 저장한다.
                //content, author, annotation 값을 저장할 때는 글 띄움 효과를 준다.
                //icon_number 값은 글의 번호로 사용한다.
                C20_ItemsAll item = new C20_ItemsAll
                        (
                                contentIdSplit[i], ""+ number++
                                , contentSplit[i].replace("<space>", "\n")
                                , authorSplit[i].replace("<space>", "\n")
                                , annotationSplit[i].replace("<space>", "\n")
                                , favoriteSplit[i]
                        );

                //C20_ItemsAll 값을 최종적으로 리스트(resultDB)에 담는다.
                resultDB.add(item);
            }
        } else {
            //즐겨찾기 쿼리 결과가 null 혹은 0일 경우에는 resultDB에 null 값을 넣는다.
            C20_ItemsAll item = new C20_ItemsAll(null, null, null, null, null, null);
            resultDB.add(item);
        }
        return resultDB;
    }

    //내가 좋아하는 글의 총 수 구하기
    int favoriteCount() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select count(*) from PHILOSOPHY where favorite = 1", null);
        int count = 0;
        while (cursor.moveToNext()) {
            count = cursor.getInt(0);
        }
        return count;
    }

    //내가 좋아하는 글의 아이콘 변경을 위한 업데이트 쿼리 실행 (DB의 favorite 컬럼 값 변경)
    void favoriteUpdate(int favoriteValue, int contentId) {
        SQLiteDatabase db = getWritableDatabase();

        //favoriteValue 값에 따라 조건문을 나눈다.
        if (favoriteValue == 0) {
            //contentId 를 기준으로 favoriteValue 가 0이면 1로 변경
            db.execSQL("update PHILOSOPHY set FAVORITE = " + 1 + " where ID = " + contentId + ";");
        } else {
            //contentId 를 기준으로 favoriteValue 가 1이면 0으로 변경
            db.execSQL("update PHILOSOPHY set FAVORITE = " + 0 + " where ID = " + contentId + ";");
        }

        //DB 닫기 (꼭 닫아 줘야 함)
        db.close();
    }
}