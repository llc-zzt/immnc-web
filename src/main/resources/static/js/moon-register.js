var countdown = 60;

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

$(function () {
    $("#send-code").click(function () {
        sendCode()

    })
})
var layer;
layui.use('layer', function () {
    layer = layui.layer;

});
var phone;
var contentType = "application/x-www-form-urlencoded"

function sendCode() {
    phone = $("#phone").val();
    if (phone != "" && phone != null) {
        if (!(/^1[3456789]\d{9}$/.test(phone))) {
            layer.msg("请输入正确的手机号！", {
                time: 1000
            });
        } else {

            $("#send-code").attr("disabled", "disabled")
            $("#send-code").css({"background-color": "#FBFBFB"})
            settime()
            //发验证码
            $.ajax({
                type: 'post',
                dataType: 'json',
                contentType: contentType,
                xhrFields: {
                    withCredentials: true
                },
                crossDomain: true,
                url: 'http://localhost:8888/api/user/checkPhoneToCode',// "https://news.immnc.com/api/user/checkPhoneToCode"
                data: {
                    "phone": phone,
                    "type": 0
                },
                success: function (data) {
                    if (data.code ==0){
                        layer.msg("验证码发送成功");
                        $(".login-input-button").removeAttr("disabled")
                    }else {
                        layer.msg("验证码发送失败，请稍后重试");
                    }


                },
                error: function (data) {
                    layer.msg('网络错误');
                }
            });
        }
    } else {
        layer.msg('请输入手机号码');
    }
}

document.onkeydown = function (event) {
    var e = event || window.event;
    if (e && e.keyCode == 13) { //回车键的键值为13
        login(); //调用登录按钮的登录事件
    }
};

function login() {
    phone = $("#phone").val();
    var code = $("#code").val();
    if (code != "" && code != null) {
        //登录
        $.ajax({
            type: 'post',
            dataType: 'json',
            contentType: contentType,
            xhrFields: {
                withCredentials: true
            },
            crossDomain: true,
            url: 'http://localhost:8888/api/user/loginByPhoneAndCode',// "https://news.immnc.com/api/user/loginByPhoneAndCode"
            data: {
                "phone": phone,
                "code": code
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
                layer.msg("网络错误...");
            }
        });
    } else {
        layer.msg('请输入验证码');
    }
}
function jzz() {
    layer.msg("加载...")
}
$(function () {
    var height = window.innerHeight - 80
    $(".moon-login-content").css({'height': height})
})
