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
        if (p>getHeight()) {
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
        if (p>getHeight()){
            $("#top-side").addClass("moon-side-nav-show")
        }
        if (getHeight()>p) {
            $("#top-side").removeClass("moon-side-flexd")
        }

    }
    setTimeout(function () {
        t = p;
    }, 0);
});
function getHeight(){
    var height =0
    $(".moon-height-js").each(function (index,obj) {

        height = height + $(obj).height()+10
    })
    return height+144;
}
$(function () {
    $('.layui-fixbar-top').click(function () {
        $('html,body').animate({scrollTop: (0)}, 500);
    })
    $('.moon-nav-classify ul li').click(function () {

        $(".moon-nav-classify ul li span").removeClass("active");
        $('span', this).addClass("active");
    })
    $(".moon-nav-search-input input").blur(function () {
        var value = $(this).val();

        if (value == null || value == "") {
            $(this).animate({
                width: '0'
            }, 200)
        }
    })
});
