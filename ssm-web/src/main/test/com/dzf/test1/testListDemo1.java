package com.dzf.test1;

import java.util.*;

/**
 * @author dingzf
 * @date 2018/3/17
 * @time 13:14
 */
public class testListDemo1 {
    public static void main(String[] args) {

        try {

        }catch (NullPointerException e){

        }

        String stri = "agasdfasdfdccvvasdfg";
        String str = "a,b,c,a,v,d,f,s,s,f,f,sd";
        String[] strings = str.split(",");
        Map<String, Integer> map = new HashMap<>();
        for (String string : strings) {
            if (map.containsKey(string)) {
                map.put(string, map.get(string) + 1);
            } else {
                map.put(string, 1);
            }
        }
        System.out.println(map);

        Collection<Integer> values = map.values();
        List<Integer> list = new ArrayList<>();
        for (Integer value : values) {
            list.add(value);
        }
        //将list的值进行反序排序
        Collections.sort(list, Comparator.reverseOrder());
       /* Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //大于0表示正序，小于0表示逆序
                return o2-o1;
            }
        });*/
       //使用linkedHashMap
        LinkedHashMap<String ,Integer> linkedHashMap = new LinkedHashMap<>();
        for (Integer integer : list) {
               for (String key : map.keySet()){
                   if(integer == map.get(key)){
                     linkedHashMap.put(key,integer);
                   }
            }
        }
        System.out.println(linkedHashMap.keySet());
    }
    /**
     * 需求描述 请将 a,b,c,a,v,d,f,s,s,f,f,sd 这样字符串按每个字符出现次数的多少从大到小进行排序
     *
     */
}
