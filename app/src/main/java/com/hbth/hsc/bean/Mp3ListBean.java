package com.hbth.hsc.bean;

import java.util.List;

/**
 * Created by Kevin on 2018/4/11.
 * 音频列表的实体类
 */

public class Mp3ListBean {

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
         * id : 425
         * resourceName : 单田芳评书_燕王扫北
         * author : 单田芳
         * summary : 主要说的是明太祖朱元璋建国之后,为巩固朱家帝业,排除异已,不择手段地残害功臣宿将。在继承皇位的问题上,朱元璋内部也发生了分岐。马娘娘利用垂帘听政的机会,祖封小王,把四皇子朱棣封为'燕王'赶出南京，名义上叫朱棣去扫北,实则设下重重陷井,欲置朱棣于死地。在众多英雄的保护下,朱棣终于化险为夷，来到燕京。为了扫除韩马两党，为死去的功臣宿将报仇雪恨，燕王挂孝南征。通过你死我活的较量,最后终于打到南京，清算了韩马两党的罪恶。燕王登上了大明永乐皇帝的宝座,重建万里长城,巩固了边防,从此,明朝进入了安定、生息的局面。
         * source :
         * picUrl : http://222.223.215.75:8083/mp3/pic/SHTF_YWSHB.jpg
         * type : mp3
         * pId : 6
         * resourceId : 8
         * pubdate : 2013-07-20
         * classID : 评书
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
         * id : 1
         * name : 评书
         * code : 评书
         * parent : mp3
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
        return "Mp3ListBean{" +
                "resource=" + resource +
                ", subject=" + subject +
                '}';
    }
}
