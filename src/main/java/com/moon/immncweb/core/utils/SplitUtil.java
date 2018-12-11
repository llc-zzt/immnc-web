package com.moon.immncweb.core.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhaoxiang
 * @Date 2018/11/28
 * @Desc 切割工具
 */
public class SplitUtil {
    /**
     * 将字符串转为list
     * @param splitString
     * @param splitMart
     * @return
     */
    public static List<String> split(String splitString,String splitMart){

        List<String> list = new ArrayList<String>();

        if (splitString!=""){
            String[] ss = splitString.split(splitMart);
            for (int i = 0; i < ss.length; i++){
                list.add(ss[i]);
            }
        }
        return list;
    }
    /**
     * 将字符串转为list
     * @param splitString
     * @param splitMart
     * @return
     */
    public static List<String> split(String splitString,String splitMart,Integer type,Integer isWOn){

        List<String> list = new ArrayList<String>();

        if (splitString!=""){
            String[] ss = splitString.split(splitMart);
            for (int i = 0; i < ss.length; i++){
                if (isWOn==null){
                    if (type==1){
                        list.add("https://p0.cdrysj.com/po"+ss[i]);
                    }else {
                        list.add(ss[i]);
                    }
                }else {
                    if (isWOn==1&&type==1){
                        list.add("https://p0.cdrysj.com/po"+ss[i]);
                    }else {
                        list.add(ss[i]);
                    }
                }
            }
        }
        return list;
    }
}
