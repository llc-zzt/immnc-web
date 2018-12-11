package com.moon.immncweb.core.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zhaoxiang
 * @Date 2018/11/02
 * @Desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleInfo implements Serializable {

    private static final long serialVersionUID = 7279814820261150348L;
    @TableId
    private String articleId;
    /**
     * 标题
     */
    private String title;

    /**
     * 类型 1-图文 2-多图文 3-视频
     */
    private Integer typeId;

    /**
     * 文章类容
     */
    private String content;

    /**
     * 列别名称 头条   科技   娱乐  游戏   搞笑  文史   视频
     */
    private Integer classifyId;

    /**
     * 用户id
     */
    private String uid;

    /**
     * 创建时间
     */
    private Long crateTime;

    /**
     * 关键词
     */
    private String keywords;

    /**
     * 审核状态：0未通过，1通过，2待审核
     */


    /**
     * 封面图路径
     */

    private String imgUrl;

    /**
     * 是否安排
     */
    private Integer manageId;

    /**
     * 是否上轮播图
     */
    private Integer slideState;

    /**
     * 是否上侧边栏
     */
    private Integer recommendState;

    /**
     * 展示否 0不展示，1展示
     */
    private Integer showState;

    /**
     * 描述
     */
    private String des;

    /**
     * 1：草稿，2：不是草稿
     */
    private Integer draft;

    /**
     * 是否原创 0否 1是
     */
    private Integer original;

    /**
     * 人气
     */
    private Integer lookNum;

    /**
     * 审核时间
     */
    private Long auditTime;

    /**
     * 是否是发布的文章 1:是，2:不是
     */

    private Integer isOwn;

    /**
     * 文章点赞数
     */
    private Integer praiseNum;

    //用户名
    private String username;

    //用户头像
    private String avatar;

    //评论数量
    private Integer commentNum;
    private Date newsTime;
//    类别
    private String classifyName;
    private Integer searchNum;

}
