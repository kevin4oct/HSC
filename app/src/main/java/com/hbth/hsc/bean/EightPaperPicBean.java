package com.hbth.hsc.bean;

/**
 * Created by Administrator on 2018/3/5.
 */

public class EightPaperPicBean {

    private String _id;
    private String paperid;
    private String paperPicUrl;
    private String paperPage;

    public EightPaperPicBean() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getPaperid() {
        return paperid;
    }

    public void setPaperid(String paperid) {
        this.paperid = paperid;
    }

    public String getPaperPicUrl() {
        return paperPicUrl;
    }

    public void setPaperPicUrl(String paperPicUrl) {
        this.paperPicUrl = paperPicUrl;
    }

    public String getPaperPage() {
        return paperPage;
    }

    public void setPaperPage(String paperPage) {
        this.paperPage = paperPage;
    }

    @Override
    public String toString() {
        return "PaperPicBean{" +
                "_id='" + _id + '\'' +
                ", paperid='" + paperid + '\'' +
                ", paperPicUrl='" + paperPicUrl + '\'' +
                ", paperPage='" + paperPage + '\'' +
                '}';
    }

}
