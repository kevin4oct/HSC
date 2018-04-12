package com.hbth.hsc.api;

import com.hbth.hsc.bean.BookDetailBean;
import com.hbth.hsc.bean.BookListBean;
import com.hbth.hsc.bean.Mp3DetailBean;
import com.hbth.hsc.bean.Mp3ListBean;
import com.hbth.hsc.bean.RssListBean;
import com.hbth.hsc.bean.VideoDetailBean;
import com.hbth.hsc.bean.VideoListBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2018/2/6.
 * API接口参数
 */

public interface ApiService {

    /**
     * 公司服务器资源管理平台图书列表接口
     */
    @FormUrlEncoded
    @POST("/resource/resource/ResourceList.htmls")
    Observable<BookListBean> getBookList(@Field("pId") String pId,
                                         @Field("page") int page,
                                         @Field("rows") int rows,
                                         @Field("type") String type,
                                         @Field("classID") String classID);

    /**
     * 公司服务器获取图书详情列表
     */
    @FormUrlEncoded
    @POST("/resource/epub/getEpub.htmls")
    Observable<BookDetailBean> getBookDetail(@Field("pId") String pId,
                                             @Field("id") String resourceId);

    /**
     * 公司服务器获取视频列表
     */
    @FormUrlEncoded
    @POST("/resource/resource/ResourceList.htmls")
    Observable<VideoListBean> getVideoList(@Field("pId") String pId,
                                           @Field("page") int page,
                                           @Field("rows") int rows,
                                           @Field("type") String type,
                                           @Field("classID") String classId);

    /**
     * 公司服务器获取视频详情
     */
    @FormUrlEncoded
    @POST("/resource/video/getVideo.htmls")
    Observable<VideoDetailBean> getVideoDetail(@Field("machineCode") String machineCode,
                                               @Field("pId") String pId,
                                               @Field("id") String id,
                                               @Field("rows") int rows);

    /**
     * 公司服务器获取音频列表
     * http://222.223.215.75:8081/resource/resource/ResourceList.htmls?pId=6&page=1&rows=5&type=mp3
     */
    @FormUrlEncoded
    @POST("/resource/resource/ResourceList.htmls")
    Observable<Mp3ListBean> getMp3List(@Field("pId") String pId,
                                       @Field("page") int page,
                                       @Field("rows") int rows,
                                       @Field("type") String type,
                                       @Field("classID") String classId);

    /**
     * 公司服务器获取音频详情
     * http://222.223.215.75:8081/resource/mp3/getMP3.htmls?machineCode=ISQB4056&pId=7&id=7&rows=10
     */
    @FormUrlEncoded
    @POST("/resource/mp3/getMP3.htmls")
    Observable<Mp3DetailBean> getMp3Detail(@Field("machineCode") String machineCode,
                                               @Field("pId") String pId,
                                               @Field("id") String id,
                                               @Field("rows") int rows);





    /**
     * 公司服务器获取RSS订阅列表
     *
     * @return
     */
    @FormUrlEncoded
    @POST("/resource/rss/listRSS.htmls")
    Observable<RssListBean> getRssListBean(@Field("pId") String pId);


}
