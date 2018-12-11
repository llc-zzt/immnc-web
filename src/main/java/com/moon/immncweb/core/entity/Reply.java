package com.moon.immncweb.core.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * @Author  Administrator
 * @Date    2018/5/22 12:06
 * @Desc    回复
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reply implements Serializable {
    private static final long serialVersionUID = -6689529068169072178L;
    @TableId
    private String id;

    /**
     * 评论的id
     */
    private String commId;

    /**
     * 被回复的id
     */
    private String byReplyId;

    /**
     * 被回复者的id
     */
    private String cid;

    /**
     * 回复者id
     */
    private String rid;

    /**
     * 回复内容
     */
    private String replyInfo;

    /**
     * 回复时间
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
