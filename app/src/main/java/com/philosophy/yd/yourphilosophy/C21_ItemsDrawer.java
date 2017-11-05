package com.philosophy.yd.yourphilosophy;

import android.graphics.drawable.Drawable;


class C21_ItemsDrawer {
    private Drawable iconDrawable;  //아이콘
    private String navTitle;        //제목
    private String favoriteCount;   //내가 좋아하는 글의 총 수

    Drawable getIconDrawable() {
        return iconDrawable;
    }

    String getNavTitle() {
        return navTitle;
    }

    String getFavoriteCount() {
        return favoriteCount;
    }

    void setIconDrawable(Drawable iconDrawable) {
        this.iconDrawable = iconDrawable;
    }

    void setNavTitle(String navTitle) {
        this.navTitle = navTitle;
    }

    void setFavoriteCount(String favoriteCount) {
        this.favoriteCount = favoriteCount;
    }
}
