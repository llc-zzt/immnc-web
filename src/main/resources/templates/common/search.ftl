<div class="moon-search-model">
    <div class="moon-search-model-top">
        <div class="search-model-logo">
            <img src="/images/logo-search.png" alt="">
        </div>
        <form class="search-model-input">
            <input id="bdcsMain" type="text" placeholder="搜个关键字看看~">
            <#--onclick="window.open('//zhannei.immnc.com?s=9033002423418034164&entry=1&q='+document.getElementById('bdcsMain').value)"-->
            <button class="layui-btn" onclick="window.open('http://zhannei.baidu.com/cse/search?s=9033002423418034164&entry=1&q='+document.getElementById('bdcsMain').value)" >立即搜索</button>
        </form>
    </div>
        <#if (searchTopList?size>0)>
            <div class="moon-search-model-bottom">
                <img class="" src="/images/Group10.png" alt="">
                <ul class="search-model-img-group">

                    <#list searchTopList as item>
                        <#if item_index<4>
                            <li onclick="goTo(${classifyId},${item.getArticleId()})">
                                <#if item.typeId!=1>
                                    <img src="${config.getImgPrefix()+item.imgUrl[0]}" alt="${item.getTitle()}">
                                <#else >
                                     <img src="${item.imgUrl[0]}" alt="${item.getTitle()}">
                                </#if>

                                <p>${item.getTitle()}</p>
                            </li>
                        </#if>
                    </#list>
                </ul>
            </div>
        </#if>

    <i class="immnc mmnc-shanchuwubiankuang model-close"></i>
</div>
 <#--<script type="text/javascript">(function () {-->
     <#--document.write(unescape('%3Cdiv id="bdcs"%3E%3C/div%3E'));-->
     <#--var bdcs = document.createElement('script');-->
     <#--bdcs.type = 'text/javascript';-->
     <#--bdcs.async = true;-->
     <#--bdcs.src = '//znsv.baidu.com/customer_search/api/js?sid=9033002423418034164' + '&plate_url=' + encodeURIComponent(window.location.href) + '&t=' + Math.ceil(new Date() / 3600000);-->
     <#--var s = document.getElementsByTagName('script')[0];-->
     <#--s.parentNode.insertBefore(bdcs, s);-->
     <#--console.log(bdcs)-->
 <#--})();</script>-->