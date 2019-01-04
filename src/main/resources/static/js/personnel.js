function personnelNews1(id) {
    layui.use('flow', function () {
        var $ = layui.jquery; //不用额外加载jQuery，flow模块本身是有依赖jQuery的，直接用即可。
        var flow = layui.flow;
        flow.load({
            elem: '#personnelNews1' //指定列表容器
            , done: function (page, next) { //到达临界点（默认滚动触发），触发下一页
                var lis = [];
                //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
                $.ajax({
                    type: 'post',
                    dataType: 'json',
                    contentType: "application/x-www-form-urlencoded",
                    xhrFields: {
                        withCredentials: true
                    },
                    crossDomain: true,
                    url: 'https://news.immnc.com/api/personal/user/collected/article',// "https://news.immnc.com/api/user/checkPhoneToCode"
                    data: {
                        "page": page,
                        "typeId": 1,
                        "userId": id
                    },
                    success: function (data) {
                        if (data.code == 0) {
                            layui.each(data.data.pageContent.pageContent, function (index, item) {
                                imgPrefix = "";
                                if (item.isOwn == 1) {
                                    imgPrefix = "https://p0.cdrysj.com/po"
                                }
                                lis.push(
                                    '<li>' +
                                    '   <div class="moon-news-card">\n' +
                                    '                                                <div class="moon-card-text">\n' +
                                    '                                                    <img class="news-text-img" src="' + imgPrefix + item.img[0] + '"' +
                                    '                                                         alt="">\n' +
                                    '                                                    <div class="news-text-info">\n' +
                                    '                                                        <div class="news-title" onclick="goTo(' + item.classifyId + ',' + item.id + ')">\n' +
                                    '                                                            \n' + item.title +
                                    '                                                        </div>\n' +
                                    '                                                        <div class="news-info">\n' +
                                    '                                                            <div class="news-info-left">\n' +
                                    '\n' +
                                    '                                                                <button class="layui-btn layui-btn-xs moon-btn-primary-danger">\n' +
                                    '                                                                    ' + item.sort + '\n' +
                                    '                                                                </button>\n' +
                                    '                                                                <img src="' + item.avatar + '" alt="">\n' +
                                    '                                                                <span class="moon-breadcrumb">\n' +
                                    '                                                                  <a href="">首页</a>\n' +
                                    '                                                                    <span>/</span>\n' +
                                    '                                                                  <a href="#">' + item.username + '</a>\n' +
                                    '                                                                    <span>/</span>\n' +
                                    '                                                                  <a class="moon-this">' + item.manyTimeAgo + '</a>\n' +
                                    '                                                                </span>\n' +
                                    '                                                            </div>\n' +
                                    '                                                            <div class="news-info-right">\n' +
                                    '                                                                <i class="layui-icon layui-icon-delete cursor-pointer"></i>\n' +
                                    '                                                            </div>\n' +
                                    '                                                        </div>\n' +
                                    '                                                    </div>\n' +
                                    '                                                </div>\n' +
                                    '                                                <span class="moon-news-card-split"></span>\n' +
                                    '                                            </div>' +
                                    '</li>'
                                );
                            });

                            //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                            //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                            next(lis.join(''), page < data.data.pageContent.totalPages);
                        } else {
                            layer.msg("亲刷新重试");
                        }
                        if (data.code == 3) {
                            layer.msg(data.message);
                            setTimeout(function () {
                                location = "/login.html"
                            }, 1000)
                        }


                    },
                    error: function (data) {
                        layer.msg('网络错误');
                    }
                });

            }
        });
    });
}

