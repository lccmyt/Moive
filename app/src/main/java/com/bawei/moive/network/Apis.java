package com.bawei.moive.network;


import com.bawei.moive.bean.DetailsMovieBean;
import com.bawei.moive.bean.EmailCodeBean;
import com.bawei.moive.bean.LoadingMovieBean;
import com.bawei.moive.bean.LoginBean;
import com.bawei.moive.bean.RegisterBean;
import com.bawei.moive.bean.UpcomingBean;
import com.bawei.moive.bean.XBannerBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @ProjectName: Demo_0411
 * @Package: com.bawei.demo_0411.network
 * @ClassName: Apis
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/11 9:35
 */
public interface Apis {
    @POST("user/v2/register")
    @FormUrlEncoded
    Observable<RegisterBean> register(@Field("nickName")String nickName,@Field("pwd")String pwd,@Field("email")String email,@Field("code")String code);

    @POST("user/v2/sendOutEmailCode")
    @FormUrlEncoded
    Observable<EmailCodeBean> getEmailCode(@Field("email")String emailPath);

    @POST("user/v2/login")
    @FormUrlEncoded
    Observable<LoginBean> doLogin(@Field("email") String email, @Field("pwd") String pwd);

    @GET("movie/v2/findReleaseMovieList")
    Observable<LoadingMovieBean> showLoadingMovie(@Query("page")int page,@Query("count")int count);

    @GET("movie/v2/findComingSoonMovieList")
    Observable<UpcomingBean> showUpcomingMovie(@Query("page")int page, @Query("count")int count);

    @GET("movie/v2/findHotMovieList")
    Observable<LoadingMovieBean> showHotMovie(@Query("page")int page,@Query("count")int count);

    @GET("tool/v2/banner")
    Observable<XBannerBean> xBanner();

    @GET("movie/v2/findMovieByKeyword")
    Observable<LoadingMovieBean> searchMovie(@Query("keyword") String keywork, @Query("page") int page, @Query("count") int count);

    @GET("movie/v2/findMoviesDetail")
    Observable<DetailsMovieBean> detailsMovieBean(@Query("movieId")int movieId);
}
