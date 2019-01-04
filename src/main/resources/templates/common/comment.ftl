<div class="moon-comment-card">
    <div class="moon-comment-box">
        <!--用户信息-->
        <div class="moon-comment-header">
            <div class="avatar-img">
                <#--class is_login-->
                <a id="cmt-avatar-valid" class="is_login">
                    <img id="cmt-avatar" src="//sucimg.itc.cn/avatarimg/10101371442733_1543997437371_c55" width="42"
                         height="42" alt="">
                    <p class="login_style" href="/login.html">登录</p>
                </a>
            </div>
            <#--user-login-->
            <div id="cmt-username-valid" class="user-wrap-w user-login">
                <span id="cmt-username" class="">popo：</span>
            </div>
        </div>
        <!--评论输入框-->
        <div class="moon-comment-content">
            <div class="moon-comment-content-t"></div>
            <div class="moon-comment-content-l"></div>
            <div class="moon-comment-content-r"></div>
            <div class="moon-comment-content-main">
                <a href="#comment" class="moon-relpay-box">
                    <textarea id="${newsVO.getArticleId()}" class="textarea-fw comment-textarea" placeholder="说点什么吧~"></textarea>
                </a>
            </div>
        </div>
        <!--评论发送-->
        <div class="comment-control">
            <div class="emotion">
                <i class="immnc mmnc-xiaolianmanyifuwu face"></i>
                <button  class="layui-btn reply-btn" onclick="send()"></button>
            </div>
        </div>
        <!--评论头-->

            <div class="cmt-list-type">
                <ul class="type-lists">
                    <li class="type-list active">评论</li>
                    <!-- <li class="type-list">热门</li> -->
                </ul>
                <div class="cmt-list-number">
                                <span class="comment-number">
                                    <span class="cy-number">${newsVO.getCommentNum()!}</span>人参与,
                                    <span class="cy-number">${newsVO.getCommentNum()!}</span>条评论
                                </span>
                </div>
            </div>
        <!--评论回复列表-->
        <div class="cmt-list-box">
            <ul class="cmt-list-header">
                <li>
                    <div class="title-name-gw-tag"></div>
                    <span>最新评论</span>
                </li>
            </ul>
            <ul class="cy-cmt-list">
            </ul>
            <#if (newsVO.getCommentNum()>0) >
                <a class="cmt-load-more">查看更多评论</a>
            </#if>
            <div class="cmt-load-more-loop hide">
                <i class="layui-icon layui-icon-loading layui-icon layui-anim layui-anim-rotate layui-anim-loop"></i>
            </div>
            <a class="no-more-tips cmt-load-all-more" style="display: none;cursor: pointer" onclick="appDownload()">以上为热门评论，妙漫网创 App 还有更多内容</a>
        </div>

    </div>
</div>
<div class="moon-detail-feed">
    <div class="title">相关推荐</div>
</div>