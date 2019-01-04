var qq_open;
function qqLogin() {
    var left_width = (window.innerWidth - 600) / 2;
    //https://news.immnc.com/api/user/qrAuthorize?returnUrl=http://localhost:8080/login/wx
    qq_open = window.open("https://news.immnc.com/oauth/qq/redirect", "_blank", "directories=no, status=no,left=" + left_width + ",top=150 resizable=no, copyhistory=yes, width=600, height=500")
}
var qq_loop = setInterval(function() {
    if (qq_open!=null){
        if(qq_open.closed) {
            qq_valid()
            clearInterval(qq_loop);
        }
    }
}, 500);
function qq_valid() {
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