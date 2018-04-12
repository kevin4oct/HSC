package com.hbth.hsc.api;

/**
 * Created by kevin on 2017/3/22.
 * 电子资源的参数设置
 */
public class ALLVARIABLE {

    private static String enterIndex = "enterIndexByPage";// 进入首页方法
    private static String selAppPaperPic = "selAppPaperPic";// 进入详情页面方法
    private static String selIndexByClassify = "selIndexByClassifyByPage";// 根据分类查询数据
    private static String selHistroyData = "selHistroyData";// 往期回顾
    private static String searchAppPaper = "searchAppPaper";// 搜索功能
    private static String sysPicUrl = "sysPicUrl";// 扫一扫图片链接

    // webservice 固定的type（"paper","mgz","book"）参数的值
    private static String ptype = "paper";
    private static String mtype = "mgz";
    private static String btype = "book";
    //
    public static final int SERVICE_CODE = 0;//选择8点资源服务器，0代表公司服务器，1代表福州服务器；
    //8点资源福州服务器
    public static String webserviceURL_FZ = "http://web8db.8dbie.com/ServiceImplPort?wsdl";
    //公司服务器 Host
    private static String serviceURL = "http://222.223.215.75:8081";
    //8点资源公司服务器
    private static String webserviceURL = serviceURL + "/AppWebService/ServiceImplPort?wsdl";

    public static String getEnterindex() {
        return enterIndex;
    }

    public static String getSelapppaperpic() {
        return selAppPaperPic;
    }

    public static String getSelindexbyclassify() {
        return selIndexByClassify;
    }

    public static String getSelhistroydata() {
        return selHistroyData;
    }

    public static String getSearchapppaper() {
        return searchAppPaper;
    }

    public static String getSyspicurl() {
        return sysPicUrl;
    }

    public static String getPtype() {
        return ptype;
    }

    public static String getMtype() {
        return mtype;
    }

    public static String getBtype() {
        return btype;
    }

    public static int getServiceCode(){
        return SERVICE_CODE;
    }

    public static String getWebserviceurl() {
        String serviceUrl = "";
        switch (SERVICE_CODE) {
            case 0://选择公司服务器
                serviceUrl = webserviceURL;
                break;
            case 1://选择福州服务器
                serviceUrl = webserviceURL_FZ;
                break;
        }
        return serviceUrl;
    }

    public static String getServiceURL() {
        return serviceURL;
    }
}
