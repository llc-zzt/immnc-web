<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>妙漫网创登录-手机验证码登录注册</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <link rel="stylesheet" href="/styles/moon.css">
    <link rel="stylesheet" href="/font/iconfont.css">
    <link rel="shortcut icon" href="/images/web_icon.ico"/>
    <style>
        body {
            background-color: #f2f2f2
        }

        .moon-login-content {
            display: flex;
            justify-content: center;
            align-items: center;
            width: 100%;
            height: 688px;
            opacity: 1;
            background: rgba(249, 249, 249, 1);
        }

        .moon-login-card {
            width: 344px;
            height: 498px;
            opacity: 1;
            background: rgba(255, 255, 255, 1);
            border-radius: 1px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .moon-login-log {
            width: 200px;
            height: 79px;
            opacity: 1;
            margin: 24px auto;
        }

        .login-input-group {
            height: 152px;
            width: 100%;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }

        .login-input-group input {
            margin-top: 7px;
            background: 0 0;
            border: none;
            outline: 0;
            box-shadow: none;
            padding: 0 18px;
            font-size: 14px;
            width: 244px;
            height: 36px;
            border-radius: 18px;
            opacity: 1;
            background: rgba(240, 240, 240, 1);
            font-weight: 400;
            color: rgba(102, 102, 102, 1);
            line-height: 36px;
        }

        .login-input-button {
            margin-top: 36px;
            width: 280px;
            height: 36px;
            opacity: 1;
            background: rgba(29, 186, 236, 1);
            font-weight: 400;
            color: rgba(255, 255, 255, 1);
            line-height: 36px;
            border-radius: 18px;
            letter-spacing: 0px;
        }

        .login-other-split {
            width: 280px;
            height: 10px;
            margin-top: 20px;
            display: flex;
            align-items: center;
            flex-direction: row;
            justify-content: space-between;
        }

        .login-other-split > span {
            width: 100px;
            height: 1px;
            opacity: 1;
            background: rgba(204, 204, 204, 1);
        }

        .login-other-split > p {
            width: 60px;
            height: 10px;
            opacity: 1;
            font-size: 8px;
            font-weight: 400;
            color: rgba(204, 204, 204, 1);
            line-height: 10px;
            letter-spacing: 0px;
        }

        .login-other-group {
            width: 280px;
            height: 48px;
            opacity: 1;
            margin-top: 20px;
            display: flex;
            flex-direction: row;
            justify-content: space-around;
            align-items: center;
        }

        .login-other-group-items {
            width: 48px;
            height: 48px;
            opacity: 1;
            border-radius: 50%;
            cursor: pointer;
            display: flex;
            flex-direction: row;
            align-items: center;
            justify-content: center;
        }

        .login-phone-code {
            position: relative;
        }

        .login-phone-code > button {
            position: absolute;
            right: 10px;
            top: 14px;
            background: rgba(29, 186, 236, 1);
        }
    </style>
</head>
<body>

<div class="moon-news-body">
    <!--导航-->
    <!--内容-->
    <div class="moon-login-content">
        <!--login form-->
        <div class="moon-login-card moon-z-depth-3">
            <a href="/"><img class="moon-login-log" src="/images/logo-home.png"></a>
            <div class="login-input-group">
                <div class="login-phone-code">
                    <input type="text" id="phone" placeholder="您的手机号码">
                    <button id="send-code" class="layui-btn layui-btn-xs">发送验证码</button>
                </div>
                <input id="code" type="text" placeholder="输入你的验证码">
            </div>
            <button class="layui-btn login-input-button" disabled="disabled"  onclick="login()">登录/注册</button>
            <div class="login-other-split">
                <span></span>
                <p>第三方登录</p><span></span>
            </div>
            <ul class="login-other-group">
                <li class="login-other-group-items">
                    <a onclick="jzz()">
                        <img src="/images/qq-login.png" alt="QQ登陆">
                    </a>

                </li>
                <li class="login-other-group-items">
                    <a onclick="jzz()">
                        <img src="/images/wechat-login.png" alt="微信登陆">
                    </a>

                </li>
                <li class="login-other-group-items">
                    <a href="/login.html">
                        <img width="36px" src="/images/passwordLogin.png" alt="账号登录">
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <div class="moon-login-foot">
        <p>Copyright © 2018-2020 技术支持: 成都月步科技有限公司 蜀ICP备18018817号-1 </p>
        <p>违法和不良信息举报：028-962377</p>
    </div>

</div>

<script src="/layui/layui.js"></script>
<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/jquery.cookie.js"></script>

<script src="/js/moon.js"></script>
<script src="/js/moon-register.js"></script>
<script type="text/javascript">

</script>
</body>
</html>
