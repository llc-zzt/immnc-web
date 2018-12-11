package com.moon.immncweb.core.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.moon.immncweb.core.entity.UserInfo;
import com.moon.immncweb.core.mapper.UserInfoMapper;
import com.moon.immncweb.core.service.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author zhaoxiang
 * @Date 2018/11/26
 * @Desc
 */
@Service
@Transactional
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper,UserInfo> implements UserInfoService {

}
