package com.example.wordbook;

public class Contact {
    int _id;
    String word_en;
    String word_ch;
    public Contact(){   }
    public Contact(int id, String word_en, String word_ch){
        this._id = id;
        this.word_en = word_en;
        this.word_ch = word_ch;
    }

    public Contact(String word_en, String word_ch){
        this.word_en = word_en;
        this.word_ch = word_ch;
    }
    public int getID(){
        return this._id;
    }

    public void setID(int id){
        this._id = id;
    }

    public String getEnglish(){
        return this.word_en;
    }

    public void setEnglish(String word_en){
        this.word_en = word_en;
    }

    public String getChinese(){
        return this.word_ch;
    }

    public void setChinese(String word_ch){
        this.word_ch = word_ch;
    }
}