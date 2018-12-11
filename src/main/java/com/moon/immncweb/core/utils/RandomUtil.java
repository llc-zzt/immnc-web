package com.moon.immncweb.core.utils;

import com.moon.immncweb.common.vo.NewsVO;

import java.util.*;

/**
 * @Author zhaoxiang
 * @Date 2018/12/04
 * @Desc
 */
public class RandomUtil {
    public static List<String> randomListt(List<String> list) {
        List<String> ret = new ArrayList<String>();
        Random r = new Random();
        int index = 0;
        if (!list.isEmpty() && list.size() > 6) {
            for (int i = 0; i < 6; i++) {
                index = r.nextInt(list.size() - i);
                ret.add(list.get(index));
                list.remove(index);
            }
            return ret;
        }
        return list;
    }
    public static List createRandomList(List list, int n) {
        Map map = new HashMap();
        List listNew = new ArrayList();
        if (list.size() <= n) {
            return list;
        } else {
            while (map.size() < n) {
                int random = (int) (Math.random() * list.size());
                if (!map.containsKey(random)) {
                    map.put(random, "");
                    listNew.add(list.get(random));
                }
            }
            return listNew;
        }
    }
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1","2","3","4","5","6","7");
        System.out.println(RandomUtil.createRandomList(list,6).toString());
    }
}
