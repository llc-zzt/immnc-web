package com.moon.immncweb.core.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.moon.immncweb.common.bean.ResponseCode;
import com.moon.immncweb.common.bean.ResponseVO;
import com.moon.immncweb.core.entity.UserInfo;
import com.moon.immncweb.core.mapper.UserInfoMapper;
import com.moon.immncweb.core.service.UserInfoService;
import com.moon.immncweb.core.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author zhaoxiang
 * @Date 2018/11/26
 * @Desc
 */
@Service
@Transactional
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper,UserInfo> implements UserInfoService {


    @Autowired
    private UploadUtils uploadUtils;

    @Override
    public ResponseVO<String> updateUserAvatar(String userId,MultipartFile file, String avatar_data) {
        String avatarPath = null;
        try {
            avatarPath = uploadUtils.uploadAvatar(file,avatar_data);
        } catch (IOException e) {
            return ResponseVO.e(ResponseCode.FILE_UPLOAD_FAIL);
        }
        if (avatar_data == null){
            return ResponseVO.e(ResponseCode.FILE_UPLOAD_FAIL);
        }
        UserInfo userInfo = this.selectById(userId);
        if (userId == null){
            return ResponseVO.e(ResponseCode.FAIL);
        }
        userInfo.setAvatar(avatarPath);
        this.updateById(userInfo);
        return ResponseVO.e(ResponseCode.SUCCESS,avatarPath);
    }

    @Override
    public UserInfo getUserInfoById(String userId) {
        return this.selectById(userId);
    }
}
