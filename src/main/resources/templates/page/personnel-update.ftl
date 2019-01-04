<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>资料修改</title>
    <link rel="stylesheet" href="/styles/moon.css">
    <link rel="stylesheet" href="/font/iconfont.css">
    <link rel="stylesheet" href="/styles/animate.css">
    <link rel="stylesheet" href="/styles/personnel-info.css">
    <link href="/plugins/update/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/layui/css/layui.css">
    <link href="/plugins/update/cropper/cropper.min.css" rel="stylesheet">
    <link href="/plugins/update/sitelogo/sitelogo.css" rel="stylesheet">
    <link rel="shortcut icon" href="/images/web_icon.ico"/>


    <style>
        body {
            background-color: #f2f2f2
        }

        .person-update-avatar {
            position: relative;
            display: flex;
            justify-content: center;
            height: 90px;
            width: 100%;
        }

        .person-update-avatar .person-avatar {
            width: 120px;
            height: 120px;
            border-radius: 2px;
            position: absolute;
            top: -50px;
        }

        .update-person-phone-box {
            width: 410px;
            padding: 10px;
        }

        .update-person-password-box {
            width: 410px;
            padding: 10px;
        }

        .input-line-button {
            loat: left;
            display: block;
            /* padding: 4px 0; */
            padding: 4px 0 !important;
            line-height: 20px;
            margin-right: 10px;
        }
    </style>
</head>

