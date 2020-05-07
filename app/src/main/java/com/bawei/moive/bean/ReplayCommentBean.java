package com.bawei.moive.bean;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.bean
 * @ClassName: ReplayCommentBean
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/5/7 22:53
 */
public class ReplayCommentBean {
    /**
     * message : 回复成功
     * status : 0000
     */

    private String message;
    private String status;

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
}
