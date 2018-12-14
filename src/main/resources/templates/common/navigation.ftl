<#include "search.ftl">
<div id="moon-nav" class="moon-nav moon-z-depth">
    <div class="moon-nav-body">
        <div class="moon-nav-left">
            <img src="/images/logo-home.png" alt="妙漫网创 immnc">
        </div>
        <div class="moon-nav-right">
            <div class="moon-nav-classify">
                <ul>
                    <li>
                        <a href="/">推荐</a>
                        <span <#if classifyId == 0>class="active"</#if>></span>
                    </li>
                </ul>
            </div>
            <div class="moon-nav-search">
                <div class="moon-nav-search-lift">
                    <a href="">
                        <img id="userAvatar" width="46px" height="46px"  src="" alt="">
                    </a>
                    <a href="/login.html" style="display: none" id="login_button" class="layui-btn layui-btn-primary layui-btn-sm">登录</a>
                </div>
                <div class="moon-nav-search-right">
                    <div class="moon-nav-search-input">
                        <div class="form-group">
                            <div class="input-group">
                                <input type="text" class="form-control" id="">
                            </div>
                        </div>
                    </div>
                    <i class="layui-icon layui-icon-search cursor-pointer"></i>
                </div>
            </div>
        </div>
    </div>
</div>