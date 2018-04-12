package com.hbth.hsc.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/3.
 * 8点报首页列表和往期列表的实体类
 */

public class EightPaperRootBean {

    private List<EightPaperListBean> beanList;
    private List<String> classList;

    public EightPaperRootBean() {
    }

    public List<EightPaperListBean> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<EightPaperListBean> beanList) {
        this.beanList = beanList;
    }

    public List<String> getClassList() {
        return classList;
    }

    public void setClassList(List<String> classList) {
        this.classList = classList;
    }

    @Override
    public String toString() {
        return "EightPaperRootBean{" +
                "beanList=" + beanList +
                ", classList=" + classList +
                '}';
    }


}
