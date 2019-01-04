package com.moon.immncweb.core.form;

import lombok.Data;

/**
 * @Author zhaoxiang
 * @Date 2018/12/24
 * @Desc
 */
@Data
public class AvatarForm {

    private String avatar_src;


    private SubImageForm avatar_data;

    private Object avatar_file;

}