<body>
<div class="moon-news-body">
    <!--导航-->
    <#include "../common/navigation.ftl">
    <!--内容-->

    <div class="moon-content" style="margin-bottom: 100px;margin-top: 120px">
        <!--carousel-->
        <!--新闻内容-->
        <div class="moon-person-content">
            <div class="moon-news-card moon-person-header">
                <div class="person-background ">
                    <img class="" src="https://p0.cdrysj.com/po/read/img/user/1528890123021.jpg" alt="">
                    <div class="background-hover">
                        <span><i class="layui-icon layui-icon-refresh-1"></i> 更换背景 </span>
                    </div>

                </div>
                <div class="person-update-avatar" id="crop-avatar">
                    <div class="person-avatar avatar-view">
                        <img src="${user.getAvatar()!}" alt="">
                        <div class="background-hover">
                            <div class="upload-avatar">
                                <span><i class="layui-icon layui-icon-camera"></i> 修改头像 </span>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
            <div class="moon-news-card update-person-info-box">
                <form class="layui-form" action="" lay-verify="userInfo_form">
                    <div class="layui-form-item">
                        <label class="layui-form-label">昵称</label>
                        <div class="layui-input-block">
                            <input type="text" name="nikeName" value="${user.getNikeName()!}" required lay-verify="required" placeholder="请输入标题"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">邮箱</label>
                        <div class="layui-input-block">
                            <input type="text" name="email" required lay-verify="email" value="${user.getEmail()!}" placeholder="请输入邮箱"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">性别</label>
                        <div class="layui-input-block">
                            <input type="radio" name="sex" value="男" title="男" lay-verify="sex" <#if user.getSex()==1>checked</#if>>
                            <input type="radio" name="sex" value="女" title="女" lay-verify="sex" <#if user.getSex()==0>checked</#if>>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">生日</label>
                        <div class="layui-input-block">
                            <input type="text" name="birthday" id="time" value="${user.getBirthday()!}" lay-verify="date"
                                   placeholder="请选择时间"
                                   class="layui-input">
                        </div>
                    </div>

                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label">个性签名</label>
                        <div class="layui-input-block">
                            <textarea name="signature" lay-verify="desc" placeholder="请输入内容" class="layui-textarea">${user.getSignature()!}</textarea>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">QQ绑定</label>
                        <div class="layui-input-block">
                            <span class="layui-btn  layui-btn-primary"><i class="layui-icon layui-icon-login-qq"></i> QQ绑定</span>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">微信绑定</label>
                        <div class="layui-input-block">
                            <span class="layui-btn  layui-btn-primary "><i
                                    class="layui-icon layui-icon-login-wechat"></i>微信绑定</span>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn" lay-submit lay-filter="formUserInfo">
                                <i class="layui-icon layui-icon-ok"></i>
                                立即修改
                            </button>
                            <span class="layui-btn layui-btn-normal" onclick="updatePhone()"><i
                                    class="layui-icon layui-icon-cellphone"></i> 手机号修改
                            </span>
                            <span class="layui-btn layui-btn-normal" onclick="updatePass()"><i
                                    class="layui-icon layui-icon-auz"></i> 密码修改
                            </span>
                        </div>
                    </div>
                </form>

                <div class="update-model">
                    <div style="background-color: white" class="moon-news-card update-person-phone-box">
                        <div class="update-model-controller">
                            <i style="font-size: 20px;cursor: pointer" class="layui-icon layui-icon-close-fill "
                               onclick="closePhoneAlter()"></i>
                        </div>
                        <form class="layui-form" action="" lay-verify="user_phone_form">
                            <div class="layui-form-item">
                                <label class="layui-form-label">旧手机号码</label>
                                <div class="layui-input-block">
                                    <input type="text" name="title" required lay-verify="phone" placeholder="请输入手机号码"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">新手机号码</label>
                                <div class="layui-input-block">
                                    <input type="text" name="title" required lay-verify="phone" placeholder="请输入手机号码"
                                           class="layui-input">
                                </div>

                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">请输入验证码</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="title" required lay-verify="required" placeholder="请输入验证码"
                                           autocomplete="off" class="layui-input">
                                </div>
                                <div class="input-line-button">
                                    <button class="layui-btn layui-btn-normal layui-btn-sm">发送验证码</button>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <div class="layui-input-block">
                                    <button class="layui-btn" lay-submit lay-filter="formPhone">立即修改</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="update-model">
                    <div style="background-color: white" class="moon-news-card update-person-password-box">
                        <div class="update-model-controller">
                            <i style="font-size: 20px;cursor: pointer" class="layui-icon layui-icon-close-fill "
                               onclick="closePassAlter()"></i>
                        </div>
                        <form class="layui-form" action="" lay-verify="user_pass_form">
                            <div class="layui-form-item">
                                <label class="layui-form-label">旧密码</label>
                                <div class="layui-input-block">
                                    <input type="text" name="title" required lay-verify="password" placeholder="请输入旧密码"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">新密码</label>
                                <div class="layui-input-block">
                                    <input type="text" name="title" required lay-verify="password" placeholder="请输入新密码"
                                           class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">验证码</label>
                                <div class="layui-input-block">
                                    <input type="text" name="title" required lay-verify="required" placeholder="再次输入新密码"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <div class="layui-input-block">
                                    <button class="layui-btn" lay-submit lay-filter="formPhone">立即修改</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <ul class="layui-fixbar">
            <!--<li class="layui-icon" lay-type="bar1" style=""></li>-->
            <li class="layui-icon layui-icon-top layui-fixbar-top" lay-type="top" style="display: none;"></li>
        </ul>
    </div>

    <!--底部-->

    <div style="margin-top: 120px" class="modal fade" id="avatar-modal" aria-hidden="true" aria-labelledby="avatar-modal-label" role="dialog"
         tabindex="-1">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <form class="avatar-form" action="/moon/user/upload/avatar/${user.getUserId()}"
                      enctype="multipart/form-data" method="post">
                    <div class="modal-header">
                        <button class="close" data-dismiss="modal" type="button">&times;</button>
                        <h4 class="modal-title" id="avatar-modal-label">头像修改</h4>
                    </div>
                    <div class="modal-body">
                        <div class="avatar-body">
                            <div class="avatar-upload">
                                <input class="avatar-src" name="avatar_src" type="hidden">
                                <input class="avatar-data" name="avatar_data" type="hidden">
                                <label for="avatarInput">图片上传</label>
                                <input class="avatar-input" id="avatarInput" name="avatar_file" type="file"></div>
                            <div class="row">
                                <div class="col-md-9">
                                    <div class="avatar-wrapper"></div>
                                </div>
                                <div class="col-md-3">
                                    <div class="avatar-preview preview-lg"></div>
                                    <div class="avatar-preview preview-md"></div>
                                    <div class="avatar-preview preview-sm"></div>
                                </div>
                            </div>
                            <div class="row avatar-btns">
                                <div class="col-md-9">
                                    <div class="btn-group">
                                        <button class="btn" data-method="rotate" data-option="-90" type="button"
                                                title="Rotate -90 degrees"><i class="fa fa-undo"></i> 向左旋转
                                        </button>
                                    </div>
                                    <div class="btn-group">
                                        <button class="btn" data-method="rotate" data-option="90" type="button"
                                                title="Rotate 90 degrees"><i class="fa fa-repeat"></i> 向右旋转
                                        </button>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <button class="btn btn-success btn-block avatar-save" type="submit"><i
                                            class="fa fa-save"></i> 保存修改
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="loading" aria-label="Loading" role="img" tabindex="-1"></div>
</div>

