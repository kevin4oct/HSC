package com.hbth.hsc.bean;

import java.util.List;

/**
 * Created by Kevin on 2018/3/6.
 * 视频详情实体类
 */

public class VideoDetailBean {

    /**
     * video : {"id":108,"videoName":"量子力学","author":"苏汝铿","language":null,"summary":"|量子力学|","source":"复旦大学","videoUrl":"2011/LK/FDDX_LZLX_SRJ/01.mp4-2693-147.71MB&2011/LK/FDDX_LZLX_SRJ/02a.mp4-2704-147.58MB&2011/LK/FDDX_LZLX_SRJ/02b.mp4-2730-149.59MB&2011/LK/FDDX_LZLX_SRJ/03a.mp4-2739-149.61MB&2011/LK/FDDX_LZLX_SRJ/03b.mp4-2533-138.13MB&2011/LK/FDDX_LZLX_SRJ/04a.mp4-2661-144.96MB&2011/LK/FDDX_LZLX_SRJ/04b.mp4-2487-130.95MB&2011/LK/FDDX_LZLX_SRJ/05a.mp4-2725-131.35MB&2011/LK/FDDX_LZLX_SRJ/05b.mp4-2708-148.61MB&2011/LK/FDDX_LZLX_SRJ/06a.mp4-2602-142.99MB&2011/LK/FDDX_LZLX_SRJ/06b.mp4-2237-123.13MB&2011/LK/FDDX_LZLX_SRJ/07a.mp4-2580-142.35MB&2011/LK/FDDX_LZLX_SRJ/07b.mp4-3096-165.19MB&2011/LK/FDDX_LZLX_SRJ/08a.mp4-2737-149.37MB&2011/LK/FDDX_LZLX_SRJ/08b.mp4-2985-163.08MB&2011/LK/FDDX_LZLX_SRJ/09a.mp4-2730-148.59MB&2011/LK/FDDX_LZLX_SRJ/09b.mp4-2434-133.36MB","picUrl":"http://222.223.215.75:8083/video/UploadSoftPic/201112/20111220075637637.jpg","classID":"1005","pubdate":"2007-10-13 16:55:24.0"}
     * list : [{"id":1423,"resourceName":"微积分","author":"刘坤林","summary":"|微积分|","source":"清华大学","picUrl":"http://222.223.215.75:8083/video/UploadSoftPic/201112/20111216171750565.jpg","type":"video","pId":7,"resourceId":113,"pubdate":"2011-12-16 17:10:16.0","classID":"1005"},{"id":1479,"resourceName":"电磁学","author":"陈秉乾","summary":"|电磁|","source":"北京大学","picUrl":"http://222.223.215.75:8083/video/UploadSoftPic/201112/20111228195746620.jpg","type":"video","pId":7,"resourceId":169,"pubdate":"2011-12-28 19:55:04.0","classID":"1005"},{"id":1480,"resourceName":"微积分讲座","author":"刘坤林 等","summary":"|微积分|","source":"清华大学","picUrl":"http://222.223.215.75:8083/video/UploadSoftPic/201112/20111228202409261.jpg","type":"video","pId":7,"resourceId":170,"pubdate":"2011-12-28 20:21:57.0","classID":"1005"},{"id":1519,"resourceName":"现代自然地理学：生物圈","author":"王建","summary":"|生物圈|","source":"南京师范大学","picUrl":"http://222.223.215.75:8083/video/UploadSoftPic/201201/20120110143003871.jpg","type":"video","pId":7,"resourceId":209,"pubdate":"2012-01-10 14:27:03.0","classID":"1005"},{"id":1526,"resourceName":"从白矮星、中子星到黑洞","author":"赵峥","summary":"|白矮星|中子星|黑洞|","source":"北京师范大学","picUrl":"http://222.223.215.75:8083/video/UploadSoftPic/201202/20120211084137226.jpg","type":"video","pId":7,"resourceId":216,"pubdate":"2012-02-11 08:13:16.0","classID":"1005"},{"id":1584,"resourceName":"认识宇宙","author":"向守平","summary":"|宇宙|星系|","source":"中国科学技术大学","picUrl":"http://222.223.215.75:8083/video/UploadSoftPic/201202/20120227103908901.jpg","type":"video","pId":7,"resourceId":274,"pubdate":"2012-02-27 10:33:57.0","classID":"1005"}]
     * url : [{"name":"第1集","url":"http://222.223.215.75:8083/video/2011/LK/FDDX_LZLX_SRJ/01.mp4","size":"147.71MB","videoLong":"2693"},{"name":"第2集","url":"http://222.223.215.75:8083/video/2011/LK/FDDX_LZLX_SRJ/02a.mp4","size":"147.58MB","videoLong":"2704"},{"name":"第3集","url":"http://222.223.215.75:8083/video/2011/LK/FDDX_LZLX_SRJ/02b.mp4","size":"149.59MB","videoLong":"2730"},{"name":"第4集","url":"http://222.223.215.75:8083/video/2011/LK/FDDX_LZLX_SRJ/03a.mp4","size":"149.61MB","videoLong":"2739"},{"name":"第5集","url":"http://222.223.215.75:8083/video/2011/LK/FDDX_LZLX_SRJ/03b.mp4","size":"138.13MB","videoLong":"2533"},{"name":"第6集","url":"http://222.223.215.75:8083/video/2011/LK/FDDX_LZLX_SRJ/04a.mp4","size":"144.96MB","videoLong":"2661"},{"name":"第7集","url":"http://222.223.215.75:8083/video/2011/LK/FDDX_LZLX_SRJ/04b.mp4","size":"130.95MB","videoLong":"2487"},{"name":"第8集","url":"http://222.223.215.75:8083/video/2011/LK/FDDX_LZLX_SRJ/05a.mp4","size":"131.35MB","videoLong":"2725"},{"name":"第9集","url":"http://222.223.215.75:8083/video/2011/LK/FDDX_LZLX_SRJ/05b.mp4","size":"148.61MB","videoLong":"2708"},{"name":"第10集","url":"http://222.223.215.75:8083/video/2011/LK/FDDX_LZLX_SRJ/06a.mp4","size":"142.99MB","videoLong":"2602"},{"name":"第11集","url":"http://222.223.215.75:8083/video/2011/LK/FDDX_LZLX_SRJ/06b.mp4","size":"123.13MB","videoLong":"2237"},{"name":"第12集","url":"http://222.223.215.75:8083/video/2011/LK/FDDX_LZLX_SRJ/07a.mp4","size":"142.35MB","videoLong":"2580"},{"name":"第13集","url":"http://222.223.215.75:8083/video/2011/LK/FDDX_LZLX_SRJ/07b.mp4","size":"165.19MB","videoLong":"3096"},{"name":"第14集","url":"http://222.223.215.75:8083/video/2011/LK/FDDX_LZLX_SRJ/08a.mp4","size":"149.37MB","videoLong":"2737"},{"name":"第15集","url":"http://222.223.215.75:8083/video/2011/LK/FDDX_LZLX_SRJ/08b.mp4","size":"163.08MB","videoLong":"2985"},{"name":"第16集","url":"http://222.223.215.75:8083/video/2011/LK/FDDX_LZLX_SRJ/09a.mp4","size":"148.59MB","videoLong":"2730"},{"name":"第17集","url":"http://222.223.215.75:8083/video/2011/LK/FDDX_LZLX_SRJ/09b.mp4","size":"133.36MB","videoLong":"2434"}]
     */

