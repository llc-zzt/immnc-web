<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}_搜索页</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <link rel="stylesheet" href="/styles/moon.css">
    <link rel="stylesheet" href="/font/iconfont.css">
    <link rel="shortcut icon" href="/images/web_icon.ico"/>
    <link rel="stylesheet" href="/styles/animate.css">
    <style>
        body {
            background-color: #f2f2f2
        }
    </style>
</head>
<body>
<div class="moon-news-body">
    <!--导航-->
    <#include "../common/navigation.ftl">
    <div class="moon-content">
        <div class="search-model-input" style="width: 100%;margin-top: 20px;">
            <input type="search" value="${title!}" id="searchValue" placeholder="搜个关键字看看~" style="border: 1px rgb(255, 255, 255) solid;">
            <button class="layui-btn" onclick="submitSearch()">
                立即搜索
            </button>
        </div>
        <div class="search-hot-area">
            <div class="search-hot-key">
                <div class="search-hot-key-title">
                    热搜关键词:
                </div>
                <ul class="search-hot-key-list">
                    <#list searchHotWords as item>
                        <li> <a href="/search/page.html?key=${item.getContent()}" target="_blank">${item.getContent()}</a></li>
                    </#list>


                </ul>
            </div>
        </div>

        <div class="moon-content-news">
            <!--主体内容-->

            <div class="moon-content-news-lift background-color-detail">
                <!--主题内容-->
                <!--list内容-->
                <div class="search-detail-list-label">
                    <div class="moon-detail-feed">
                        <div class="title">搜索结果</div>
                    </div>
                </div>
                <ul class="moon-elem-field " id="search_list">
                </ul>
                <div class="search-detail-list-label">
                    <div class="moon-detail-feed">
                        <div class="title">更多精彩</div>
                    </div>
                </div>
                <ul class="moon-elem-field" id="search_more_list">

                </ul>

            </div>
            <!--侧边内容-->
            <div class="moon-content-news-right">
                <!--横幅-->
                 <#if searchTopList?? && (searchTopList?size > 0)>
                    <div style="margin-bottom: 22px" class="moon-news-card moon-height-js">
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
                <div id="top-side">
                <#--精彩图片-->
                    <#if graphic?? && (graphic?size > 0)>
                    <div style="margin-top: 2px" class="moon-news-card moon-height-js">
                        <span class="moon-news-card-split2"></span>
                        <div class="news-atlas-list">
                            <div class="news-atlas-title"><p>精彩新闻</p></div>
                            <div class="news-atlas-content">
                                <div class="atlas-item-row">
                                <#list graphic as item>
                                    <div class="atlas-column-t-i">
                                        <a class="atlas-item-column-t-i"
                                           onclick="goTo(${classifyId},${item.getArticleId()})">
                                            <div class="atlas-item-column-img">
                                                <img class="" src="${item.getImgUrl()[0]}" alt="">
                                            </div>
                                        </a>
                                        <a onclick="goTo(${classifyId},${item.getArticleId()})"
                                           class="atlas-item-column-info">${item.getTitle()}</a>
                                    </div>
                                </#list>
                                </div>
                            </div>
                        </div>
                    </div>
                    </#if>
                </div>
                <#if imgMap?? && (imgMap?size > 0)>
                    <div style="margin-top: 24px" class="moon-news-card moon-height-js">
                        <span class="moon-news-card-split2"></span>
                        <div class="news-atlas-list">
                            <div class="news-atlas-title"><p>精彩图片</p></div>
                            <div class="news-atlas-content">
                                <div class="atlas-item-row">
                                    <#list imgMap as item>
                                        <div style="margin-bottom: 10px"
                                             onclick="goTo(${classifyId},${item.getArticleId()})">
                                            <a class="atlas-item-column-a">
                                                <div class="atlas-item-column-img">
                                                    <img class="" src="${config.getImgPrefix()+item.getImgUrl()[0]}" alt="">
                                                </div>
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
                                        <div style="margin-bottom: 10px"
                                             onclick="goTo(${classifyId},${item.getArticleId()})">
                                            <a class="atlas-item-column-a">
                                                <div class="atlas-item-column-img">
                                                    <img class="" src="${config.getImgPrefix()+item.getImgUrl()[0]}" alt="">
                                                </div>
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
    </div>
</div>

<script src="/layui/layui.js"></script>
<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/jquery.cookie.js"></script>
<script src="/js/moon.js"></script>
<script src="/js/search-list.js"></script>
<script>
    document.addEventListener("DOMContentLoaded", ready);
    var urlPrefix = "https://p0.cdrysj.com/po";
    function ready() {
        getNav(0)
    }
    getSearchList('${title}')
    getSearchMoreList('${title}')
    function goToS(classifyId, newsId) {
        updateTopNum(newsId);
        window.open('/detail/' + classifyId + '/' + newsId + '.html')
    }
    function submitSearch() {
        var searchValue = $("#searchValue").val();
        if (searchValue == ""){
            layui.use('layer', function () {
                var layer = layui.layer;
                layer.msg("请输入要搜索的词")
            });
        }else {
            location = '/search/page.html?key=' + searchValue
        }
    }
</script>
</body>
</html>
