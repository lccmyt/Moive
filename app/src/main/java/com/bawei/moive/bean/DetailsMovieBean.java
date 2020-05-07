package com.bawei.moive.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.bean
 * @ClassName: DetailsMovieModel
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/25 18:00
 */
public class DetailsMovieBean {
    /**
     * result : {"commentNum":14,"duration":"105分钟","imageUrl":"http://mobile.bwstudent.com/images/movie/stills/fyz/fyz1.jpg","movieActor":[{"name":"\r\n路知行","photo":"http://mobile.bwstudent.com/images/movie/actor/fyz/luzhixing.jpg","role":"郎明"},{"name":"阎萌萌","photo":"http://mobile.bwstudent.com/images/movie/actor/fyz/yanmengmeng.jpg","role":"苏兮"},{"name":"\r\n褚珺","photo":"http://mobile.bwstudent.com/images/movie/actor/fyz/chujun.jpg","role":"梅冉"}],"movieDirector":[{"name":"刘阔","photo":"http://mobile.bwstudent.com/images/movie/director/fyz/1.jpg"}],"movieId":12,"movieType":"冒险 / 科幻 / 动画","name":"风语咒","placeOrigin":"中国大陆 ","posterList":["http://mobile.bwstudent.com/images/movie/stills/fyz/fyz1.jpg","http://mobile.bwstudent.com/images/movie/stills/fyz/fyz2.jpg","http://mobile.bwstudent.com/images/movie/stills/fyz/fyz3.jpg","http://mobile.bwstudent.com/images/movie/stills/fyz/fyz4.jpg","http://mobile.bwstudent.com/images/movie/stills/fyz/fyz5.jpg","http://mobile.bwstudent.com/images/movie/stills/fyz/fyz6.jpg"],"releaseTime":1536336000000,"score":9.7,"shortFilmList":[{"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/fyz/fyz2.jpg","videoUrl":"http://mobile.bwstudent.com/video/movie/fyz/fyz1.ts"},{"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/fyz/fyz3.jpg","videoUrl":"http://mobile.bwstudent.com/video/movie/fyz/fyz2.ts"},{"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/fyz/fyz4.jpg","videoUrl":"http://mobile.bwstudent.com/video/movie/fyz/fyz3.ts"}],"summary":"生活在孝阳岗的少年郎明怀揣侠岚梦想，但双眼失明的他却只能靠招摇撞骗混于市井之中。直到有一天，罗刹袭击孝阳岗，与他相依为命的母亲突然失踪，郎明迫不得已踏上了找寻真相之路。一波未平一波又起，上古神兽饕餮现世让人间危在旦夕，传说中的侠岚们也出现在眼前，郎明也踏上了改变一生的冒险之旅\u2026\u2026","whetherFollow":2}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ResultBean implements Serializable {
        /**
         * commentNum : 14
         * duration : 105分钟
         * imageUrl : http://mobile.bwstudent.com/images/movie/stills/fyz/fyz1.jpg
         * movieActor : [{"name":"\r\n路知行","photo":"http://mobile.bwstudent.com/images/movie/actor/fyz/luzhixing.jpg","role":"郎明"},{"name":"阎萌萌","photo":"http://mobile.bwstudent.com/images/movie/actor/fyz/yanmengmeng.jpg","role":"苏兮"},{"name":"\r\n褚珺","photo":"http://mobile.bwstudent.com/images/movie/actor/fyz/chujun.jpg","role":"梅冉"}]
         * movieDirector : [{"name":"刘阔","photo":"http://mobile.bwstudent.com/images/movie/director/fyz/1.jpg"}]
         * movieId : 12
         * movieType : 冒险 / 科幻 / 动画
         * name : 风语咒
         * placeOrigin : 中国大陆
         * posterList : ["http://mobile.bwstudent.com/images/movie/stills/fyz/fyz1.jpg","http://mobile.bwstudent.com/images/movie/stills/fyz/fyz2.jpg","http://mobile.bwstudent.com/images/movie/stills/fyz/fyz3.jpg","http://mobile.bwstudent.com/images/movie/stills/fyz/fyz4.jpg","http://mobile.bwstudent.com/images/movie/stills/fyz/fyz5.jpg","http://mobile.bwstudent.com/images/movie/stills/fyz/fyz6.jpg"]
         * releaseTime : 1536336000000
         * score : 9.7
         * shortFilmList : [{"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/fyz/fyz2.jpg","videoUrl":"http://mobile.bwstudent.com/video/movie/fyz/fyz1.ts"},{"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/fyz/fyz3.jpg","videoUrl":"http://mobile.bwstudent.com/video/movie/fyz/fyz2.ts"},{"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/fyz/fyz4.jpg","videoUrl":"http://mobile.bwstudent.com/video/movie/fyz/fyz3.ts"}]
         * summary : 生活在孝阳岗的少年郎明怀揣侠岚梦想，但双眼失明的他却只能靠招摇撞骗混于市井之中。直到有一天，罗刹袭击孝阳岗，与他相依为命的母亲突然失踪，郎明迫不得已踏上了找寻真相之路。一波未平一波又起，上古神兽饕餮现世让人间危在旦夕，传说中的侠岚们也出现在眼前，郎明也踏上了改变一生的冒险之旅……
         * whetherFollow : 2
         */