function personnelNews2(id) {
    layui.use('flow', function () {
        var $ = layui.jquery; //不用额外加载jQuery，flow模块本身是有依赖jQuery的，直接用即可。
        var flow = layui.flow;
        flow.load({
            elem: '#personnelNews2' //指定列表容器
            , done: function (page, next) { //到达临界点（默认滚动触发），触发下一页
                var lis = [];
                //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
                $.ajax({
                    type: 'post',
                    dataType: 'json',
                    contentType: "application/x-www-form-urlencoded",
                    xhrFields: {
                        withCredentials: true
                    },
                    crossDomain: true,
                    url: 'https://news.immnc.com/api/personal/user/collected/article',// "https://news.immnc.com/api/user/checkPhoneToCode"
                    data: {
                        "page": page,
                        "typeId": 3,
                        "userId": id
                    },
                    success: function (data) {
                        if (data.code == 0) {
                            layui.each(data.data.pageContent.pageContent, function (index, item) {
                                imgPrefix = "";
                                if (item.isOwn == 1) {
                                    imgPrefix = "https://p0.cdrysj.com/po"
                                }
                                lis.push(
                                    '<li>\n' +
                                    '                                            <div class="moon-news-card">\n' +
                                    '                                                <div class="moon-card-video">\n' +
                                    '                                                    <div class="moon-card-video-img">\n' +
                                    '                                                        <img src="' + imgPrefix + item.img[0] + '" alt="">\n' +
                                    '                                                        <i class="layui-icon immnc mmnc-shipinbofangyingpian"></i>\n' +
                                    '                                                    </div>\n' +
                                    '                                                    <div class="moon-card-video-content">\n' +
                                    '                                                        <div class="news-video-title" onclick="goTo(' + item.classifyId + ',' + item.id + ')">' + item.title +
                                    '                                                        </div>\n' +
                                    '                                                        <div class="news-video-info">\n' +
                                    '                                                            <div class="news-info-left">\n' +
                                    '                                                                <button class="layui-btn layui-btn-xs moon-btn-primary-danger">\n' +
                                    '                                                                    ' + item.sort +
                                    '                                                                </button>\n' +
                                    '                                                                <img src="' + item.author.avatar + '" alt="">\n' +
                                    '                                                                <span class="moon-breadcrumb">\n' +
                                    '                                                              <a href="">首页</a>\n' +
                                    '                                                                <span>/</span>\n' +
                                    '                                                              <a href="#">' + item.author.name + '</a>\n' +
                                    '                                                                <span>/</span>\n' +
                                    '                                                              <a class="moon-this">' + item.manyTimeAgo + '</a>\n' +
                                    '                                                            </span>\n' +
                                    '                                                            </div>\n' +
                                    '                                                            <div class="news-info-right">\n' +
                                    '                                                                <i class="layui-icon layui-icon-delete cursor-pointer"></i>\n' +
                                    '                                                            </div>\n' +
                                    '                                                        </div>\n' +
                                    '                                                    </div>\n' +
                                    '                                                </div>\n' +
                                    '                                                <span class="moon-news-card-split"></span>\n' +
                                    '                                            </div>\n' +
                                    '                                        </li>'
                                )
                            });

                            //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                            //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                            next(lis.join(''), page < data.data.pageContent.totalPages);
                        } else {
                            layer.msg("亲刷新重试");
                        }
                        if (data.code == 3) {
                            layer.msg(data.message);
                            setTimeout(function () {
                                location = "/login.html"
                            }, 1000)
                        }


                    },
                    error: function (data) {
                        layer.msg('网络错误');
                    }
                });

            }
        });
    });
}

function personnelNews3(id) {
    layui.use('flow', function () {
        var $ = layui.jquery; //不用额外加载jQuery，flow模块本身是有依赖jQuery的，直接用即可。
        var flow = layui.flow;
        flow.load({
            elem: '#personnelNews3' //指定列表容器
            , done: function (page, next) { //到达临界点（默认滚动触发），触发下一页
                var lis = [];
                //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
                $.ajax({
                    type: 'post',
                    dataType: 'json',
                    contentType: "application/x-www-form-urlencoded",
                    xhrFields: {
                        withCredentials: true
                    },
                    crossDomain: true,
                    url: 'https://news.immnc.com/api/personal/user/collected/article',// "https://news.immnc.com/api/user/checkPhoneToCode"
                    data: {
                        "page": page,
                        "typeId": 2,
                        "userId": id
                    },
                    success: function (data) {
                        if (data.code == 0) {
                            layui.each(data.data.pageContent.pageContent, function (index, item) {
                                imgPrefix = "https://p0.cdrysj.com/po";

                                var imgsDemo = "";
                                layui.each(item.img, function (index, item) {
                                    if (index < 4)
                                        imgsDemo = imgsDemo + '<li><img src="' + imgPrefix + item + '" alt="' + item.title + '"></li>\n'
                                })
                                console.log('var imgsDemo=' + imgsDemo)
                                lis.push(
                                    ' <div class="moon-news-card">\n' +
                                    '                    <div class="moon-news-img">\n' +
                                    '                        <div class="news-img-title" onclick="goTo(' + item.classifyId + ',' + item.id + ')">' + item.title + '</div>\n' +
                                    '                        <div class="news-img-atlas">\n' +
                                    '                            <ul>\n' + imgsDemo +
                                    '                            </ul>\n' +
                                    '                        </div>\n' +
                                    '                        <div class="news-img-info">\n' +
                                    '                            <div class="news-info-left">\n' +
                                    '\n' +
                                    '                                <button class="layui-btn layui-btn-xs moon-btn-primary-danger">' + item.sort + '</button>\n' +
                                    '                                <img src="' + item.avatar + '" alt="">\n' +
                                    '                                <span class="moon-breadcrumb">\n' +
                                    '                                  <a href="">首页</a>\n' +
                                    '                                    <span>/</span>\n' +
                                    '                                  <a href="#">' + item.username + '</a>\n' +
                                    '                                    <span>/</span>\n' +
                                    '                                  <a class="moon-this">' + item.manyTimeAgo + '</a>\n' +
                                    '                                </span>\n' +
                                    '                            </div>\n' +
                                    '                            <div class="news-info-right">\n' +
                                    '                                <i class="layui-icon immnc mmnc-shanchuguanbicha cursor-pointer"></i>\n' +
                                    '                            </div>\n' +
                                    '                        </div>\n' +
                                    '                    </div>\n' +
                                    '                    <span class="moon-news-card-split"></span>\n' +
                                    '                </div>'
                                )
                            });

                            //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                            //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                            next(lis.join(''), page < data.data.pageContent.totalPages);
                        } else {
                            layer.msg("亲刷新重试");
                        }
                        if (data.code == 3) {
                            layer.msg(data.message);
                            setTimeout(function () {
                                location = "/login.html"
                            }, 1000)
                        }


                    },
                    error: function (data) {
                        layer.msg('网络错误');
                    }
                });

            }
        });
    });
}

