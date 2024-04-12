package com.example.giatorsjava.Test;

import android.os.Parcel;
import android.os.Parcelable;

public class selecatable implements Parcelable{
public  String question;
public String selected;

    public selecatable(String question, String selected) {
        this.question = question;
        this.selected = selected;
    }

    protected selecatable(Parcel in) {
        question = in.readString();
        selected = in.readString();
    }

    public static final Creator<selecatable> CREATOR = new Creator<selecatable>() {
        @Override
        public selecatable createFromParcel(Parcel in) {
            return new selecatable(in);
        }

        @Override
        public selecatable[] newArray(int size) {
            return new selecatable[size];
        }
    };

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(question);
        parcel.writeString(selected);
    }
}
