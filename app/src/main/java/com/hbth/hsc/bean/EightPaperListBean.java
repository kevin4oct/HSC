package com.hbth.hsc.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kevin on 2017-10-31.
 * 8点报资源类型的的实体类
 */

public class EightPaperListBean implements Parcelable {

    private String ItemImage;
    private String ItemPaperId;
    private String ItemTime;
    private String dbname;
    private String papername;
    private String subPapername;
    private String picUrl;
    private String paperIsNowTime;

    public EightPaperListBean() {
    }

    protected EightPaperListBean(Parcel in) {
        ItemImage = in.readString();
        ItemPaperId = in.readString();
        ItemTime = in.readString();
        dbname = in.readString();
        papername = in.readString();
        subPapername = in.readString();
        picUrl = in.readString();
        paperIsNowTime = in.readString();
    }

    public static final Creator<EightPaperListBean> CREATOR = new Creator<EightPaperListBean>() {
        @Override
        public EightPaperListBean createFromParcel(Parcel in) {
            return new EightPaperListBean(in);
        }

        @Override
        public EightPaperListBean[] newArray(int size) {
            return new EightPaperListBean[size];
        }
    };

    public String getItemImage() {
        return ItemImage;
    }

    public void setItemImage(String itemImage) {
        ItemImage = itemImage;
    }

    public String getItemPaperId() {
        return ItemPaperId;
    }

    public void setItemPaperId(String itemPaperId) {
        ItemPaperId = itemPaperId;
    }

    public String getItemTime() {
        return ItemTime;
    }

    public void setItemTime(String itemTime) {
        ItemTime = itemTime;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getPapername() {
        return papername;
    }

    public void setPapername(String papername) {
        this.papername = papername;
    }

    public String getSubPapername() {
        return subPapername;
    }

    public void setSubPapername(String subPapername) {
        this.subPapername = subPapername;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPaperIsNowTime() {
        return paperIsNowTime;
    }

    public void setPaperIsNowTime(String paperIsNowTime) {
        this.paperIsNowTime = paperIsNowTime;
    }

    @Override
    public String toString() {
        return "EightPaperListBean{" +
                "ItemImage='" + ItemImage + '\'' +
                ", ItemPaperId='" + ItemPaperId + '\'' +
                ", ItemTime='" + ItemTime + '\'' +
                ", dbname='" + dbname + '\'' +
                ", papername='" + papername + '\'' +
                ", subPapername='" + subPapername + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", paperIsNowTime='" + paperIsNowTime + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(ItemImage);
        parcel.writeString(ItemPaperId);
        parcel.writeString(ItemTime);
        parcel.writeString(dbname);
        parcel.writeString(papername);
        parcel.writeString(subPapername);
        parcel.writeString(picUrl);
        parcel.writeString(paperIsNowTime);
    }
}
