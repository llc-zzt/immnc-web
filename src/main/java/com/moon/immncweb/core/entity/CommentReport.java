package com.moon.immncweb.core.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @Author  Administrator
 * @Date    2018/5/26 13:19
 * @Desc    回复举报
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentReport implements Serializable {
    private static final long serialVersionUID = 4368748576166208584L;
    @TableId(type = IdType.AUTO)
    private String id;

    /**
     * 举报者用户id
     */
    private String reportId;

    /**
     * 举报发送的内容
     */
    private String content;

    /**
     * 举报类型
     */
    private Integer typeId;

    /**
     * 被举报的回复Id
     */
    private String commentId;

    /**
     * 评论回复举报处理状态
     */
    private Integer disposeState;

    /**
     * 举报的时间
     */
    private Long time;
}