        private int commentNum;
        private String duration;
        private String imageUrl;
        private int movieId;
        private String movieType;
        private String name;
        private String placeOrigin;
        private long releaseTime;
        private double score;
        private String summary;
        private int whetherFollow;
        private List<MovieActorBean> movieActor;
        private List<MovieDirectorBean> movieDirector;
        private List<String> posterList;
        private List<ShortFilmListBean> shortFilmList;

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public String getMovieType() {
            return movieType;
        }

        public void setMovieType(String movieType) {
            this.movieType = movieType;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPlaceOrigin() {
            return placeOrigin;
        }

        public void setPlaceOrigin(String placeOrigin) {
            this.placeOrigin = placeOrigin;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public int getWhetherFollow() {
            return whetherFollow;
        }

        public void setWhetherFollow(int whetherFollow) {
            this.whetherFollow = whetherFollow;
        }

        public List<MovieActorBean> getMovieActor() {
            return movieActor;
        }

        public void setMovieActor(List<MovieActorBean> movieActor) {
            this.movieActor = movieActor;
        }

        public List<MovieDirectorBean> getMovieDirector() {
            return movieDirector;
        }

        public void setMovieDirector(List<MovieDirectorBean> movieDirector) {
            this.movieDirector = movieDirector;
        }

        public List<String> getPosterList() {
            return posterList;
        }

        public void setPosterList(List<String> posterList) {
            this.posterList = posterList;
        }

        public List<ShortFilmListBean> getShortFilmList() {
            return shortFilmList;
        }

        public void setShortFilmList(List<ShortFilmListBean> shortFilmList) {
            this.shortFilmList = shortFilmList;
        }

        public static class MovieActorBean {
            /**
             * name :
             路知行
             * photo : http://mobile.bwstudent.com/images/movie/actor/fyz/luzhixing.jpg
             * role : 郎明
             */

            private String name;
            private String photo;
            private String role;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }
        }

        public static class MovieDirectorBean {
            /**
             * name : 刘阔
             * photo : http://mobile.bwstudent.com/images/movie/director/fyz/1.jpg
             */

            private String name;
            private String photo;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
        }

        public static class ShortFilmListBean {
            /**
             * imageUrl : http://mobile.bwstudent.com/images/movie/stills/fyz/fyz2.jpg
             * videoUrl : http://mobile.bwstudent.com/video/movie/fyz/fyz1.ts
             */

            private String imageUrl;
            private String videoUrl;

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getVideoUrl() {
                return videoUrl;
            }

            public void setVideoUrl(String videoUrl) {
                this.videoUrl = videoUrl;
            }
        }
    }
}
