var localPrefix = ""
layui.use('flow', function () {
    var $ = layui.jquery; //不用额外加载jQuery，flow模块本身是有依赖jQuery的，直接用即可。
    var flow = layui.flow;
    flow.load({
        elem: '#home-list' //指定列表容器
        , done: function (page, next) { //到达临界点（默认滚动触发），触发下一页
            var lis = [];
            //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
            $.post(localPrefix+'/moon/article/index?page=' + page, function (res) {
                //假设你的列表返回在data集合中
                layui.each(res.data.records, function (index, item) {
                    //图文添加
                    if (item.typeId == 1) {
                        lis.push(
                            '<div class="moon-news-card">\n' +
                            '                    <div class="moon-news-text" onclick="goTo('+item.classifyId+','+item.articleId+')">\n' +
                            '                        <img class="news-text-img" src="' + item.imgUrl[0] + '">\n' +
                            '                        <div class="news-text-info">\n' +
                            '                            <div class="news-text-title">' + item.title + '</div>\n' +
                            '                            <div class="news-info">\n' +
                            '                                <div class="news-info-left">\n' +
                            '\n' +
                            '                                    <button class="layui-btn layui-btn-xs moon-btn-primary-danger">' + item.classifyName + '</button>\n' +
                            '                                    <img src="' + item.avatar + '" alt="' + item.username + '">\n' +
                            '                                    <span class="moon-breadcrumb">\n' +
                            '                                  <a href="">首页</a>\n' +
                            '                                    <span>/</span>\n' +
                            '                                  <a href="#">' + item.username + '</a>\n' +
                            '                                    <span>/</span>\n' +
                            '                                  <a class="moon-this">' + item.commentNum + '条评论</a>\n' +
                            '                                </span>\n' +
                            '                                </div>\n' +
                            '                                <div class="news-info-right">\n' +
                            '                                    <i class="layui-icon immnc mmnc-shanchuguanbicha cursor-pointer"></i>\n' +
                            '                                </div>\n' +
                            '                            </div>\n' +
                            '                        </div>\n' +
                            '                    </div>\n' +
                            '                    <span class="moon-news-card-split"></span>\n' +
                            '                </div>'
                        )
                    }
                    if (item.typeId == 2) {
                        var imgsDemo = "";
                        layui.each(item.imgUrl, function (index, item) {
                            if (index < 5)
                                imgsDemo = imgsDemo + '<li><img src="' + urlPrefix + item + '" alt="' + item.title + '"></li>\n'
                        })
                        console.log('var imgsDemo=' + imgsDemo)
                        lis.push(
                            ' <div class="moon-news-card">\n' +
                            '                    <div class="moon-news-img">\n' +
                            '                        <div class="news-img-title" onclick="goTo('+item.classifyId+','+item.articleId+')">' + item.title + '</div>\n' +
                            '                        <div class="news-img-atlas">\n' +
                            '                            <ul>\n' + imgsDemo +
                            '                            </ul>\n' +
                            '                        </div>\n' +
                            '                        <div class="news-img-info">\n' +
                            '                            <div class="news-info-left">\n' +
                            '\n' +
                            '                                <button class="layui-btn layui-btn-xs moon-btn-primary-danger">' + item.classifyName + '</button>\n' +
                            '                                <img src="' + item.avatar + '" alt="">\n' +
                            '                                <span class="moon-breadcrumb">\n' +
                            '                                  <a href="">首页</a>\n' +
                            '                                    <span>/</span>\n' +
                            '                                  <a href="#">' + item.username + '</a>\n' +
                            '                                    <span>/</span>\n' +
                            '                                  <a class="moon-this">' + item.commentNum + '条评论</a>\n' +
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
                    }
                    if (item.typeId == 3) {
                        lis.push(
                            '<div class="moon-news-card">\n' +
                            '                            <div class="moon-news-video">\n' +
                            '                                <div class="moon-news-video-cover" onclick="goTo('+item.classifyId+','+item.articleId+')">\n' +
                            '                                    <img src="' + urlPrefix + item.imgUrl[0] + '" alt="' + item.title + '">\n' +
                            '                                    <i class="layui-icon immnc mmnc-shipinbofangyingpian"></i>\n' +
                            '                                </div>\n' +
                            '                                <div class="moon-news-video-content">\n' +
                            '                                    <div class="news-video-title" onclick="goTo('+item.classifyId+',"'+item.articleId+'")">' + item.title + '</div>\n' +
                            '                                    <div class="news-video-info">\n' +
                            '                                        <div class="news-info-left">\n' +
                            '                                            <button class="layui-btn layui-btn-xs moon-btn-primary-danger">' + item.classifyName + '</button>\n' +
                            '                                            <img src="' + item.avatar + '" alt="">\n' +
                            '                                            <span class="moon-breadcrumb">\n' +
                            '                                  <a >首页</a>\n' +
                            '                                    <span>/</span>\n' +
                            '                                  <a href="#">' + item.username + '</a>\n' +
                            '                                    <span>/</span>\n' +
                            '                                  <a class="moon-this">' + item.commentNum + '条评论</a>\n' +
                            '                                </span>\n' +
                            '                                        </div>\n' +
                            '                                        <div class="news-info-right">\n' +
                            '                                            <i class="layui-icon immnc mmnc-shanchuguanbicha cursor-pointer"></i>\n' +
                            '                                        </div>\n' +
                            '                                    </div>\n' +
                            '                                </div>\n' +
                            '                            </div>\n' +
                            '                            <span class="moon-news-card-split"></span>\n' +
                            '                        </div>'
                        )
                    }
                });

                //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                console.log(res.data.pages)
                next(lis.join(''), page < res.data.pages);
            });

        }
    });
});