var layer;
layui.use('layer', function () {
    layer = layui.layer;
});
var countdown = 60;
$(function () {
    var height = window.innerHeight - 80
    $(".moon-login-content").css({'height': height})
})
function settime() {
    if (countdown == 0) {
        $("#send-code").removeAttr("disabled")
        $("#send-code").css({"background": "rgba(29, 186, 236, 1)"})
        $("#send-code").removeClass("layui-btn-disabled");
        $("#send-code").html("获取验证码");
        countdown = 60;

    } else {
        $("#send-code").addClass("layui-btn-disabled");
        $("#send-code").html("重新发送 " + countdown + "");
        countdown--;
        setTimeout(function () {
            settime()
        }, 1000)
    }
}

var contentType = "application/x-www-form-urlencoded"
function login() {
    var phone = $("#phone").val();
    var password = $("#password").val();
    if (password != "" && password != null) {
        //登录
        if (phone != "" && phone != null) {
            $.ajax({
                type: 'post',
                dataType: 'json',
                xhrFields: {
                    withCredentials: true
                },
                crossDomain: true,
                contentType: contentType,
                url: 'https://news.immnc.com/api/user/loginAndPhonePassword',// "https://news.immnc.com/api/user/loginAndPhonePassword"
                data: {
                    "phone": phone,
                    "password": password
                },
                success: function (data) {
                    layer.msg(data.message);
                    if (data.code == 0) {
                        var userVO = data.data.userVO
                        $.cookie('userVO', JSON.stringify(userVO), {expires: 7});
                        location = "/"
                    }

                },
                error: function (data) {
                    layer.msg("网络异常")
                }
            });
        }else {
            layer.msg('请输入手机号码');
        }


    } else {
        layer.msg('请输入密码');
    }
}

function valid() {
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: contentType,
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true,
        url: 'https://news.immnc.com/api/user/valid',// "https://news.immnc.com/api/user/loginAndPhonePassword"
        success: function (data) {
            layer.msg(data.message);
            if (data.code == 0) {
                var userVO = data.data.userVO
                $.cookie('userVO', JSON.stringify(userVO), {expires: 7});
            }else{
                location = "/login.html"
            }

        },
        error: function (data) {
            layer.msg("网络异常")
        }
    });
}
function jzz() {
    layer.msg("加载...")
}
