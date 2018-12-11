package com.moon.immncweb.core.utils;

import java.util.List;

/**
 * @Author zhaoxiang
 * @Date 2018/09/06
 * @Desc
 */
public class SEOUtil {
    /**
     * description处理
     * @param content
     * @return
     */
    public static String getDescription(String content){
        String newContent = HTMLSpirit.delHTMLTag(content);
        return newContent.length() > 100 ? newContent.substring(0,97)+"..." : newContent;
    }
    /**
     * 头部keywords处理方法
     * @param stringList
     * @return
     */
    public static String getKeywordsByList(List<String> stringList){
        String s = "";
        if (stringList != null){
            if (stringList.isEmpty()){
                return s;
            }
            for (int i = 0;i < stringList.size();i++){
                if (i == stringList.size()-1){
                    s = s + stringList.get(i);
                } else  {
                    s = s + stringList.get(i)+",";
                }
            }
        }
        return s;
    }
}


