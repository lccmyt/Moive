package com.bawei.moive.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.bean
 * @ClassName: FilmReviewBean
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/5/6 20:41
 */
public class FilmReviewBean implements Serializable {
    /**
     * result : [{"commentContent":"����","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-04-23/20200423163913.png","commentId":7834,"commentTime":1586572649000,"commentUserId":13913,"commentUserName":"��dsd��","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"15","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-04-27/20200427213048.unknown","commentId":6776,"commentTime":1586479937000,"commentUserId":13692,"commentUserName":"���С�ɰ�","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":11},{"commentContent":"����","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-03-15/20200315204539.jpg","commentId":3813,"commentTime":1586402498000,"commentUserId":13770,"commentUserName":"I啦啦啦I","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"������","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-02-18/20200218105640.jpg","commentId":2245,"commentTime":1586336440000,"commentUserId":13728,"commentUserName":"You","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":6.3},{"commentContent":"��ֵ��","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg","commentId":749,"commentTime":1586154869000,"commentUserId":13871,"commentUserName":"�����ѩ","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable {
        /**
         * commentContent : ����
         * commentHeadPic : http://mobile.bwstudent.com/images/movie/head_pic/2020-04-23/20200423163913.png
         * commentId : 7834
         * commentTime : 1586572649000
         * commentUserId : 13913
         * commentUserName : ��dsd��
         * greatNum : 0
         * isGreat : 0
         * replyHeadPic : []
         * replyNum : 0
         * score : 4.5
         */

        private String commentContent;
        private String commentHeadPic;
        private int commentId;
        private long commentTime;
        private int commentUserId;
        private String commentUserName;
        private int greatNum;
        private int isGreat;
        private int replyNum;
        private double score;
        private List<?> replyHeadPic;

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public String getCommentHeadPic() {
            return commentHeadPic;
        }

        public void setCommentHeadPic(String commentHeadPic) {
            this.commentHeadPic = commentHeadPic;
        }

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public int getCommentUserId() {
            return commentUserId;
        }

        public void setCommentUserId(int commentUserId) {
            this.commentUserId = commentUserId;
        }

        public String getCommentUserName() {
            return commentUserName;
        }

        public void setCommentUserName(String commentUserName) {
            this.commentUserName = commentUserName;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public int getIsGreat() {
            return isGreat;
        }

        public void setIsGreat(int isGreat) {
            this.isGreat = isGreat;
        }

        public int getReplyNum() {
            return replyNum;
        }

        public void setReplyNum(int replyNum) {
            this.replyNum = replyNum;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public List<?> getReplyHeadPic() {
            return replyHeadPic;
        }

        public void setReplyHeadPic(List<?> replyHeadPic) {
            this.replyHeadPic = replyHeadPic;
        }
    }
}
