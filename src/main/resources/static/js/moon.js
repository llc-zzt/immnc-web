var p = 0, t = 0;

$(window).scroll(function (e) {
    p = $(this).scrollTop();
    if (t <= p) {
        $(".moon-foot").css({'height': 0})
        if (p >= 100) {
            $('.moon-nav').css({'height': 0})
            $("#top-side").removeClass("moon-side-nav-show")

        }
        if (p >= 400) {
            $('.layui-fixbar-top').css({'display': 'list-item'})
        }
        if (p > getHeight()) {
            $("#top-side").addClass("moon-side-flexd")
        }
    }
    else {
        //上滚动
        if (p >= 100) {
            $('.moon-nav').css({'height': 80})
        }
        if (p == 0) {
            $(".moon-foot").css({'height': 40})
        }
        if (p < 400) {
            $('.layui-fixbar-top').css({'display': 'none'})
        }
        if (p > getHeight()) {
            $("#top-side").addClass("moon-side-nav-show")
        }
        if (getHeight() > p) {
            $("#top-side").removeClass("moon-side-flexd")
        }

    }
    setTimeout(function () {
        t = p;
    }, 0);
});

function getHeight() {
    var height = 0
    $(".moon-height-js").each(function (index, obj) {

        height = height + $(obj).height() + 10
    })
    return height + 744;
}

$(function () {
    $('.layui-fixbar-top').click(function () {
        $('html,body').animate({scrollTop: (0)}, 500);
    })
    $('.moon-nav-classify ul li').click(function () {

        $(".moon-nav-classify ul li span").removeClass("active");
        $('span', this).addClass("active");
    })
    // $(".moon-nav-search-right .cursor-pointer").click(function () {
    //     if ($(".moon-nav-search-input input").width() != 169)
    //         $(".moon-nav-search-input input").animate({
    //             width: '169px'
    //         }, 200)
    //     $(".moon-nav-search-input input").focus();
    // })
    // $(".moon-nav-search-input input").blur(function () {
    //     var value = $(this).val();
    //
    //     if (value == null || value == "") {
    //         $(this).animate({
    //             width: '0'
    //         }, 200)
    //     }
    // })
});
$(function () {
    var height = window.innerHeight;
    $(".moon-nav-search-right .cursor-pointer").click(function () {
        $('.moon-search-model').css({'height': height})
        $('.moon-search-model-bottom').css({'height': height / 2})
        $('.moon-search-model-top').css({'height': height / 2})
        $('.moon-search-model > i').css({'height': '26px'})
        $('.moon-search-model-bottom').removeClass('animated bounceOutDown');
        $('.moon-search-model-top').removeClass('animated bounceOutUp');
        $('.moon-search-model-top').addClass('animated bounceInDown');
        $('.moon-search-model > i').removeClass('animated bounceOutUp');
        $('.moon-search-model > i').addClass('animated bounceInDown');
        $('.moon-search-model-bottom').addClass('animated bounceInUp');
    })
    $(".moon-search-model>.model-close").click(function () {
        $('.moon-search-model-top').removeClass('animated bounceInDown');
        $('.moon-search-model-bottom').removeClass('animated bounceInUp');
        $('.moon-search-model-bottom').addClass('animated bounceOutDown');
        $('.moon-search-model-top').addClass('animated bounceOutUp');
        $('.moon-search-model > i').removeClass('animated bounceInDown');
        $('.moon-search-model > i').addClass('animated bounceOutUp');
        setTimeout(function () {
            $('.moon-search-model').css({'height': 0})
        }, 700)
    })
})
var localPrefix = ""

// all
function getNav(classify) {
    if (sessionStorage.getItem("nav") == null) {
        $.post(localPrefix + '/moon/classify/select', function (res) {
            console.log(res)
            sessionStorage.setItem("nav", JSON.stringify(res.data))
            layui.each(res.data, function (index, item) {
                var classActive = classify == item.id ? 'active' : '';
                $(".moon-nav-classify>ul").append('<li>\n' +
                    '                            <a href="/news/' + item.id + '.html">' + item.classify + '</a>\n' +
                    '                            <span class="' + classActive + '"></span>\n' +
                    '                        </li>')
            })
        })
    } else {
        layui.each(JSON.parse(sessionStorage.getItem("nav")), function (index, item) {
            var classActive = classify == item.id ? 'active' : '';
            $(".moon-nav-classify>ul").append('<li>\n' +
                '                            <a href="/news/' + item.id + '.html">' + item.classify + '</a>\n' +
                '                            <span class="' + classActive + '"></span>\n' +
                '                        </li>')

        })

    }
}
function goTo(classifyId, newsId) {
    window.open('/detail/' + classifyId + '/' + newsId + '.html')
}
$(function () {
    console.log(document.cookie)
})

