package com.hbth.hsc.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/6.
 */

public class VideoListBean {

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
         * id : 1418
         * resourceName : 量子力学
         * author : 苏汝铿
         * summary : |量子力学|
         * source : 复旦大学
         * picUrl : http://222.223.215.75:8083/video/UploadSoftPic/201112/20111220075637637.jpg
         * type : video
         * pId : 7
         * resourceId : 108
         * pubdate : 2007-10-13 16:55:24.0
         * classID : 1005
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

        @Override
        public String toString() {
            return "ResourceBean{" +
                    "id=" + id +
                    ", resourceName='" + resourceName + '\'' +
                    ", author='" + author + '\'' +
                    ", summary='" + summary + '\'' +
                    ", source='" + source + '\'' +
                    ", picUrl='" + picUrl + '\'' +
                    ", type='" + type + '\'' +
                    ", pId=" + pId +
                    ", resourceId=" + resourceId +
                    ", pubdate='" + pubdate + '\'' +
                    ", classID='" + classID + '\'' +
                    '}';
        }
    }

    public static class SubjectBean {
        /**
         * id : 3
         * name : 人文
         * code : 1001
         * parent : video
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

        @Override
        public String toString() {
            return "SubjectBean{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", code='" + code + '\'' +
                    ", parent='" + parent + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "VideoListBean{" +
                "resource=" + resource +
                ", subject=" + subject +
                '}';
    }
}
