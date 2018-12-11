<!DOCTYPE html>
<html lang="en">
<#include "../common/seo-header.ftl">
<body>

<div class="moon-news-body">
    <!--导航-->
    <#include "../common/navigation.ftl">
    <!--内容-->
    <div class="moon-content">
        <!--carousel-->
        <!--新闻内容-->
        <div class="moon-content-news">
            <!--主体内容-->
            <div class="moon-content-news-lift background-color-detail margin-top-12">
                <!--主题内容-->
                <div class="moon-news-card ">
                    <div class="moon-news-detail">
                        <div class="news-detail-title">
                        ${newsVO.getTitle()}
                        </div>
                        <div class="news-detail-info">
                            <span class="moon-breadcrumb-detail">
                                <a>${newsVO.getClassifyName()}</a>
                                    <span>/</span>
                                  <a>正文</a>
                            </span>
                            <span class="moon-detail-info-time">
                                ${newsVO.getUsername()} ${newsVO.getRealTime()}
                            </span>
                        </div>
                        <div class="news-detail-content">
                            <div class="layui-carousel moon-content-carousel" id="moon-img-atlas">
                                <div carousel-item>
                                    <#list newsVO.getImgUrl() as item>
                                        <div>
                                            <div  class="moon-carousel-box">
                                                <div class="moon-carousel-p">
                                                <#if newsVO.imgDec?size == newsVO.imgUrl?size >
                                                    <h2>${newsVO.imgDec[item_index]}</h2>
                                                <#elseif (newsVO.imgUrl?size > newsVO.imgDec?size)>
                                                    <#if (item_index<newsVO.imgDec?size)>
                                                        <h2>${newsVO.imgDec[item_index]}</h2>
                                                    <#else >
                                                        <h2>${newsVO.imgDec?last}</h2>
                                                    </#if>
                                                <#elseif (newsVO.imgUrl?size < newsVO.imgDec?size)>
                                                    <#if (item_index>newsVO.imgDec?size)>
                                                        <h2>${newsVO.imgDec[item_index]}</h2>
                                                    <#else >
                                                        <h2>${newsVO.imgDec?last}</h2>
                                                    </#if>
                                                </#if>
                                                </div>
                                                <img class="moon-carousel-img" height="514px" src="${config.getImgPrefix()+item}">
                                                <div style="background: url('${config.getImgPrefix()+item}') no-repeat center center" class="moon-content-carousel-bg"></div>
                                            </div>
                                        </div>
                                    </#list>
                                </div>
                            </div>
                        </div>
                    </div>
                    <span class="moon-news-card-split"></span>
                </div>
                <!--评论-->
                <#include "../common/comment.ftl">
                <!--推荐内容-->
                <ul class="moon-elem-field" id="moon-elem-field">
                    <!--视频-->
                </ul>
            </div>
            <!--侧边内容-->
            <div class="moon-content-news-right">
                <!--横幅-->
                <div style="margin-top: 11px" class="moon-news-card moon-height-js">
                    <span class="moon-news-card-split2"></span>
                    <div class="news-hot-list">
                        <div class="hot-list-author">
                            <img class="author-avatar" src="${newsVO.getAvatar()}">
                            <div class="author-info">
                                <p>${newsVO.getUsername()}</p>
                                <button class="layui-btn layui-btn-xs layui-btn-danger">关注</button>
                            </div>
                        </div>
                        <div class="news-hot-content">
                            <#if (authorInfo.getRecords()?size >0)>
                                <ul>
                                    <#list authorInfo.getRecords() as item>
                                        <li class="moon-news-card">
                                            <a class="hot-item-title" onclick="goTo(${item.getClassifyId()},'${item.getArticleId()}')">
                                                <p>${item_index+1} ${item.getTitle()}</p>
                                            </a>
                                            <span class="moon-news-card-split"></span>
                                        </li>
                                    </#list>
                                </ul>
                            </#if>

                        </div>
                    </div>

                </div>

                <!--热搜风云榜-->
                <#if searchTopList?? && (searchTopList?size > 0)>
                    <div style="margin-top: 24px" id="top-side" class="moon-news-card moon-height-js">
                        <span class="moon-news-card-split2"></span>
                        <div class="news-hot-list">
                            <div class="news-hot-title"><p>热搜风云榜</p></div>
                            <div class="news-hot-content">
                                <ul>
                                    <#list searchTopList as item>
                                        <li class="moon-news-card" onclick="goTo(${classifyId},${item.getArticleId()})">
                                            <a class="hot-item-title">
                                                <p>${item_index+1} ${item.getTitle()}</p>
                                            <#--<span class="moon-news-color-hot">热</span>-->
                                            <#--<span class="moon-news-color-new">新</span>-->
                                            </a>
                                            <span class="moon-news-card-split"></span>
                                        </li>
                                    </#list>

                                </ul>
                            </div>
                        </div>

                    </div>
                </#if>
                <#--精彩图片-->
                <#if graphic?? && (graphic?size > 0)>
                    <div style="margin-top: 24px" class="moon-news-card moon-height-js">
                        <span class="moon-news-card-split2"></span>
                        <div class="news-atlas-list">
                            <div class="news-atlas-title"><p>精彩新闻</p></div>
                            <div class="news-atlas-content">
                                <div class="atlas-item-row">
                                    <#list graphic as item>
                                        <div style="margin-bottom: 10px"
                                             onclick="goTo(${classifyId},${item.getArticleId()})">
                                            <a class="atlas-item-column-a">
                                                <img class="atlas-item-column-img"
                                                     src="${config.getImgPrefix()+item.getImgUrl()[0]}" alt="">
                                            </a>
                                            <a class="atlas-item-column-info">${item.getTitle()}</a>
                                        </div>
                                    </#list>
                                </div>
                            </div>
                        </div>

                    </div>
                </#if>
                <#if imgMap?? && (imgMap?size > 0)>
                    <div style="margin-top: 24px" class="moon-news-card moon-height-js">
                        <span class="moon-news-card-split2"></span>
                        <div class="news-atlas-list">
                            <div class="news-atlas-title"><p>精彩图片</p></div>
                            <div class="news-atlas-content">
                                <div class="atlas-item-row">
                                    <#list imgMap as item>
                                        <div style="margin-bottom: 10px" onclick="goTo(${classifyId},${item.getArticleId()})">
                                            <a class="atlas-item-column-a">
                                                <img class="atlas-item-column-img" src="${item.getImgUrl()[0]}" alt="">
                                                <p>${item.getImgUrl()?size}图</p>
                                            </a>
                                            <a class="atlas-item-column-info">${item.getTitle()}</a>
                                        </div>
                                    </#list>
                                </div>
                            </div>
                        </div>

                    </div>
                </#if>
                <#--精彩视频-->
                <#if videoList?? && (videoList?size > 0) >
                    <div style="margin-top: 24px" class="moon-news-card moon-height-js">
                        <span class="moon-news-card-split2"></span>
                        <div class="news-atlas-list">
                            <div class="news-atlas-title"><p>精彩视频</p></div>
                            <div class="news-atlas-content">
                                <div class="atlas-item-row">
                                    <#list videoList as item>
                                        <div style="margin-bottom: 10px" onclick="goTo(${classifyId},${item.getArticleId()})">
                                            <a class="atlas-item-column-a">
                                                <img class="atlas-item-column-img" src="${config.getImgPrefix()+item.getImgUrl()[0]}" alt="">
                                                <i class="layui-icon immnc mmnc-shipinbofangyingpian"></i>
                                            </a>
                                            <a class="atlas-item-column-info">${item.getTitle()}</a>
                                        </div>
                                    </#list>
                                </div>
                            </div>
                        </div>

                    </div>
                </#if>
            </div>
        </div>
        <ul class="layui-fixbar">
            <!--<li class="layui-icon" lay-type="bar1" style=""></li>-->
            <li class="layui-icon layui-icon-top layui-fixbar-top" lay-type="top" style="display: none;"></li>
        </ul>
    </div>
    <!--底部-->
    <#include "../common/foot.ftl">
</div>
<script src="/layui/layui.js"></script>
<script src="/js/detail.js"></script>
<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/moon.js"></script>
<script src="/js/comment.js"></script>
<script src="/js/jquery.sinaEmotion.js"></script>
<script>
    document.addEventListener("DOMContentLoaded", ready);
    var urlPrefix = "https://p0.cdrysj.com/po";
    function ready() {
        getNav(${classifyId})
        postDetailFirstComment(${newsVO.getArticleId()})
    }
    getDetail(${newsVO.getClassifyId()})
    $(".cmt-list-box").on("click", '.cmt-load-more', function () {
        //加载评论
        postDetailAllComment(${newsVO.getArticleId()})
        $(this).css({"display": "none"})
        $(".cmt-load-more-loop").removeClass("hide")
    })
    // all
</script>
<script>
    layui.use('carousel', function () {
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#moon-img-atlas'
            , width: '100%' //设置容器宽度
            , height: '514px'
            , arrow: 'always' //始终显示箭头
            , anim: 'default' //切换动画方式
            , autoplay: false
            //,indicator: 'none'//指示器位置
        });
    });
</script>
</body>
</html>
