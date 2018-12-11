package com.moon.immncweb.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author zhaoxiang
 * @Date 2018/11/28
 * @Desc 新闻页面数据类
 */
@Data
public class NewsVO implements Serializable {
    private static final long serialVersionUID = 4215819998497425003L;
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

    private String  classifyName;
    /**
     * 用户id
     */
    private String uid;

    /**
     * 距现在时间
     */
    private String formNowTime;

    private String realTime;
    /**
     * 封面图路径
     */
    private List<String> imgUrl;
    private List<String> imgDec;
    /**
     * 描述
     */
    private String des;


    /**
     * 是否原创 0否 1是
     */
    private Integer original;

    /**
     * 人气
     */
    private Integer lookNum;



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

    private List<String> keyList;

}
