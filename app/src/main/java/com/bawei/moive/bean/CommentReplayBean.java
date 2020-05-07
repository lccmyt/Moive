package com.bawei.moive.bean;

import java.util.List;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.bean
 * @ClassName: CommentReplayBean
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/5/7 22:18
 */
public class CommentReplayBean {
    /**
     * result : [{"replyContent":"好","replyHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-04-24/20200424213005.unknown","replyTime":1584168185000,"replyUserId":13823,"replyUserName":"久渔*"},{"replyContent":"好","replyHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-04-24/20200424213005.unknown","replyTime":1584168185000,"replyUserId":13823,"replyUserName":"久渔*"},{"replyContent":"好","replyHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-04-24/20200424213005.unknown","replyTime":1584168185000,"replyUserId":13823,"replyUserName":"久渔*"},{"replyContent":"好","replyHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-04-24/20200424213005.unknown","replyTime":1584168136000,"replyUserId":13823,"replyUserName":"久渔*"},{"replyContent":"好","replyHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-04-24/20200424213005.unknown","replyTime":1584153288000,"replyUserId":13823,"replyUserName":"久渔*"},{"replyContent":"{replyContent}","replyHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-04-24/20200424213005.unknown","replyTime":1584153032000,"replyUserId":13823,"replyUserName":"久渔*"},{"replyContent":"好","replyHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-04-24/20200424213005.unknown","replyTime":1584153021000,"replyUserId":13823,"replyUserName":"久渔*"},{"replyContent":"好看","replyHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-04-24/20200424213005.unknown","replyTime":1584152899000,"replyUserId":13823,"replyUserName":"久渔*"},{"replyContent":"好看","replyHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-04-24/20200424213005.unknown","replyTime":1584152878000,"replyUserId":13823,"replyUserName":"久渔*"},{"replyContent":"nihao","replyHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-03-12/20200312152342.jpg","replyTime":1583153468000,"replyUserId":13744,"replyUserName":"nisss"}]
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

    public static class ResultBean {
        /**
         * replyContent : 好
         * replyHeadPic : http://mobile.bwstudent.com/images/movie/head_pic/2020-04-24/20200424213005.unknown
         * replyTime : 1584168185000
         * replyUserId : 13823
         * replyUserName : 久渔*
         */

        private String replyContent;
        private String replyHeadPic;
        private long replyTime;
        private int replyUserId;
        private String replyUserName;

        public String getReplyContent() {
            return replyContent;
        }

        public void setReplyContent(String replyContent) {
            this.replyContent = replyContent;
        }

        public String getReplyHeadPic() {
            return replyHeadPic;
        }

        public void setReplyHeadPic(String replyHeadPic) {
            this.replyHeadPic = replyHeadPic;
        }

        public long getReplyTime() {
            return replyTime;
        }

        public void setReplyTime(long replyTime) {
            this.replyTime = replyTime;
        }

        public int getReplyUserId() {
            return replyUserId;
        }

        public void setReplyUserId(int replyUserId) {
            this.replyUserId = replyUserId;
        }

        public String getReplyUserName() {
            return replyUserName;
        }

        public void setReplyUserName(String replyUserName) {
            this.replyUserName = replyUserName;
        }
    }
}
