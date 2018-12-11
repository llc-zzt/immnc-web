package com.moon.immncweb.core.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.moon.immncweb.common.bean.MyPage;
import com.moon.immncweb.common.vo.NewsVO;
import com.moon.immncweb.core.entity.ArticleInfo;

import java.util.List;

/**
 * @Author zhaoxiang
 * @Date 2018/11/26
 * @Desc
 */
public interface ArticleInfoService {

    /**
     * MySQL查找网站设置的轮播图
     * @return
     */
    List<NewsVO> selectBannerToDB();

    /**
     * mysql查找首页侧边栏图文
     * @return
     */
    List<NewsVO> selectSideGraphic();

    /**
     * mysql查找首页侧边栏多图
     * @return
     */
    List<NewsVO> selectSideImgMap();

    /**
     * mysql查找首页侧边栏视频
     * @return
     */
    List<NewsVO> selectSideVideo();

    /**
     * 首页文章按时间排序
     * @param page
     * @return
     */
    Page<NewsVO> selectHomeNewsByPage(Page<ArticleInfo> page);

    /**
     * 分类文章按时间排序
     * @param page
     * @param classify
     * @return
     */
    Page<NewsVO> selectClassifyNewsByPage(Page<ArticleInfo> page,Integer classify);

    /**
     *  首页顶置文章
     * @return
     */
    List<NewsVO> selectHomeTopToDb();

    /**
     * 侧边热搜
     * @return
     */
    List<NewsVO> selectHotSearch();

    /**
     * 查找文章详情
     * @param id
     * @return
     */
    NewsVO selectNewsDetail(String id);

    /**
     * 查找详情中作者的发的文章
     * @param page
     * @param userId
     * @return
     */
    Page<NewsVO> selectByAuthor(Page<ArticleInfo> page ,String userId);

    /**
     * 关键字查找
     * @param page
     * @param key
     * @return
     */
    Page<NewsVO> selectNewsByKeyWords(Page<ArticleInfo> page ,String key);

    /**
     * 查找详情页的推荐文章
     * @param page
     * @param type
     * @return
     */
    Page<NewsVO> selectNewsByDetailType(Page<ArticleInfo> page ,Integer type);

    /**
     * 文章查看数量更新
     * @param articleId
     */
    void updateTopNum(String articleId);
}
