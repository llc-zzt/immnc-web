<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>BTV直播</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <link rel="stylesheet" href="/styles/DPlayer.min.css">
    <link rel="stylesheet" href="/styles/moon.css">
    <link rel="shortcut icon" href="/images/web_icon.ico"/>
    <link rel="stylesheet" href="/styles/animate.css">
    <link rel="stylesheet" href="/font/iconfont.css">
    <link rel="stylesheet" href="/styles/jquery.mCustomScrollbar.css">
    <link rel="stylesheet" href="/styles/jquery.sinaEmotion.css">
    <style>
        body {
            background-color: #f2f2f2;

        }

        .moon-live {
            min-width: 1220px;
            max-width: 1504px;
            width: 80%;
            margin-top: 80px;
            display: flex;
            flex-direction: row;
            justify-content: center;
        }

        .btn-live {
            height: 18px;
            padding: 1px 7px;
            margin-left: 2px;
            margin-right: 8px;
            font-size: 12px;
            color: #23ade5;
            border: 1px solid #23ade5;
            border-radius: 3px
        }

        .like-a {
            color: #999;
        }

        .like-a:hover {
            cursor: pointer;
            color: #23ade5;
        }

        .moon-live-l {
            display: flex;
            flex-direction: column;
            width: 906px;
            align-items: center;
            margin-right: 10px;
        }

        .moon-live-header {
            width: 906px;
            height: 96px;
            border-radius: 12px 12px 0 0;
            padding: 17px 24px 17px 17px;
            -webkit-box-sizing: border-box;
            box-sizing: border-box;
            position: relative;
            display: flex;
            flex-direction: row;
            align-items: center;
            background-color: rgba(255, 255, 255, 1);
        }

        .moon-live-header .header-user-avatar {
            width: 64px;
            height: 64px;
            position: relative;
        }

        .moon-live-header .room-title {
            font-size: 16px;
            margin-left: 10px;
            margin-right: 5px;
        }

        .header-user-avatar img {
            width: 64px;
            height: 64px;
            border-radius: 50%;
        }

        .header-room-info {
            margin-left: 17px;
            width: 782px;
            height: 60px;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: space-between;
        }

        .header-room-info .top {
            display: flex;
            flex-direction: row;
            align-items: center;
            justify-content: space-between;
            width: 100%;
        }

        .header-room-info .top .left {
            display: flex;
            align-items: center;
            flex-direction: row;
        }

        .header-room-info .top .left a {

        }

        .header-room-info .top .left .info-section {
            background-color: rgb(251, 114, 153);
            margin-left: 16px;
            min-width: 70px;
            height: 20px;
            border-radius: 30px;
            text-align: center;
            cursor: pointer;
            -webkit-transition: all 1s cubic-bezier(.22, .58, .12, .98);
            -o-transition: all 1s cubic-bezier(.22, .58, .12, .98);
            transition: all 1s cubic-bezier(.22, .58, .12, .98);
        }

        .header-room-info .top .right {
            display: flex;
            flex-direction: row;
            align-items: center;

        }

        .header-room-info .top .right .dp-i-black {
            margin-left: 16px;
            -webkit-transition: color .4s cubic-bezier(.22, .58, .12, .98);
            -o-transition: color cubic-bezier(.22, .58, .12, .98) .4s;
            transition: color .4s cubic-bezier(.22, .58, .12, .98);
            display: flex;
            flex-direction: row;
            align-items: center;
        }

        .header-room-info .bottom {
            display: flex;
            flex-direction: row;
            align-items: center;
            justify-content: space-between;
            width: 100%;
            font-size: 12px;
        }

        .header-room-info .bottom .left {
            display: flex;
            align-items: center;
            flex-direction: row;
        }

        .header-room-info .bottom .right {
            display: flex;
            align-items: center;
            flex-direction: row;
        }

        .btn-live.room-gender {
            height: 16px;
            color: rgb(251, 114, 153);
            border: 1px solid rgb(251, 114, 153);
        }

        .live-content {
            width: 906px;
            height: 510px;
            background-color: #000000;
        }

        .live-content-player {
            height: 510px;
            max-width: 906px;
        }

        .live-content-player #dplayer {
            height: 510px;
            width: auto;
        }

        .moon-live-foot {
            width: 906px;
            padding: 17px 24px 17px 17px;
            -webkit-box-sizing: border-box;
            box-sizing: border-box;
            position: relative;
            display: flex;
            flex-direction: row;
            align-items: center;
            background-color: rgba(255, 255, 255, 1);
            height: 124px;
            border-radius: 0 0 12px 12px;
        }

        .moon-live-r {
            width: 302px;
            height: 730px;
            top: 0;
            right: 0;
            bottom: 0;
            background-color: #f8f8f8;
            border: 1px solid #e9eaec;
            border-radius: 12px;
            position: relative;
        }

        .moon-live-r-top {
            border-radius: 12px 12px 0 0;
            height: 20%;
            transition: all .2s;
            background-color: rgba(255, 255, 255, 1);
            border-bottom: 1px #cecece solid;
        }

        .live-msg-header {
            height: 20%;
            width: 100%;
            position: absolute;
            top: 0;
            left: 0;

        }

        /*节目列表*/
        .live-program-box {
            display: flex;
            flex-direction: column;
            width: 906px;
            height: auto;
            margin: 10px 0;
        }

        .live-program-box .live-program-title {
            font-size: 16px;
        }

        .live-program-box .live-program-list {
            display: flex;
            width: 100%;
            height: auto;
            flex-direction: row;
            flex-wrap: wrap;
            align-items: center;
            background-color: rgba(255, 255, 255, 1);
            border-radius: 12px;

        }

        .live-program-list .live-program-item {
            padding: 5px 5px;
            height: 20px;
            font-size: 14px;
        }

        .msg-content-box {
            position: absolute;
            width: 100%;
            height: 60%;
            top: 20%;
            left: 0px;
        }

        .msg-controller-box {
            position: absolute;
            width: 100%;
            height: 20%;
            top: 80%;
            left: 0px;
            display: flex;
            flex-direction: column;
        }

        .input-area textarea {
            height: 56px;
            width: 100%;
            resize: none;
            outline: none;
            border: 1px solid #e9eaec;
            background-color: #fff;
            border-radius: 4px;
            overflow: hidden;
            font-size: 12px;
            line-height: 19px;
            padding: 8px 8px 10px;
        }

        .msg-controller-box .input-area {
            height: auto;
            padding: 8px 8px 10px;
        }

        .msg-send {

            display: flex;
            width: 100%;
            justify-content: space-between;
            padding: 6px 0;
            align-items: center
        }

        .msg-send > i {
            font-size: 24px;
            color: #959595;
            cursor: pointer;
        }

        .send-button {
            font-size: 12px;
            color: #ffffff;
            background-color: #23ade5;
            display: inline-block;
            height: 25px;
            line-height: 25px;
            padding: 0 18px;
            white-space: nowrap;
            text-align: center;
            font-size: 12px;
            border: none;
            border-radius: 2px;
            cursor: pointer;
        }

        .msg-history-list {

        }

        .msg-history-list ul {
            display: flex;
            flex-direction: column;

        }

        .msg-item {
            position: relative;
            color: #646c7a;
            line-height: 20px;
            word-wrap: break-word;
            white-space: normal;
            padding: 0 2px 10px 2px;
        }
        .danmaku-user-name{
            color: #23ade5
        }
        .user-level{
            width: 40px;
            height: 16px;
            border-radius: 2px;
            border: 1px solid;
            display: inline-block;
            -webkit-box-sizing: border-box;
            box-sizing: border-box;
            line-height: 14px;
            text-align: center;
            vertical-align: middle;
            font-style: normal;
            font-size: 12px;
            font-weight: 400;
        }
        .danmaku-content{
            word-wrap:break-word;
            word-break:break-all;
            overflow: hidden;
        }
    </style>
