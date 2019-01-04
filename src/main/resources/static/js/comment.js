var userId;
var articleId;
var commentId = 0;
var layer;
var login_flag = false;
window.onload = changeEmotion
layui.use('layer', function () {
    layer = layui.layer;
});

//改变表情
function changeEmotion() {
    var msgs = $(".cmt-msg");
    for (let i = 0; i < msgs.length; i++) {
        var html = $(msgs[i]).html();
        $(msgs[i]).html(AnalyticEmotion(html))
    }
}

function send() {
    var cmt = $('.comment-textarea').val()
    var aid = $('.comment-textarea').attr("id")

    //判断是否登录+为空
    if (!login_flag) {
        valid()
        login_flag = true;
    }
    var userVO = JSON.parse($.cookie('userVO'));
    console.log(userVO)
    var myDate = new Date();
    if (cmt != null && cmt != "") {
        if (commentId == 0) {
            //    发送评论 /api/article/comment/save
            $.ajax({
                type: 'post',
                dataType: 'json',
                xhrFields: {
                    withCredentials: true
                },
                crossDomain: true,
                contentType: 'application/x-www-form-urlencoded',
                url: 'https://news.immnc.com/api/article/comment/save',// "https://news.immnc.com/api/user/loginAndPhonePassword"
                data: {
                    "aid": aid,
                    "commentInfo": cmt,
                    "nickName": userVO.nikeName,
                    "avatar": userVO.avatar
                },
                success: function (data) {
                    if (data.code ==3){
                        layer.msg("用户失效，请重新登录")
                        setTimeout(function () {
                            location = "/login.html"
                        },1000)
                    }
                    if (data.code ==100){
                        layer.msg("妙漫网创打造文明社区,请绿色评论。")
                    }
                    if (data.code == 0) {
                        layer.msg("评论成功")
                        var comment = data.data.comment;

                        $(".cy-cmt-list").prepend(
                            ' <li class="cmt-item">\n' +
                            '                                    <a href="" class="avatar-wrap">\n' +
                            '                                        <img src="'+userVO.avatar+'" alt="">\n' +
                            '                                    </a>\n' +
                            '                                    <div class="cmt-content">\n' +
                            '                                        <div class="cmt-user-info">\n' +
                            '                                            <div>\n' +
                            '                                                <a href="" target="_blank" class="cmt-user-name">'+userVO.nikeName+':</a>\n' +
                            '                                                <span class="cmt-user-ip"></span>\n' +
                            '                                            </div>\n' +
                            '                                            <span class="cmt-create-time">'+myDate.toLocaleString()+'</span>\n' +
                            '                                        </div>\n' +
                            '                                        <p class="cmt-msg">' + AnalyticEmotion(cmt) + '</p>\n' +
                            '                                        <div class="cmt-footer-action">\n' +
                            '                                            <div class="action-left">\n' +
                            '                                                <a id="'+comment.id+'" class="cmt-reply click_reply_comment">回复</a>\n' +
                            '                                            </div>\n' +
                            '                                            <div class="action-right">\n' +
                            '\n' +
                            '                                                <span title="点赞" class="bui-right c-digg"></span>\n' +
                            '                                                <i class="layui-icon layui-icon-praise biu-i"></i>\n' +
                            '                                                <i class="immnc mmnc-tupianjiazaishibai01 biu-i"\n' +
                            '                                                   style="margin-left: 5px"></i>\n' +
                            '                                            </div>\n' +
                            '                                        </div>\n' +
                                '                        <!--回复-->\n' +
                            '                        <div class="c-reply-comment-box hide">\n' +
                            '                        </div>\n' +
                            '\n' +
                            '                                    </div>\n' +
                            '                                </li>'
                        )
                        $('.comment-textarea').val("")
                    }
                },
                error: function (data) {
                    layer.msg("网络异常")
                }
            });

        } else {
            console.log(commentId)
            $("#" + commentId).parent().parent().next().css({"display": "block"})
            $("#" + commentId).parent().parent().next().addClass("show")
            $("#" + commentId).parent().parent().next().removeClass("hide")
            $("#" + commentId).parent().children('.c-reply-down').css({"display": "none"})
            $("#" + commentId).parent().children('.c-reply-up').css({"display": "inline-block"})
            var countString = $("#" + commentId).next().children('.c-reply-count').html();
            var count;
            if (countString == null || countString == "") {
                count = 0
            } else {
                count = parseInt(countString)
            }
            $("#" + commentId).next().children('.c-reply-count').html(count + 1)
            $("#" + commentId).parent().parent().next().prepend(
                ' <div class="c-reply-comment">\n' +
                '                                                <a href="" class="avatar-wrap">\n' +
                '                                                    <img src="'+userVO.avatar+'"\n' +
                '                                                         alt="">\n' +
                '                                                </a>\n' +
                '                                                <div class="cmt-content">\n' +
                '                                                    <div class="cmt-user-info">\n' +
                '                                                        <div>\n' +
                '                                                            <a href="" target="_blank" class="cmt-user-name">'+userVO.nikeName+'</a>\n' +
                '                                                            <span class="cmt-user-ip"></span>\n' +
                '                                                        </div>\n' +
                '                                                        <span class="cmt-create-time">'+myDate.toLocaleString()+'</span>\n' +
                '                                                    </div>\n' +
                '                                                    <p class="cmt-msg">' + AnalyticEmotion(cmt) + '</p>\n' +
                '                                                    <div class="cmt-footer-action">\n' +
                '                                                        <div class="action-left">\n' +
                '                                                            <a id="10" class="cmt-reply click_reply_comment">回复</a>\n'+
                '                                                        </div>\n' +
                '                                                        <div class="action-right">\n' +
                '\n' +
                '                                                            <span title="点赞" class="bui-right c-digg"></span>\n' +
                '                                                            <i class="layui-icon layui-icon-praise biu-i active"></i>\n' +
                '                                                            <i class="immnc mmnc-tupianjiazaishibai01 biu-i"\n' +
                '                                                               style="margin-left: 5px"></i>\n' +
                '                                                        </div>\n' +
                '                                                    </div>\n' +
                '                                                </div>\n' +
                '                                            </div>'
            )
        //    发送回复
        }

        var cy_number = $('.cy-number');
        for (let i = 0; i < cy_number.length; i++) {
            var cy_number_text = $(cy_number[i]).html();
            if (cy_number_text == "") {
                $(cy_number[i]).html("1")
            } else {
                $(cy_number[i]).html(parseInt(cy_number_text) + 1)
            }
        }
    } else {
        layer.msg('说点什么吧.');
    }


}

