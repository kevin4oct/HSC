package com.hbth.hsc.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/5.
 * 8点报详情实体类
 */

public class EightPaperReaderBean {

    private String paperName;
    private String paperIsSc;
    private List<EightPaperPicBean> picList;

    public EightPaperReaderBean() {
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getPaperIsSc() {
        return paperIsSc;
    }

    public void setPaperIsSc(String paperIsSc) {
        this.paperIsSc = paperIsSc;
    }

    public List<EightPaperPicBean> getPicList() {
        return picList;
    }

    public void setPicList(List<EightPaperPicBean> picList) {
        this.picList = picList;
    }

    @Override
    public String toString() {
        return "EightPaperReaderBean{" +
                "paperName='" + paperName + '\'' +
                ", paperIsSc='" + paperIsSc + '\'' +
                ", picList=" + picList +
                '}';
    }
}
