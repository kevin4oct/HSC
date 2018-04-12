package com.hbth.hsc.eightpaper;

import android.text.TextUtils;

import com.hbth.hsc.api.ALLVARIABLE;
import com.hbth.hsc.bean.EightPaperListBean;
import com.hbth.hsc.bean.EightPaperPicBean;
import com.hbth.hsc.bean.EightPaperReaderBean;
import com.hbth.hsc.bean.EightPaperRootBean;
import com.hbth.mylibrary.utils.LogUtils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.ksoap2.serialization.SoapObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DbAndroidTool {

    /**
     * 获取8点报的首页完整的实体类
     *
     * @param xmlStr
     * @return
     */
    public static EightPaperRootBean getInterIndexEightPaperRootBean(String xmlStr) {
        EightPaperRootBean bean = new EightPaperRootBean();
        List<EightPaperListBean> beanList = returnGridview(xmlStr);
        List<String> classifies = returnClassifies(xmlStr);
        bean.setBeanList(beanList);
        bean.setClassList(classifies);
        return bean;
    }

    /**
     * 获取8点报往期回顾完整的实体类
     *
     * @param xmlStr
     * @return
     */
    public static EightPaperRootBean getReviewEightPaperRootBean(String xmlStr) {
        EightPaperRootBean bean = new EightPaperRootBean();
        List<EightPaperListBean> beanList = returnGridview(xmlStr);
        List<String> classifies = returnYears(xmlStr);
        bean.setBeanList(beanList);
        bean.setClassList(classifies);
        return bean;
    }

    /**
     * 返回8点资源阅读的内容集合
     *
     * @param xmlStr
     * @return
     */
    public static EightPaperReaderBean returnPaperContainer(String xmlStr) {
        LogUtils.loge(xmlStr);
        EightPaperReaderBean eightPaperReaderBean = new EightPaperReaderBean();
        Document document;
        List<EightPaperPicBean> picList = null;
        try {
            // 将字符串转换成xml格式
            document = DocumentHelper.parseText(xmlStr);
            // 获取根节点
            Element node = document.getRootElement();
            //设置papername
            eightPaperReaderBean.setPaperName(strToStr(node.element("papername").getText()));
            @SuppressWarnings("unchecked")
            // 获取paperPic节点集合
                    List<Element> elements = node.elements("paperPic");
            picList = new ArrayList<>();
            for (Element et : elements) {
                EightPaperPicBean bean = new EightPaperPicBean();
                bean.set_id(strToStr(et.element("id").getText()));
                bean.setPaperid(strToStr(et.element("paperid").getText()));
                bean.setPaperPicUrl(strToStr(et.element("paperPicUrl").getText()));
                bean.setPaperPage(strToStr(et.element("paperPage").getText()));
                picList.add(bean);
            }
            eightPaperReaderBean.setPicList(picList);
        } catch (DocumentException e) {
            LogUtils.loge(e.getMessage());
        }
        LogUtils.loge(eightPaperReaderBean.toString());
        return eightPaperReaderBean;
    }

    /**
     * 返回8点资源阅读的构造soap
     *
     * @param paperid
     * @param dbname
     * @param type
     * @return
     */
    public static SoapObject returnReadSoapObject(String paperid, String dbname, String type) {
        SoapObject object = new SoapObject("http://service.xw.com/",
                ALLVARIABLE.getSelapppaperpic());

        switch (ALLVARIABLE.getServiceCode()) {
            case 0://选择公司服务器
                object.addProperty("paperid", paperid);
                object.addProperty("dbname", dbname);
                object.addProperty("type", type);
                object.addProperty("uname", "");
                break;
            case 1://选择福州服务器
                object.addProperty("arg0", paperid);
                object.addProperty("arg1", dbname);
                object.addProperty("arg2", type);
                object.addProperty("arg3", "");
                break;
        }
        return object;
    }

    /**
     * 返回页面gridview中的数据list集合
     *
     * @param xmlStr
     * @return
     */
    public static List<EightPaperListBean> returnGridview(String xmlStr) {
        Document document;
        List<EightPaperListBean> mlist = null;
        try {
            // 将字符串转换成xml格式
            document = DocumentHelper.parseText(xmlStr);
            // 获取根节点
            Element node = document.getRootElement();
            // 获取paperData节点
            Element firNode = node.element("paperData");
            @SuppressWarnings("unchecked")
            // 获取indexStr节点集合
                    List<Element> elements = firNode.elements("indexStr");
            mlist = new ArrayList<>();
            for (Element et : elements) {
                EightPaperListBean bean = new EightPaperListBean();
                bean.setItemImage(et.element("paperFirstPic").getText());
                bean.setItemPaperId(et.element("parentid").getText());
                bean.setItemTime(et.element("paperUpdateTime").getText()
                        .substring(0, 10));
                bean.setDbname(et.element("paperTbName").getText());
                bean.setPapername(et.element("paperName").getText());
                if (et.element("paperName").getText().length() > 6) {
                    bean.setSubPapername(et.element("paperName").getText()
                            .substring(0, 6));
                } else {
                    bean.setSubPapername(et.element("paperName").getText());
                }
                bean.setPicUrl(et.element("paperFirstPic").getText());
                bean.setPaperIsNowTime(et.element("isNowTime").getText());
                mlist.add(bean);
            }
        } catch (DocumentException e) {
            LogUtils.loge(e.getMessage());
        }
        return mlist;
    }

    /**
     * 返回8点报首页分类的数据
     *
     * @param xmlStr
     * @return
     */
    public static List<String> returnClassifies(String xmlStr) {
        Document document;
        List<String> classifies = new ArrayList<>();
        try {
            document = DocumentHelper.parseText(xmlStr);
            Element node = document.getRootElement();
            Element cfs = node.element("classifies");
            List<Element> classify = cfs.elements("classify");
//            classifies = new String[classify.size() + 1];
//            String str = MyApplication.getContext().getString(R.string.recommend);
//            classifies.add(str);
            for (Element element : classify) {
                String cf = element.getText();
                classifies.add(cf);
            }
        } catch (DocumentException e1) {
            LogUtils.loge(e1.getMessage());
        }
        return classifies;
    }

    /**
     * 获取往期回顾分类列表
     *
     * @param xmlStr
     * @return
     */
    public static List<String> returnYears(String xmlStr) {
        Document document;
        List<String> yearList = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            Element node = document.getRootElement();
            Element cfs = node.element("years");
            List<Element> classify = cfs.elements("year");
            yearList = new ArrayList<>();
            yearList.add("共" + node.element("countVal").getText() + "期");
            for (Element element : classify) {
                String cf = element.getText();
                yearList.add(cf);
            }
        } catch (DocumentException e1) {
            LogUtils.loge(e1.getMessage());
        }
        return yearList;
    }

    /**
     * 返回SoapObject
     *
     * @param METHOD
     * @param TYPE
     * @param NUM
     * @param CLASSIFY
     * @return
     */
    public static SoapObject returnEnterindexSoapObject(String METHOD, String TYPE, int NUM, int PAGE, String CLASSIFY) {
        SoapObject object = null;
        try {
            switch (ALLVARIABLE.getServiceCode()) {
                case 0://选择公司服务器
                    if (METHOD.equals(ALLVARIABLE.getEnterindex())) {
                        object = new SoapObject("http://service.xw.com/", METHOD);
                        object.addProperty("type", TYPE);
                        object.addProperty("pVal", NUM);
                        object.addProperty("page", PAGE);
                    } else {
                        object = new SoapObject("http://service.xw.com/", METHOD);
                        object.addProperty("classify", CLASSIFY);
                        object.addProperty("type", TYPE);
                        object.addProperty("pVal", NUM);
                        object.addProperty("page", PAGE);
                    }
                    break;
                case 1://选择福州服务器
                    if (METHOD.equals(ALLVARIABLE.getEnterindex())) {
                        object = new SoapObject("http://service.xw.com/", METHOD);
                        object.addProperty("arg0", TYPE);
                        object.addProperty("arg1", NUM);
                    } else {
                        object = new SoapObject("http://service.xw.com/", METHOD);
                        object.addProperty("arg0", CLASSIFY);
                        object.addProperty("arg1", TYPE);
                        object.addProperty("arg2", NUM);
                    }
                    break;
            }
        } catch (Exception e) {
            LogUtils.loge(e.getMessage());
        }
        return object;
    }

    /**
     * 返回搜索页面gridview中的数据list集合
     *
     * @param xmlStr
     * @return
     */
    public static List<HashMap<String, Object>> returnSearchGridview(
            String xmlStr) {
        List<HashMap<String, Object>> meumList = null;
        try {
            Document document = DocumentHelper.parseText(xmlStr);
            Element node = document.getRootElement();
            Element firNode = node.element("paperData");
            meumList = new ArrayList<>();
            @SuppressWarnings("unchecked")
            List<Element> elements = firNode.elements("indexStr");
            for (Element et : elements) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("ItemImage", et.element("paperFirstPic").getText());
                map.put("ItemPaperId",
                        Integer.parseInt(et.element("parentid").getText()));
                map.put("ItemTime", et.element("paperUpdateTime").getText()
                        .substring(0, 10));
                map.put("dbname", et.element("paperTbName").getText());
                map.put("papername", et.element("paperName").getText());
                map.put("picUrl", et.element("paperFirstPic").getText());
                meumList.add(map);
            }
        } catch (DocumentException e) {
            LogUtils.loge(e.getMessage());
        }
        return meumList;
    }

    /**
     * 往期回顾构造soap
     *
     * @param papername
     * @param time
     * @param type
     * @return
     */
    public static SoapObject returnReXmlSoap(String papername, String time,
                                             String type) {
        SoapObject object = new SoapObject("http://service.xw.com/",
                ALLVARIABLE.getSelhistroydata());

        switch (ALLVARIABLE.getServiceCode()) {
            case 0://选择公司服务器
                object.addProperty("dataname", papername);
                object.addProperty("getYear", time);
                object.addProperty("type", type);
                break;
            case 1://选择福州服务器
                object.addProperty("arg0", papername);
                object.addProperty("arg1", time);
                object.addProperty("arg2", type);
                break;
        }
        return object;
    }

    /**
     * 防止字符串为空
     */
    public static String strToStr(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "未获取到数据..";
        }
        return str;
    }
}