    private VideoBean video;
    private List<ListBean> list;
    private List<UrlBean> url;

    public VideoBean getVideo() {
        return video;
    }

    public void setVideo(VideoBean video) {
        this.video = video;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public List<UrlBean> getUrl() {
        return url;
    }

    public void setUrl(List<UrlBean> url) {
        this.url = url;
    }

    public static class VideoBean {
        /**
         * id : 108
         * videoName : 量子力学
         * author : 苏汝铿
         * language : null
         * summary : |量子力学|
         * source : 复旦大学
         * videoUrl : 2011/LK/FDDX_LZLX_SRJ/01.mp4-2693-147.71MB&2011/LK/FDDX_LZLX_SRJ/02a.mp4-2704-147.58MB&2011/LK/FDDX_LZLX_SRJ/02b.mp4-2730-149.59MB&2011/LK/FDDX_LZLX_SRJ/03a.mp4-2739-149.61MB&2011/LK/FDDX_LZLX_SRJ/03b.mp4-2533-138.13MB&2011/LK/FDDX_LZLX_SRJ/04a.mp4-2661-144.96MB&2011/LK/FDDX_LZLX_SRJ/04b.mp4-2487-130.95MB&2011/LK/FDDX_LZLX_SRJ/05a.mp4-2725-131.35MB&2011/LK/FDDX_LZLX_SRJ/05b.mp4-2708-148.61MB&2011/LK/FDDX_LZLX_SRJ/06a.mp4-2602-142.99MB&2011/LK/FDDX_LZLX_SRJ/06b.mp4-2237-123.13MB&2011/LK/FDDX_LZLX_SRJ/07a.mp4-2580-142.35MB&2011/LK/FDDX_LZLX_SRJ/07b.mp4-3096-165.19MB&2011/LK/FDDX_LZLX_SRJ/08a.mp4-2737-149.37MB&2011/LK/FDDX_LZLX_SRJ/08b.mp4-2985-163.08MB&2011/LK/FDDX_LZLX_SRJ/09a.mp4-2730-148.59MB&2011/LK/FDDX_LZLX_SRJ/09b.mp4-2434-133.36MB
         * picUrl : http://222.223.215.75:8083/video/UploadSoftPic/201112/20111220075637637.jpg
         * classID : 1005
         * pubdate : 2007-10-13 16:55:24.0
         */

        private int id;
        private String videoName;
        private String author;
        private Object language;
        private String summary;
        private String source;
        private String videoUrl;
        private String picUrl;
        private String classID;
        private String pubdate;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getVideoName() {
            return videoName;
        }

        public void setVideoName(String videoName) {
            this.videoName = videoName;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public Object getLanguage() {
            return language;
        }

        public void setLanguage(Object language) {
            this.language = language;
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

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getClassID() {
            return classID;
        }

        public void setClassID(String classID) {
            this.classID = classID;
        }

        public String getPubdate() {
            return pubdate;
        }

        public void setPubdate(String pubdate) {
            this.pubdate = pubdate;
        }

        @Override
        public String toString() {
            return "VideoBean{" +
                    "id=" + id +
                    ", videoName='" + videoName + '\'' +
                    ", author='" + author + '\'' +
                    ", language=" + language +
                    ", summary='" + summary + '\'' +
                    ", source='" + source + '\'' +
                    ", videoUrl='" + videoUrl + '\'' +
                    ", picUrl='" + picUrl + '\'' +
                    ", classID='" + classID + '\'' +
                    ", pubdate='" + pubdate + '\'' +
                    '}';
        }
    }

    public static class ListBean {
        /**
         * id : 1423
         * resourceName : 微积分
         * author : 刘坤林
         * summary : |微积分|
         * source : 清华大学
         * picUrl : http://222.223.215.75:8083/video/UploadSoftPic/201112/20111216171750565.jpg
         * type : video
         * pId : 7
         * resourceId : 113
         * pubdate : 2011-12-16 17:10:16.0
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
            return "ListBean{" +
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

    public static class UrlBean {
        /**
         * name : 第1集
         * url : http://222.223.215.75:8083/video/2011/LK/FDDX_LZLX_SRJ/01.mp4
         * size : 147.71MB
         * videoLong : 2693
         */

        private String name;
        private String url;
        private String size;
        private String videoLong;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getVideoLong() {
            return videoLong;
        }

        public void setVideoLong(String videoLong) {
            this.videoLong = videoLong;
        }

        @Override
        public String toString() {
            return "UrlBean{" +
                    "name='" + name + '\'' +
                    ", url='" + url + '\'' +
                    ", size='" + size + '\'' +
                    ", videoLong='" + videoLong + '\'' +
                    '}';
        }

    }

    @Override
    public String toString() {
        return "VideoDetailBean{" +
                "video=" + video +
                ", list=" + list +
                ", url=" + url +
                '}';
    }

}
