package com.example.my.hellogit;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by huangpeiquan on 17/3/26.
 */

public class User2 implements Parcelable{
    private String id;
    private String name;

    public User2(String id, String name) {
        this.id = id;
        this.name = name;
    }

    protected User2(Parcel in) {
        id = in.readString();
        name = in.readString();
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
    }
    public static final Creator<User2> CREATOR = new Creator<User2>() {
        @Override
        public User2 createFromParcel(Parcel in) {
            return new User2(in.readString(),in.readString());
        }

        @Override
        public User2[] newArray(int size) {
            return new User2[size];
        }
    };
}