$(".cy-cmt-list").on("click", '.click_reply_comment', function () {

    $('.comment-textarea').focus()
    commentId = $(this).attr('id')
    console.log(commentId)
})
$(".cy-cmt-list").on("click", '.click_expand_reply', function () {
    if ($(this).parent().parent().next().hasClass("hide")) {
        $(this).parent().parent().next().css({"display": "block"})
        $(this).parent().parent().next().addClass("show")
        $(this).parent().parent().next().removeClass("hide")
        $(this).parent().children('.c-reply-down').css({"display": "none"})
        $(this).parent().children('.c-reply-up').css({"display": "inline-block"})
    } else {
        $(this).parent().parent().next().css({"display": "none"})
        $(this).parent().parent().next().addClass("hide")
        $(this).parent().parent().next().removeClass("show")
        $(this).parent().children('.c-reply-down').css({"display": "inline-block"})
        $(this).parent().children('.c-reply-up').css({"display": "none"})
    }
})

$(".cy-cmt-list").on("click", '.layui-icon-praise', function () {
    var numString = $(this).parent().children(".c-digg").html()
    var num;
    if (numString == null || numString == "") {
        num = 0
    } else {
        num = parseInt(numString)
    }
    console.log($(this).parent().children(".c-digg").html())
    if ($(this).hasClass("active")) {
        $(this).removeClass("active")
        if ((num - 1) == 0) {
            $(this).parent().children(".c-digg").html("")
        } else {
            $(this).parent().children(".c-digg").html(num - 1)
        }


    } else {
        $(this).addClass("active")
        $(this).parent().children(".c-digg").html(num + 1)
    }

})


$('.cmt-i-r.reply-list').click(function () {
    $(this).rotate(45)
})
$(function () {
    $('.face').SinaEmotion($('.comment-textarea'));

})

function chage_msgs() {
    var msgs = $(".cmt-msg");
    for (let i = 0; i < msgs.length; i++) {
        var html = $(msgs[i]).html();
        $(msgs[i]).html(AnalyticEmotion(html))
    }
}