function attentionList(id) {
    layui.use('flow', function () {
        var $ = layui.jquery; //不用额外加载jQuery，flow模块本身是有依赖jQuery的，直接用即可。
        var flow = layui.flow;
        flow.load({
            elem: '#attentionList' //指定列表容器
            , done: function (page, next) { //到达临界点（默认滚动触发），触发下一页
                var lis = [];
                //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
                $.ajax({
                    type: 'post',
                    dataType: 'json',
                    contentType: "application/x-www-form-urlencoded",
                    xhrFields: {
                        withCredentials: true
                    },
                    crossDomain: true,
                    url: 'https://news.immnc.com/api/personal/user/attention/list',// "https://news.immnc.com/api/user/checkPhoneToCode"
                    data: {
                        "page": page,
                        "userId": id
                    },
                    success: function (data) {
                        if (data.code == 0) {
                            layui.each(data.data.attention.pageContent, function (index, item) {
                                imgPrefix = "";
                                if (item.isOwn == 1) {
                                    imgPrefix = "https://p0.cdrysj.com/po"
                                }
                                lis.push(
                                    '<li class="moon-news-card">\n' +
                                    '                                            <div class="attention-item">\n' +
                                    '                                                <div class="attention-person-info">\n' +
                                    '                                                    <img src="' + item.byAvatar + '"\n' +
                                    '                                                         alt="">\n' +
                                    '                                                    <p>' + item.byUsername + '</p>\n' +
                                    '                                                </div>\n' +
                                    '                                                <div class="controller-button">\n' +
                                    '                                                    <button class="layui-btn layui-btn-warm  layui-btn-sm"><i\n' +
                                    '                                                            class="layui-icon layui-icon-add-1"></i> 关注\n' +
                                    '                                                    </button>\n' +
                                    '                                                    <button class="layui-btn layui-btn-sm">\n' +
                                    '                                                        <i class="layui-icon layui-icon-dialogue"></i>消息\n' +
                                    '                                                        <span class="layui-badge-dot"></span>\n' +
                                    '                                                    </button>\n' +
                                    '                                                </div>\n' +
                                    '                                            </div>\n' +
                                    '                                            <span class="moon-news-card-split"></span>\n' +
                                    '                                        </li>'
                                )
                            });

                            //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                            //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                            next(lis.join(''), page < data.data.attention.totalPages);
                        } else {
                            layer.msg("亲刷新重试");
                        }
                        if (data.code == 3) {
                            layer.msg(data.message);
                            setTimeout(function () {
                                location = "/login.html"
                            }, 1000)
                        }


                    },
                    error: function (data) {
                        layer.msg('网络错误');
                    }
                });

            }
        });
    });
}