</head>
<body>

<div class="moon-news-body">
    <!--导航-->
    <#include "../common/navigation.ftl">
    <!--内容-->
    <div class="moon-live" style="margin-top: 92px">
        <!--carousel-->
        <!--新闻内容-->
        <div class="moon-live-l">
            <div class="moon-live-header">
                <div class="header-user-avatar">
                    <img src="/images/logo-video.png" alt="">
                </div>
                <div class="header-room-info">
                    <div class="top">
                        <div class="left">
                            <span class="btn-live">直播</span>
                            <span style="margin-right: 5px" class="room-title">看电视📺</span>
                            <a class="like-a">娱乐&nbsp;·&nbsp;</a>
                            <a class="like-a">视频聊天</a>
                            <div class="info-section"></div>
                        </div>
                        <div class="right">
                            <div class="dp-i-black">
                                <i class="layui-icon layui-icon-rate-solid like-a"></i>
                                <span class="like-a">999</span>
                            </div>
                            <div class="dp-i-black like-a">
                                <i class="layui-icon layui-icon-rate-solid like-a"></i>
                                <span class="like-a">999</span>
                            </div>

                        </div>
                    </div>
                    <div class="bottom">
                        <div class="left">
                            <span class="btn-live room-gender">UP 96</span>
                            <span style="margin-right: 5px" class="room-username like-a">BTV</span>
                            <a class="like-a">娱乐&nbsp;·&nbsp;</a>
                            <a class="like-a">视频聊天</a>
                            <div class="info-section"></div>
                        </div>
                        <div class="right">
                            <div class="dp-i-black">
                                <i class="layui-icon layui-icon-rate-solid like-a"></i>
                                <span class="like-a">999</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="live-content">
                <div class="live-content-player">
                    <div id="dplayer"></div>
                </div>

            </div>
            <div class="moon-live-foot">

            </div>
            <div class="live-program-box">
                <div class="live-program-title">节目列表</div>
                <ul class="live-program-list">
                    <li class="live-program-item"><a href="/live/cctv1hd.html" target="_self">CCTV-1高清</a></li>
                    <li class="live-program-item"><a href="/live/cctv3hd.html" target="_self">CCTV-3高清</a></li>
                    <li class="live-program-item"><a href="/live/cctv5hd.html" target="_self">CCTV-5高清</a></li>
                    <li class="live-program-item"><a href="/live/cctv6hd.html" target="_self">CCTV-8高清</a></li>
                    <li class="live-program-item"><a href="/live/chchd.html" target="_self">CHC高清电影高清</a></li>
                    <li class="live-program-item"><a href="/live/btv1hd.html" target="_self">北京卫视高清</a></li>
                    <li class="live-program-item"><a href="/live/btv2hd.html" target="_self">北京文艺高清</a></li>
                    <li class="live-program-item"><a href="/live/btv6hd.html" target="_self">北京体育高清</a></li>
                    <li class="live-program-item"><a href="/live/btv11hd.html" target="_self">北京纪实高清</a></li>
                    <li class="live-program-item"><a href="/live/hunanhd.html" target="_self">湖南卫视高清</a></li>
                    <li class="live-program-item"><a href="/live/zjhd.html" target="_self">浙江卫视高清</a></li>
                    <li class="live-program-item"><a href="/live/jshd.html" target="_self">江苏卫视高清</a></li>
                    <li class="live-program-item"><a href="/live/dfhd.html" target="_self">东方卫视高清</a></li>
                    <li class="live-program-item"><a href="/live/cctv1.html" target="_self">CCTV-1综合</a></li>
                    <li class="live-program-item"><a href="/live/cctv2.html" target="_self">CCTV-2财经</a></li>
                    <li class="live-program-item"><a href="/live/cctv3.html" target="_self">CCTV-3综艺</a></li>
                    <li class="live-program-item"><a href="/live/cctv4.html" target="_self">CCTV-4中文国际</a></li>
                    <li class="live-program-item"><a href="/live/cctv6.html" target="_self">CCTV-6电影</a></li>
                    <li class="live-program-item"><a href="/live/cctv7.html" target="_self">CCTV-7军事农业</a></li>
                    <li class="live-program-item"><a href="/live/cctv8.html" target="_self">CCTV-8电视剧</a></li>
                    <li class="live-program-item"><a href="/live/cctv9.html" target="_self">CCTV-9纪录</a></li>
                    <li class="live-program-item"><a href="/live/cctv10.html" target="_self">CCTV-10科教</a></li>
                    <li class="live-program-item"><a href="/live/cctv11.html" target="_self">CCTV-11戏曲</a></li>
                    <li class="live-program-item"><a href="/live/cctv12.html" target="_self">CCTV-12社会与法</a></li>
                    <li class="live-program-item"><a href="/live/cctv13.html" target="_self">CCTV-13新闻</a></li>
                    <li class="live-program-item"><a href="/live/cctv14.html" target="_self">CCTV-14少儿</a></li>
                    <li class="live-program-item"><a href="/live/cctv15.html" target="_self">CCTV-15音乐</a></li>
                </ul>
            </div>
        </div>
        <div class="moon-live-r">
            <div class="moon-live-r-top">

                <div class="layui-tab layui-tab-brief live-msg-header" lay-filter="docDemoTabBrief">
                    <ul class="layui-tab-title">
                        <li class="layui-this">日榜</li>
                        <li>周榜</li>
                        <li>月榜</li>
                    </ul>
                    <div class="layui-tab-content">
                        <div class="layui-tab-item layui-show">
                            暂无数据
                        </div>
                        <div class="layui-tab-item">暂无数据</div>
                        <div class="layui-tab-item">暂无数据</div>
                    </div>

                </div>
                <!--弹幕区域-->
                <div class="msg-content-box" id="history-msg">
                    <div class="msg-history-list">
                        <ul id="danmaku-list">

                        </ul>
                    </div>

                </div>
                <!--输入框-->
                <div class="msg-controller-box">
                    <div class="input-area">
                        <textarea class="layui-textarea" name="" id="msg-input" cols="30" rows="10"></textarea>
                        <div class="msg-send">
                            <i class="immnc mmnc-xiaolianmanyifuwu face"></i>
                            <button class=" send-button" onclick="send()">发送</button>
                        </div>
                    </div>

                </div>

            </div>
            <ul class="layui-fixbar">
                <!--<li class="layui-icon" lay-type="bar1" style=""></li>-->
                <li class="layui-icon layui-icon-top layui-fixbar-top" lay-type="top" style="display: none;"></li>
            </ul>
        </div>
        <ul class="layui-fixbar">
            <!--<li class="layui-icon" lay-type="bar1" style=""></li>-->
            <li class="layui-icon layui-icon-top layui-fixbar-top" lay-type="top" style="display: none;"></li>
        </ul>
    </div>
