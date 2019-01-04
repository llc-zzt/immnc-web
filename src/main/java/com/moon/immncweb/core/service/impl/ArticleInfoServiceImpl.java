package com.moon.immncweb.core.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.moon.immncweb.common.bean.MyPage;
import com.moon.immncweb.common.exception.APIException;
import com.moon.immncweb.common.vo.NewsVO;
import com.moon.immncweb.core.config.WebUrlConfig;
import com.moon.immncweb.core.entity.ArticleInfo;
import com.moon.immncweb.core.mapper.ArticleInfoMapper;
import com.moon.immncweb.core.mapper.CommentMapper;
import com.moon.immncweb.core.service.ArticleInfoService;
import com.moon.immncweb.core.utils.SplitUtil;
import com.moon.immncweb.core.utils.TimeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author zhaoxiang
 * @Date 2018/11/27
 * @Desc
 */
@Service
@CacheConfig(cacheNames = "news")
public class ArticleInfoServiceImpl extends ServiceImpl<ArticleInfoMapper, ArticleInfo> implements ArticleInfoService {

    @Autowired
    private WebUrlConfig config;
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public List<NewsVO> selectBannerToDB() {
        EntityWrapper<ArticleInfo> wrapper = new EntityWrapper<>();
//      `draft` = 0 and `show_state` = 1 and `manage_id` = 1 and `slide_state` = 1 and `audit_state` = 1
        Map<String, Object> map = new HashMap<>();
        map.put("draft", 0);
        map.put("show_state", 1);
        map.put("manage_id", 1);
        map.put("slide_state", 1);
        map.put("audit_state", 1);
        wrapper.allEq(map);
        List<ArticleInfo> infoList = this.selectList(wrapper);
        List<NewsVO> newsVOList = new ArrayList<>();
        // 返回对象数据转换
        if (!infoList.isEmpty()) {
            newsVOList = infoList.stream().map(e -> {
                return articleToNews(e);
            }).collect(Collectors.toList());
        }
        return newsVOList;

    }

    @Override
    @Cacheable(key = "1")
    public List<NewsVO> selectSideGraphic() {
//        `draft` = 0 and `show_state` = 1 and `manage_id` = 1 and `type_id` = 1 and `audit_state` = 1 and `recommend_state`= 1
        EntityWrapper<ArticleInfo> wrapper = new EntityWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("draft", 0);
        map.put("show_state", 1);
        map.put("manage_id", 1);
        map.put("type_id", 1);
        map.put("audit_state", 1);
        map.put("recommend_state", 1);
        wrapper.allEq(map).orderBy("crate_time", false);
        List<ArticleInfo> infoList = this.selectList(wrapper);
        List<NewsVO> newsVOList = new ArrayList<>();
        // 返回对象数据转换
        if (!infoList.isEmpty()) {
            newsVOList = infoList.stream().map(e -> {
                return articleToNews(e);
            }).collect(Collectors.toList());
        }
        return newsVOList;
    }

    @Override
    @Cacheable(key = "2")
    public List<NewsVO> selectSideImgMap() {
        EntityWrapper<ArticleInfo> wrapper = new EntityWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("draft", 0);
        map.put("show_state", 1);
        map.put("manage_id", 1);
        map.put("type_id", 2);
        map.put("audit_state", 1);
        map.put("recommend_state", 1);
        wrapper.allEq(map).orderBy("crate_time", false);
        List<ArticleInfo> infoList = this.selectList(wrapper);
        List<NewsVO> newsVOList = new ArrayList<>();
        // 返回对象数据转换
        if (!infoList.isEmpty()) {
            newsVOList = infoList.stream().map(e -> {
                return articleToNews(e);
            }).collect(Collectors.toList());
        }
        return newsVOList;
    }

    @Override
    @Cacheable(key = "3")
    public List<NewsVO> selectSideVideo() {
        EntityWrapper<ArticleInfo> wrapper = new EntityWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("draft", 0);
        map.put("show_state", 1);
        map.put("manage_id", 1);
        map.put("type_id", 3);
        map.put("audit_state", 1);
        map.put("recommend_state", 1);
        wrapper.allEq(map).orderBy("crate_time", false);
        List<ArticleInfo> infoList = this.selectList(wrapper);
        List<NewsVO> newsVOList = new ArrayList<>();
        // 返回对象数据转换
        if (!infoList.isEmpty()) {
            newsVOList = infoList.stream().map(e -> {
                return articleToNews(e);
            }).collect(Collectors.toList());
        }
        return newsVOList;
    }