function fansList(id) {
    layui.use('flow', function () {
        var $ = layui.jquery; //不用额外加载jQuery，flow模块本身是有依赖jQuery的，直接用即可。
        var flow = layui.flow;
        flow.load({
            elem: '#fansList' //指定列表容器
            , done: function (page, next) { //到达临界点（默认滚动触发），触发下一页
                var lis = [];
                //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
                $.ajax({
                    type: 'post',
                    dataType: 'json',
                    contentType: "application/x-www-form-urlencoded",
                    xhrFields: {
                        withCredentials: true
                    },
                    crossDomain: true,
                    url: 'https://news.immnc.com/api/personal/user/fans/list',// "https://news.immnc.com/api/user/checkPhoneToCode"
                    data: {
                        "page": page,
                        "userId": id
                    },
                    success: function (data) {
                        if (data.code == 0) {
                            layui.each(data.data.fans.pageContent, function (index, item) {
                                imgPrefix = "";
                                if (item.isOwn == 1) {
                                    imgPrefix = "https://p0.cdrysj.com/po"
                                }
                                lis.push(
                                    '<li class="moon-news-card">\n' +
                                    '                                            <div class="attention-item">\n' +
                                    '                                                <div class="attention-person-info">\n' +
                                    '                                                    <img src="' + item.byAvatar + '"\n' +
                                    '                                                         alt="">\n' +
                                    '                                                    <p>' + item.byUsername + '</p>\n' +
                                    '                                                </div>\n' +
                                    '                                                <div class="controller-button">\n' +
                                    '                                                    <button class="layui-btn layui-btn-warm  layui-btn-sm"><i\n' +
                                    '                                                            class="layui-icon layui-icon-add-1"></i> 关注\n' +
                                    '                                                    </button>\n' +
                                    '                                                    <button class="layui-btn layui-btn-sm">\n' +
                                    '                                                        <i class="layui-icon layui-icon-dialogue"></i>消息\n' +
                                    '                                                        <span class="layui-badge-dot"></span>\n' +
                                    '                                                    </button>\n' +
                                    '                                                </div>\n' +
                                    '                                            </div>\n' +
                                    '                                            <span class="moon-news-card-split"></span>\n' +
                                    '                                        </li>'
                                )
                            });

                            //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                            //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                            next(lis.join(''), page < data.data.fans.totalPages);
                        } else {
                            layer.msg("亲刷新重试");
                        }
                        if (data.code == 3) {
                            layer.msg(data.message);
                            setTimeout(function () {
                                location = "/login.html"
                            }, 1000)
                        }


                    },
                    error: function (data) {
                        layer.msg('网络错误');
                    }
                });

            }
        });
    });
}


function getHistory(id) {
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: "application/x-www-form-urlencoded",
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true,
        url: 'https://news.immnc.com/api/personal/user/history/list',// "https://news.immnc.com/api/user/checkPhoneToCode"
        data: {
            "page": 1,
            "userId": id
        },
        success: function (data) {
            if (data.code == 0) {
                layui.each(data.data.look.pageContent, function (index, item) {
                    $("#historyList").append(
                        ' <li class="moon-news-card">\n' +
                        '                                                <a onclick="goTo(0,' + item.id + ')" class="hot-item-title">\n' +
                        '                                                    <p>' + item.title + '</p>\n' +
                        '                                                </a>\n' +
                        '                                                <span class="moon-news-card-split"></span>\n' +
                        '                                            </li>'
                    )
                })
            }
            else {
                layer.msg("亲刷新重试");
            }
            if (data.code == 3) {
                layer.msg(data.message);
                setTimeout(function () {
                    location = "/login.html"
                }, 1000)
            }
        }
        ,
        error: function (data) {
            layer.msg('网络错误');
        }

    });


}

function wantToVIP() {
    var userType = 1;
    var auditState = 0;
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: "application/x-www-form-urlencoded",
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true,
        url: 'https://news.immnc.com/oa/author/state',// "https://news.immnc.com/api/user/checkPhoneToCode"
        success: function (data) {
            if (data.code == 0) {
                console.log(data)
                userType = data.data.userType;
                auditState = data.data.auditState;

                if (userType == 1 && auditState == 0) {
                    authorAdd()
                } else if (userType == 1 && auditState == 1) {
                    layer.msg("作者申请已提交\n请耐心等待\n工作人员3-7天审核完成")
                } else {
                    layer.msg("即将为你跳转后台页面。")
                    setTimeout(function () {
                        location = "http://news.immnc.com:8888"
                    }, 700)
                }
            } else {
                layer.msg("亲刷新重试");
            }
            if (data.code == 3) {
                layer.msg(data.message);
                setTimeout(function () {
                    location = "/login.html"
                }, 1000)
            }


        },
        error: function (data) {
            layer.msg('网络错误');
        }
    });

}

function authorAdd() {
    layer.prompt({title: '请写出个人简介，方便审核', formType: 2}, function (text, index) {
        layer.close(index);
        $.ajax({
            type: 'post',
            dataType: 'json',
            contentType: "application/x-www-form-urlencoded",
            xhrFields: {
                withCredentials: true
            },
            crossDomain: true,
            url: 'https://news.immnc.com/oa/author/apply',// "https://news.immnc.com/api/user/checkPhoneToCode"
            data: {
                "reason": text
            },
            success: function (data) {
                if (data.code == 0) {
                    layer.msg('提交成功~');
                } else {
                    layer.msg("亲刷新重试");
                }
                if (data.code == 3) {
                    layer.msg(data.message);
                    setTimeout(function () {
                        location = "/login.html"
                    }, 1000)
                }


            },
            error: function (data) {
                layer.msg('网络错误');
            }
        });
    });
}