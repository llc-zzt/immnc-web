package com.moon.immncweb.common.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zhaoxiang
 * @Date 2018/11/28
 * @Desc
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MyPage {
    private Integer page;
    private Integer size;
}