    @Override
    public Page<NewsVO> selectHomeNewsByPage(Page<ArticleInfo> page) {
        EntityWrapper<ArticleInfo> wrapper = new EntityWrapper<>();
        Map<String, Object> map = new HashMap<>();
        // TODO 排除定置
//        `draft` = 0 and `show_state` = 1 and `manage_id` != 1  and `audit_state` = 1 and `top_state` != 1  ORDER BY `crate_time`
        map.put("draft", 0);
        map.put("show_state", 1);
        map.put("audit_state", 1);
        wrapper.allEq(map)
                .ne("manage_id", 1)
                .ne("top_state", 1)
                .orderBy("crate_time", false);
        Page<ArticleInfo> articleInfoPage = this.selectPage(page, wrapper);
        Page<NewsVO> newsVOPage = new Page<>();
        BeanUtils.copyProperties(articleInfoPage, newsVOPage);
        if (!articleInfoPage.getRecords().isEmpty()) {
            newsVOPage.setRecords(articleInfoPage.getRecords().stream().map(e -> {
                return articleToNews(e);
            }).collect(Collectors.toList()));
        }
        return newsVOPage;
    }

    @Override
    public Page<NewsVO> selectClassifyNewsByPage(Page<ArticleInfo> page, Integer classify) {
        EntityWrapper<ArticleInfo> wrapper = new EntityWrapper<>();
        Map<String, Object> map = new HashMap<>();
        // TODO 排除定置
//        `draft` = 0 and `show_state` = 1 and `manage_id` != 1  and `audit_state` = 1 and `top_state` != 1  ORDER BY `crate_time`
        map.put("draft", 0);
        map.put("show_state", 1);
        map.put("audit_state", 1);
        map.put("classify_id", classify);
        wrapper.allEq(map)
                .ne("manage_id", 1)
                .ne("top_state", 1)
                .orderBy("crate_time", false);
        Page<ArticleInfo> articleInfoPage = this.selectPage(page, wrapper);
        Page<NewsVO> newsVOPage = new Page<>();
        BeanUtils.copyProperties(articleInfoPage, newsVOPage);
        if (!articleInfoPage.getRecords().isEmpty()) {
            newsVOPage.setRecords(articleInfoPage.getRecords().stream().map(e -> {
                return articleToNews(e);
            }).collect(Collectors.toList()));
        }
        return newsVOPage;
    }

    @Override
    public List<NewsVO> selectHomeTopToDb() {
        EntityWrapper<ArticleInfo> wrapper = new EntityWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("draft", 0);
        map.put("show_state", 2);
        map.put("audit_state", 1);
        map.put("top_state", 1);
        wrapper.allEq(map)
                .orderBy("top_sort", false);
        List<ArticleInfo> articleInfoList = this.selectList(wrapper);
        List<NewsVO> newsVOList = new ArrayList<>();
        if (!articleInfoList.isEmpty()) {
            newsVOList = articleInfoList.stream().map(e ->
                    {
                        return articleToNews(e);
                    }
            ).collect(Collectors.toList());
        }
        return newsVOList;
    }

    @Override
    public NewsVO selectNewsDetail(String id) {
        ArticleInfo articleInfo = this.selectById(id);
        this.baseMapper.updateTopNum(id);
        return articleToNews(articleInfo);
    }

    @Override
    public List<NewsVO> selectHotSearch() {
//        `draft` = 0 and `show_state` = 1 and `audit_state` = 1 order by `search_num` desc limit 0,10
        Page<ArticleInfo> page = new Page<>(1, 10);
        EntityWrapper<ArticleInfo> wrapper = new EntityWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("draft", 0);
        map.put("show_state", 1);
        map.put("audit_state", 1);
        wrapper.allEq(map)
                .orderBy("search_num", false);
        List<ArticleInfo> list = this.selectPage(page, wrapper).getRecords();
        List<NewsVO> newsVOList = new ArrayList<>();
        if (!list.isEmpty()) {
            newsVOList = list.stream().map(e -> {
                return articleToNews(e);
            }).collect(Collectors.toList());
        }

        return newsVOList;
    }