<script src="/layui/layui.js"></script>
<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/jquery.cookie.js"></script>
<script src="/js/moon.js"></script>
<script src="/plugins/update/cropper/cropper.min.js"></script>
<script src="/plugins/update/sitelogo/sitelogo.js"></script>
<script src="/plugins/update/bootstrap/js/bootstrap.min.js"></script>
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
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        laydate.render({
            elem: '#time'
        });
    })
    layui.use('form', function () {
        var form = layui.form;

        //监听提交
        form.on('submit(formUserInfo)', function (data) {
            var index = layer.load(1, {
                shade: [0.1,'#fff'] //0.1透明度的白色背景
            })
            $.ajax({
                type: 'post',
                dataType: 'json',
                contentType: "application/x-www-form-urlencoded",
                xhrFields: {
                    withCredentials: true
                },
                crossDomain: true,
                url: 'https://news.immnc.com/api/personal/user/update',// "https://news.immnc.com/api/user/checkPhoneToCode"
                data: JSON.stringify(data.field),
                success: function (data) {
                    layer.closeAll('loading')
                    if (data.code ==0){
                        valid();
                        layer.msg("修改成功");
                    }else {
                        layer.msg("修改失败，亲刷新重试");
                    }
                    if (data.code == 402){
                        layer.msg("该手机号码未注册,正在自动跳转中...");
                        setTimeout(function () {
                            location = "/register.html"
                        },1000)
                    }
                    if (data.code == 3){
                        layer.msg(data.message);
                        setTimeout(function () {
                            location = "/login.html"
                        },1000)
                    }


                },
                error: function (data) {
                    layer.msg('网络错误');
                }
            });
            return false;
        });
    });

    function updatePhone() {
        var left_width = (window.innerWidth - 420) / 2;
        var top_height = (window.innerHeight - 500) / 2;
        console.log(left_width)
        $(".update-person-phone-box").parent().css({"display": "block"})
        $(".update-person-phone-box").css({"margin-left": left_width + "px"})
        $(".update-person-phone-box").css({"margin-top": top_height + "px"})
        $('.update-person-phone-box').removeClass('animated bounceOutUp');
        $('.update-person-phone-box').addClass('animated bounceInDown');
    }

    function updatePass() {
        var left_width = (window.innerWidth - 420) / 2;
        var top_height = (window.innerHeight - 500) / 2;
        console.log(left_width)
        $(".update-person-password-box").parent().css({"display": "block"})
        $(".update-person-password-box").css({"margin-left": left_width + "px"})
        $(".update-person-password-box").css({"margin-top": top_height + "px"})
        $('.update-person-password-box').removeClass('animated bounceOutUp');
        $('.update-person-password-box').addClass('animated bounceInDown');
    }

    function closePassAlter() {
        $('.update-person-password-box').removeClass('animated bounceInUp');
        $('.update-person-password-box').addClass('animated bounceOutUp');
        console.log($(this).parent().parent().parent())
        setTimeout(function () {
            $('.update-person-password-box').parent().css({"display": "none"});
        }, 700)
    }

    function closePhoneAlter() {
        $(".update-person-phone-box").removeClass('animated bounceInUp');
        $(".update-person-phone-box").addClass('animated bounceOutUp');
        console.log($(this).parent().parent().parent())
        setTimeout(function () {
            $('.update-person-phone-box').parent().css({"display": "none"});
        }, 700)
    }
</script>

</body>
</html>
