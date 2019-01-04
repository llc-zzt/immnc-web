<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${user.getNikeName()}-个人中心</title>
    <link rel="stylesheet" href="/styles/moon.css">
    <link rel="stylesheet" href="/font/iconfont.css">
    <link rel="stylesheet" href="/styles/animate.css">
    <link rel="stylesheet" href="/styles/personnel-info.css">
    <link rel="stylesheet" href="/layui/css/layui.css">
    <link rel="shortcut icon" href="/images/web_icon.ico"/>
    <style>
        body {
            background-color: #f2f2f2
        }


    </style>
</head>

<body>

<div class="moon-news-body">
    <!--导航-->
    <!--内容-->
<#include "../common/navigation.ftl">

    <div class="moon-content">
        <!--carousel-->
        <!--新闻内容-->
        <div class="moon-person-content">
            <div class="moon-news-card moon-person-header">
                <div class="person-background">
                    <div class="background-hover">
                        <span><i class="layui-icon layui-icon-refresh-1"></i> 更换背景 </span>
                    </div>
                    <img src="https://p0.cdrysj.com/po/read/img/user/1528890123021.jpg" alt="">
                </div>
                <div class="person-header-bottom">
                    <div class="person-avatar">
                        <img src="${user.getAvatar()}" alt="">
                    </div>
                    <p class="person-info">个性签名: ${user.getSignature()!}</p>
                    <div class="person-bottom-button">
                        <a class="layui-btn layui-btn-normal" href="/user/update/${user.getUserId()}.html"><i
                                class="layui-icon layui-icon-set"></i> 资料修改
                        </a>
                        <button class="layui-btn layui-btn-normal" onclick="wantToVIP()"><i class="layui-icon layui-icon-console"></i> 作者入驻
                        </button>
                    </div>
                </div>
            </div>
            <div class="moon-person-detail">
                <div class="person-detail-left">
                    <div class="person-info-box">
                        <div class="layui-tab layui-tab-brief" lay-filter="person-info-table">
                            <ul class="layui-tab-title">
                                <li class="layui-this">文章</li>
                                <li>视频</li>
                                <li>多图</li>
                                <li>关注</li>
                                <li>粉丝</li>
                            </ul>
                            <div class="layui-tab-content">
                                <div class="layui-tab-item layui-show">
                                    <ul class="moon-elem-field" id="personnelNews1">
                                        <!--图文-->
                                    </ul>
                                </div>
                                <div class="layui-tab-item">
                                    <ul class="moon-elem-field" id="personnelNews2">
                                        <!--视频-->

                                    </ul>
                                </div>
                                <div class="layui-tab-item">
                                    <ul class="moon-elem-field" id="personnelNews3">
                                        <!--多图-->
                                    </ul>
                                </div>
                                <div class="layui-tab-item">
                                    <ul class="attention-list" id="attentionList">
                                    </ul>
                                </div>
                                <div class="layui-tab-item">
                                    <ul class="attention-list" id="fansList">

                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="person-detail-right">
                    <!--横幅-->
                    <div class="person-info-box">
                        <div id="top-side">
                            <div style="" class="moon-news-card moon-height-js">
                                <span class="moon-news-card-split2"></span>
                                <div class="news-hot-list">
                                    <div class="news-hot-title"><p>历史记录</p></div>
                                    <div class="news-hot-content">
                                        <ul id="historyList">

                                        </ul>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                </div>
            </div>
        </div>
        <ul class="layui-fixbar">
            <li class="immnc mmnc-dengchutuichuguanbi" lay-type="bar1" style="" onclick="loginOut('${user.getUserId()}')">

            </li>
            <li class="layui-icon layui-icon-top layui-fixbar-top" lay-type="top" style="display: none;"></li>
        </ul>
    </div>

    <!--底部-->
</div>

<script src="/layui/layui.js"></script>
<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/jquery.cookie.js"></script>
<script src="/js/moon.js"></script>
<script src="/js/personnel.js"></script>
<script>
    document.addEventListener("DOMContentLoaded", ready);
    var urlPrefix = "https://p0.cdrysj.com/po";
    function ready() {
        getNav(0)
    }
    var layer;
    layui.use('layer', function () {
        layer = layui.layer;
    })
    function loginOut(id) {
        //询问框
        layer.confirm('是否退出当前账号？', {
            btn: ['是','否'] //按钮
        }, function(){
            $.ajax({
                type: 'post',
                dataType: 'json',
                contentType: "application/x-www-form-urlencoded",
                xhrFields: {
                    withCredentials: true
                },
                crossDomain: true,
                url: 'https://news.immnc.com/api/user/logout?userId='+id,// "https://news.immnc.com/api/user/loginAndPhonePassword"
                success: function (data) {
                    $.cookie('userVO', null);
                    layer.msg(data.data.message, {icon: 1})
                    setTimeout(function () {
                        location="/"
                    },700)
                },
                error: function (data) {
                    layer.msg("网络异常")
                }
            });
        });
    }
    layui.use('element', function () {
        var $ = layui.jquery
                , element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
        element.on('tab(person-info-table)', function (data) {

        })

    });
    personnelNews1('${user.getUserId()}')
    personnelNews2('${user.getUserId()}')
    personnelNews3('${user.getUserId()}')
    attentionList('${user.getUserId()}')
    fansList('${user.getUserId()}')
    getHistory('${user.getUserId()}')


</script>
<script>

</script>
<script>

</script>
</body>
</html>
