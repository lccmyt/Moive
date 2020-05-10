package com.bawei.moive.network;


import com.bawei.moive.bean.CommentReplayBean;
import com.bawei.moive.bean.DetailsMovieBean;
import com.bawei.moive.bean.EmailCodeBean;
import com.bawei.moive.bean.FilmReviewBean;
import com.bawei.moive.bean.LoadingMovieBean;
import com.bawei.moive.bean.LoginBean;
import com.bawei.moive.bean.NearByBean;
import com.bawei.moive.bean.RecommedCinemasBean;
import com.bawei.moive.bean.RegisterBean;
import com.bawei.moive.bean.ReplayCommentBean;
import com.bawei.moive.bean.UpcomingBean;
import com.bawei.moive.bean.WhiteEvalutionBean;
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

    //根据电影的id查询电影评论
    @GET("movie/v2/findAllMovieComment")
    Observable<FilmReviewBean> showFilmReview(@Query("movieId") int movieId, @Query("page") int page, @Query("count") int count);

    //添加用户对影片的评论
    @POST("movie/v1/verify/movieComment")
    @FormUrlEncoded
    Observable<WhiteEvalutionBean> whiteEvalution(@Field("movieId")int movieId,@Field("commentContent")String commentContent,@Field("score")double score);

    //查询影片评论回复
    @GET("movie/v1/findCommentReply")
    Observable<CommentReplayBean> replay(@Query("commentId") int comment, @Query("page") int page, @Query("count") int count);

    //添加用户对评论的回复
    @POST("movie/v1/verify/commentReply")
    @FormUrlEncoded
    Observable<ReplayCommentBean> replayComment(@Field("commentId")int commentId,@Field("replyContent")String replyContent);

    //查询推荐影院信息
    @GET("cinema/v1/findRecommendCinemas")
    Observable<RecommedCinemasBean> show(@Query("page") int page, @Query("count") int count);

    //查询附近影院
    @GET("cinema/v1/findNearbyCinemas")
    Observable<NearByBean> showNearCinemas(@Query("longitude") String longitude, @Query("latitude") String latitude, @Query("page") int page, @Query("count") int count);

}
