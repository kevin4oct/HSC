package com.hbth.hsc.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/5.
 */

public class RssListBean {

    /**
     * rss : [{"id":1,"rssName":"热门报刊","url":null,"pId":0,"summary":"热门报刊","pic":null},{"id":2,"rssName":"头条","url":null,"pId":0,"summary":"最先最全要闻频道","pic":null},{"id":3,"rssName":"教育","url":null,"pId":0,"summary":"集纳各类考试专题,教育咨询","pic":null},{"id":4,"rssName":"科技","url":null,"pId":0,"summary":"提供重要的数码资讯,IT信息","pic":null},{"id":5,"rssName":"财经","url":null,"pId":0,"summary":"国内和世界的财经新闻","pic":null},{"id":7,"rssName":"人文","url":null,"pId":0,"summary":"提供文化新闻,读书信息","pic":null},{"id":8,"rssName":"体育","url":null,"pId":0,"summary":"网罗国际国内各种体育资讯,展现体坛风云","pic":null},{"id":9,"rssName":"娱乐","url":null,"pId":0,"summary":"实时传递娱乐八卦,影视动态","pic":null},{"id":10,"rssName":"军事","url":null,"pId":0,"summary":"第一时间发布全球军事动态","pic":null}]
     * url : http://222.223.215.75:8083/user/
     */

    private String url;
    private List<RssBean> rss;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<RssBean> getRss() {
        return rss;
    }

    public void setRss(List<RssBean> rss) {
        this.rss = rss;
    }

    public static class RssBean {
        /**
         * id : 1
         * rssName : 热门报刊
         * url : null
         * pId : 0
         * summary : 热门报刊
         * pic : null
         */

        private int id;
        private String rssName;
        private String url;
        private int pId;
        private String summary;
        private String pic;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getRssName() {
            return rssName;
        }

        public void setRssName(String rssName) {
            this.rssName = rssName;
        }

        public Object getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getPId() {
            return pId;
        }

        public void setPId(int pId) {
            this.pId = pId;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public Object getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }
    }
}
