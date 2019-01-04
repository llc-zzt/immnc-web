package com.moon.immncweb.core.service;

import com.baomidou.mybatisplus.service.IService;
import com.moon.immncweb.common.bean.ResponseVO;
import com.moon.immncweb.core.entity.UserInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author zhaoxiang
 * @Date 2018/11/26
 * @Desc
 */
public interface UserInfoService extends IService<UserInfo> {

    /**
     * 上传修改头像
     * @param file
     * @param avatar_data
     * @return
     */
    ResponseVO<String> updateUserAvatar(String userId,MultipartFile file,String avatar_data);

    UserInfo getUserInfoById(String userId);
}
