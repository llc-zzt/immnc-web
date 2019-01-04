<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>妙漫网创-微信登录</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <link rel="stylesheet" href="/styles/moon.css">
    <link rel="stylesheet" href="/font/iconfont.css">
    <link rel="shortcut icon" href="/images/web_icon.ico"/>
</head>
<body style="width: 600px;height: 500px">
<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/layui/layui.js"></script>
<script src="/js/jquery.cookie.js"></script>
<script>
    var layer;
    layui.use('layer', function () {
        layer = layui.layer;
    })
    function GetRequest() {
        var url = location.search; //获取url中"?"符后的字串
        var theRequest = new Object();
        if (url.indexOf("?") != -1) {
            var str = url.substr(1);
            strs = str.split("&");
            for(var i = 0; i < strs.length; i ++) {
                theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
            }
        }
        return theRequest;
    }
    $(function () {
        $.ajax({
            type: 'post',
            dataType: 'json',
            xhrFields: {
                withCredentials: true
            },
            crossDomain: true,
            contentType: "application/x-www-form-urlencoded",
            url: 'https://news.immnc.com/api/user/wechat/login',// "https://news.immnc.com/api/user/loginAndPhonePassword"
            data: {
                "weChatOpenID": GetRequest().weChatOpenID
            },
            success: function (data) {
                layer.msg(data.message);
                if (data.code == 0) {
                    console.log(data.data.userVO);
                    window.close()
                }

            },
            error: function (data) {
                layer.msg("网络异常")
            }
        });

    })
</script>
</body>
</html>
