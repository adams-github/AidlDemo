package com.example.administrator.aidldemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * create by zl on 2019/3/22
 */
public class ProcessBean implements Parcelable {

    public int pid;
    public String name;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.pid);
        dest.writeString(this.name);
    }

    public ProcessBean(int pid, String name) {
        this.pid = pid;
        this.name = name;
    }

    protected ProcessBean(Parcel in) {
        this.pid = in.readInt();
        this.name = in.readString();
    }

    public static final Creator<ProcessBean> CREATOR = new Creator<ProcessBean>() {
        @Override
        public ProcessBean createFromParcel(Parcel source) {
            return new ProcessBean(source);
        }

        @Override
        public ProcessBean[] newArray(int size) {
            return new ProcessBean[size];
        }
    };


}
