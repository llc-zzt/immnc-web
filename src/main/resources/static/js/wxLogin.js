var wx_open;
function wxLogin() {
    var left_width = (window.innerWidth - 600) / 2;
    //https://news.immnc.com/api/user/qrAuthorize?returnUrl=http://localhost:8080/login/wx
    wx_open = window.open("https://news.immnc.com/api/user/qrAuthorize?returnUrl=https://www.immnc.com/login/wx", "_blank", "directories=no, status=no,left=" + left_width + ",top=150 resizable=no, copyhistory=yes, width=600, height=500")
}
var wx_loop = setInterval(function() {
    if (wx_open!=null){
        if(wx_open.closed) {
            wx_valid()
            clearInterval(wx_loop);
        }
    }
}, 500);
function wx_valid() {
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: "application/x-www-form-urlencoded",
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true,
        url: 'https://news.immnc.com/api/user/valid',// "https://news.immnc.com/api/user/loginAndPhonePassword"
        success: function (data) {
            if (data.code == 0) {
                var userVO = data.data.userVO
                $.cookie('userVO', JSON.stringify(userVO), {expires: 7});
                layer.msg("登录成功")
                setTimeout(function () {
                    if (sessionStorage.getItem("history_login")==null) {
                        location = "/"
                    }else {
                        history.go(parseInt(sessionStorage.getItem("history_login")))
                    }
                },500)
            }else {
                layer.msg("授权失败,请重新登录.")
                setTimeout(function () {
                    location = window.location.pathname
                },1000)
            }
        },
        error: function (data) {
            layer.msg("网络异常")
        }
    });
}