function postDetailFirstComment(aid) {
    $.post(
        '/moon/comment/first',
        {
            "aid": aid
        },
        function (res) {
            layui.each(res.data.records, function (index, item) {
                var relay = '<a class=" c-reply-down click_expand_reply">&nbsp;⋅&nbsp;<span\n' +
                    '                                                        class="c-reply-count">4</span>条回复&nbsp;<i\n' +
                    '                                                        class="layui-icon  layui-icon-down cmt-i-r reply-list"></i></a>\n' +
                    '                                                <a class=" c-reply-up click_expand_reply">&nbsp;⋅&nbsp;收起回复&nbsp;<i\n' +
                    '                                                        class="layui-icon layui-icon-up cmt-i-r reply-list"></i></a>'
                $(".cy-cmt-list").append(
                    '<li class="cmt-item">\n' +
                    '                    <a href="" class="avatar-wrap">\n' +
                    '                        <img src="' + item.avatar + '" alt="">\n' +
                    '                    </a>\n' +
                    '                    <div class="cmt-content">\n' +
                    '                        <div class="cmt-user-info">\n' +
                    '                            <div>\n' +
                    '                                <a href="" target="_blank" class="cmt-user-name">' + item.nickName + '</a>\n' +
                    '                                <span class="cmt-user-ip"></span>\n' +
                    '                            </div>\n' +
                    '                            <span class="cmt-create-time">' + item.time + '</span>\n' +
                    '                        </div>\n' +
                    '                        <p class="cmt-msg">' + item.commentInfo + '</p>\n' +
                    '                        <div class="cmt-footer-action">\n' +
                    '                            <div class="action-left">\n' +
                    '                                <a id="' + item.id + '" class="cmt-reply click_reply_comment">回复</a>\n' +
                    '                            </div>\n' +
                    '                            <div class="action-right">\n' +
                    '                                <span title="点赞" class="bui-right c-digg">' + item.praiseNum + '</span>\n' +
                    '                                <i class="layui-icon layui-icon-praise biu-i "></i>\n' +
                    '                                <i class="immnc mmnc-tupianjiazaishibai01 biu-i"\n' +
                    '                                   style="margin-left: 5px"></i>\n' +
                    '                            </div>\n' +
                    '                        </div>\n' +
                    '                        <!--回复-->\n' +
                    '                        <div class="c-reply-comment-box hide">\n' +
                    '                        </div>\n' +
                    '\n' +
                    '                    </div>\n' +
                    '                </li>'
                )
            })
            chage_msgs()
        }
    );
}

function postDetailAllComment(aid) {
    $.post(
        '/moon/comment/all',
        {
            "aid": aid
        },
        function (res) {
            if (res.code == 0) {
                $(".cmt-load-all-more").css({"display": "block"})
                $(".cmt-load-more-loop").addClass("hide")
                layui.each(res.data, function (index, item) {
                    var relay = '<a class=" c-reply-down click_expand_reply">&nbsp;⋅&nbsp;<span\n' +
                        '                                                        class="c-reply-count">4</span>条回复&nbsp;<i\n' +
                        '                                                        class="layui-icon  layui-icon-down cmt-i-r reply-list"></i></a>\n' +
                        '                                                <a class=" c-reply-up click_expand_reply">&nbsp;⋅&nbsp;收起回复&nbsp;<i\n' +
                        '                                                        class="layui-icon layui-icon-up cmt-i-r reply-list"></i></a>'
                    $(".cy-cmt-list").append(
                        '<li class="cmt-item">\n' +
                        '                    <a href="" class="avatar-wrap">\n' +
                        '                        <img src="' + item.avatar + '" alt="">\n' +
                        '                    </a>\n' +
                        '                    <div class="cmt-content">\n' +
                        '                        <div class="cmt-user-info">\n' +
                        '                            <div>\n' +
                        '                                <a href="" target="_blank" class="cmt-user-name">' + item.nickName + '</a>\n' +
                        '                                <span class="cmt-user-ip"></span>\n' +
                        '                            </div>\n' +
                        '                            <span class="cmt-create-time">' + item.time + '</span>\n' +
                        '                        </div>\n' +
                        '                        <p class="cmt-msg">' + item.commentInfo + '</p>\n' +
                        '                        <div class="cmt-footer-action">\n' +
                        '                            <div class="action-left">\n' +
                        '                                <a id="' + item.id + '" class="cmt-reply click_reply_comment">回复</a>\n' +
                        '                            </div>\n' +
                        '                            <div class="action-right">\n' +
                        '                                <span title="点赞" class="bui-right c-digg">' + item.praiseNum + '</span>\n' +
                        '                                <i class="layui-icon layui-icon-praise biu-i "></i>\n' +
                        '                                <i class="immnc mmnc-tupianjiazaishibai01 biu-i"\n' +
                        '                                   style="margin-left: 5px"></i>\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +
                        '                        <!--回复-->\n' +
                        '                        <div class="c-reply-comment-box hide">\n' +
                        '                        </div>\n' +
                        '\n' +
                        '                    </div>\n' +
                        '                </li>'
                    )
                })
                chage_msgs()
            }

        }
    );
}

function appDownload() {

    var left_width = (window.innerWidth - 600) / 2;
    //https://news.immnc.com/api/user/qrAuthorize?returnUrl=http://localhost:8080/login/wx
    window.open("https://www.immnc.com/app/download.html", "_blank", "directories=no, status=no,left=" + left_width + ",top=150 resizable=no, copyhistory=yes, width=600, height=500")

}