    @Override
    public Page<NewsVO> selectByAuthor(Page<ArticleInfo> page, String userId) {
        EntityWrapper<ArticleInfo> wrapper = new EntityWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("draft", 0);
        map.put("show_state", 1);
        map.put("audit_state", 1);
        map.put("uid", userId);
        wrapper.allEq(map)
                .orderBy("crate_time", false);
        Page<ArticleInfo> articleInfoPage = this.selectPage(page, wrapper);
        Page<NewsVO> newsVOPage = new Page<>();
        BeanUtils.copyProperties(articleInfoPage, newsVOPage);
        if (!articleInfoPage.getRecords().isEmpty()) {
            newsVOPage.setRecords(articleInfoPage.getRecords().stream().map(e -> {
                return articleToNews(e);
            }).collect(Collectors.toList()));
        }
        return newsVOPage;
    }

    @Override
    public Page<NewsVO> selectNewsByKeyWords(Page<ArticleInfo> page, String key) {
        EntityWrapper<ArticleInfo> wrapper = new EntityWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("draft", 0);
        map.put("show_state", 1);
        map.put("audit_state", 1);
        wrapper.allEq(map)
                .like("keywords", key)
                .orderBy("crate_time", false)
                .orderBy("search_num", false);
        Page<ArticleInfo> articleInfoPage = this.selectPage(page, wrapper);
        Page<NewsVO> newsVOPage = new Page<>();
        BeanUtils.copyProperties(articleInfoPage, newsVOPage);
        if (!articleInfoPage.getRecords().isEmpty()) {
            newsVOPage.setRecords(articleInfoPage.getRecords().stream().map(e -> {
                return articleToNews(e);
            }).collect(Collectors.toList()));
        }
        return newsVOPage;
    }

    @Override
    public Page<NewsVO> selectNewsByDetailType(Page<ArticleInfo> page, Integer type) {
        EntityWrapper<ArticleInfo> wrapper = new EntityWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("draft", 0);
        map.put("show_state", 1);
        map.put("audit_state", 1);
        map.put("type_id", type);
        wrapper.allEq(map)
                .orderBy("crate_time", false);
        Page<ArticleInfo> articleInfoPage = this.selectPage(page, wrapper);
        Page<NewsVO> newsVOPage = new Page<>();
        BeanUtils.copyProperties(articleInfoPage, newsVOPage);
        if (!articleInfoPage.getRecords().isEmpty()) {
            newsVOPage.setRecords(articleInfoPage.getRecords().stream().map(e -> {
                return articleToNews(e);
            }).collect(Collectors.toList()));
        }
        return newsVOPage;
    }

    @Override
    public void updateTopNum(String articleId) {
        this.baseMapper.updateTopNum(articleId);
    }

    @Override
    public Page<NewsVO> pageLikeSearch(Page<ArticleInfo> page, String key) {
        EntityWrapper<ArticleInfo> wrapper = new EntityWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("draft", 0);
        map.put("show_state", 1);
        map.put("audit_state", 1);
        wrapper.allEq(map)
                .like("title",key)
                .orderBy("crate_time", false);
        Page<ArticleInfo> articleInfoPage = this.selectPage(page, wrapper);
        Page<NewsVO> newsVOPage = new Page<>();
        BeanUtils.copyProperties(articleInfoPage, newsVOPage);
        if (!articleInfoPage.getRecords().isEmpty()) {
            newsVOPage.setRecords(articleInfoPage.getRecords().stream().map(e -> {
                return articleToNews(e);
            }).collect(Collectors.toList()));
        }
        return newsVOPage;
    }



    /**
     * 对象转换
     *
     * @param articleInfo
     * @return
     */
    private NewsVO articleToNews(ArticleInfo articleInfo) {
        NewsVO newsVO = new NewsVO();
        BeanUtils.copyProperties(articleInfo, newsVO);
        newsVO.setFormNowTime(TimeUtil.getCurrentTimeMillisDiff(articleInfo.getAuditTime()));
        newsVO.setRealTime(TimeUtil.getDateFormat(articleInfo.getAuditTime()));
        newsVO.setKeyList(SplitUtil.split(articleInfo.getKeywords(),","));
        newsVO.setImgUrl(SplitUtil.split(articleInfo.getImgUrl(), ",",articleInfo.getTypeId(),articleInfo.getIsOwn()));
        if (articleInfo.getTypeId() == 2) {
            newsVO.setImgDec(SplitUtil.split(articleInfo.getContent(), ","));
        }
        return newsVO;
    }


}