</div>

<script src="/layui/layui.js"></script>
<script src="/js/jquery-2.0.3.min.js"></script>
<script src="/js/jquery.cookie.js"></script>
<script src="/js/hls.js"></script>
<script src="/js/DPlayer.min.js"></script>
<script src="/js/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="/js/moon.js"></script>
<script src="/js/jquery.sinaEmotion.js"></script>
<script>
    var layer;
    layui.use('layer', function () {
        layer = layui.layer;
    });
    document.addEventListener("DOMContentLoaded", ready);

    function ready() {
        getNav(0)
        $("#history-msg").mCustomScrollbar({
            theme: "minimal-dark"
        });
        changeEmotion();

    }
    $('.face').SinaEmotion($('#msg-input'));
    //改变表情
    function changeEmotion() {
        var msgs = $(".danmaku-content");
        console.log(msgs)
        for (let i = 0; i < msgs.length; i++) {
            var html = $(msgs[i]).html();
            $(msgs[i]).html(AnalyticEmotion(html))
        }
    }
    function send() {
        var inputValue = $("#msg-input").val();
        if (inputValue == "") {
            layer.msg("请输入内容")
        } else {
            $("#danmaku-list").append(
                    '<li class="msg-item">\n' +
                    '                                    <span class="user-level">ul99</span>\n' +
                    '                                    <span class="danmaku-user-name">三爷:</span>\n' +
                    '                                    <span class="danmaku-content">'+inputValue+'</span>\n' +
                    '                                </li>'
            )
            changeEmotion();
            $("#history-msg").mCustomScrollbar("update");
            $("#history-msg").mCustomScrollbar("scrollTo","last");
            $("#msg-input").val("");
        }
    }

</script>
<script>
    // var player = videojs('my-player',{
    //     width: 914,
    //     height: 514,
    //     autoplay: true
    // });
    const dp = new DPlayer({
        container: document.getElementById('dplayer'),
        autoplay: true,
        screenshot: true,
        live: true,
        logo: "/images/logo-video-50.png",
        video: {
            url: 'http://ivi.bupt.edu.cn/hls/${room}.m3u8',
            type: 'hls'
        }
    });
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
<script>
    layui.use('element', function () {
        var element = layui.element;

        //获取hash来切换选项卡，假设当前地址的hash为lay-id对应的值
        var layid = location.hash.replace(/^#test1=/, '');
        element.tabChange('test1', layid); //假设当前地址为：http://a.com#test1=222，那么选项卡会自动切换到“发送消息”这一项

        //监听Tab切换，以改变地址hash值
        element.on('tab(test1)', function () {
            location.hash = 'test1=' + this.getAttribute('lay-id');
        });
    });
</script>
</body>
</html>
