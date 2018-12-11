package com.moon.immncweb.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author zhaoxiang
 * @Date 2018/12/11
 * @Desc
 */
@Data
public class CommentVO implements Serializable {

    private static final long serialVersionUID = 3753634002475186143L;
    private String id;

    /**
     * 评论人id
     */
    private String uid;
    private String aid;

    /**
     * 评论内容
     */
    private String commentInfo;

    /**
     * 评论时间
     */
    private String time;

    /**
     * 赞数量
     */
    private Integer praiseNum;

    /**
     * 展示否
     */
    private Integer showState;

    private String nickName;

    private String avatar;
}
