package com.philosophy.yd.yourphilosophy;

import java.io.Serializable;


class C20_ItemsAll implements Serializable {
    private String contentId;   //글의 고유 ID
    private String number;      //글의 번호
    private String content;     //내용
    private String author;      //저자
    private String annotation;  //주석
    private String favorite;    //즐겨찾기

    String getContentId() {
        return contentId;
    }

    String getNumber() {
        return number;
    }

    String getContent() {
        return content;
    }

    String getAuthor() {
        return author;
    }

    String getAnnotation() {
        return annotation;
    }

    String getFavorite() {
        return favorite;
    }

    C20_ItemsAll(String contentId, String number, String content, String author, String annotation, String favorite) {
        this.contentId = contentId;
        this.number = number;
        this.content = content;
        this.author = author;
        this.annotation = annotation;
        this.favorite = favorite;
    }
}
