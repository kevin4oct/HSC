package com.hbth.hsc.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/2/6.
 * 公司服务器 电子书 列表
 */

public class BookListBean {

    private List<ResourceBean> resource;
    private List<SubjectBean> subject;

    public List<ResourceBean> getResource() {
        return resource;
    }

    public void setResource(List<ResourceBean> resource) {
        this.resource = resource;
    }

    public List<SubjectBean> getSubject() {
        return subject;
    }

    public void setSubject(List<SubjectBean> subject) {
        this.subject = subject;
    }

    public static class ResourceBean {
        /**
         * id : 1605
         * resourceName : 英语学习:2012年第12期
         * author : 侯毅凌
         * summary : 英语-语言读物
         * source : 外语教学与研究出版社
         * picUrl : http://222.223.215.75:8083/book/EPUB2/封面/1002-5553.jpg
         * type : book
         * pId : 6
         * resourceId : 36976
         * pubdate : 2014-03-01
         * classID : H319.4
         */

        private int id;
        private String resourceName;
        private String author;
        private String summary;
        private String source;
        private String picUrl;
        private String type;
        private int pId;
        private int resourceId;
        private String pubdate;
        private String classID;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getResourceName() {
            return resourceName;
        }

        public void setResourceName(String resourceName) {
            this.resourceName = resourceName;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getPId() {
            return pId;
        }

        public void setPId(int pId) {
            this.pId = pId;
        }

        public int getResourceId() {
            return resourceId;
        }

        public void setResourceId(int resourceId) {
            this.resourceId = resourceId;
        }

        public String getPubdate() {
            return pubdate;
        }

        public void setPubdate(String pubdate) {
            this.pubdate = pubdate;
        }

        public String getClassID() {
            return classID;
        }

        public void setClassID(String classID) {
            this.classID = classID;
        }
    }

    public static class SubjectBean {
        /**
         * id : 14
         * name : 马克思主义、列宁主义、毛泽东思想、邓小平理论
         * code : A
         * parent : book
         */

        private int id;
        private String name;
        private String code;
        private String parent;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }
    }
}
