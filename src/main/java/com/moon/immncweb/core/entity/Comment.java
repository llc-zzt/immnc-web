package com.moon.immncweb.core.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * @Author  Administrator
 * @Date    2018/5/22 12:02
 * @Desc    评论
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment implements Serializable {
    private static final long serialVersionUID = -1357201236008423816L;
    @TableId
    private String id;

    /**
     * 评论人id
     */
    private String uid;

    /**
     * 评论文章id
     */
    private String aid;

    /**
     * 评论内容
     */
    private String commentInfo;

    /**
     * 评论时间
     */
    private Long time;

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
