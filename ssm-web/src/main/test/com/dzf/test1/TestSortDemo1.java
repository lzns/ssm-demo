package com.dzf.test1;

import java.util.*;

/**
 * <description>
 * <p>
 * </description>
 *
 * @author dingzf
 * @date 2018/3/17
 * @time 14:41
 */
public class TestSortDemo1 {
    public static void main(String[] args) {
        //  stringSort();
        //maoPaoSort();
        // int[] values = {12, 11, 2, 3, 0, 43, 232, 23, 87};
        //speedSort();
        quickSort();
        System.out.println(10<<1);
        System.out.println(0x7fffffff);
        //测试arrayList 的扩容机制 初始化是10 之后直接扩容至10+ 10>>1; 即30
       List list= new ArrayList();
       list. add(1);
       list. add(2);
       list. add(3);
       list. add(4);
       list. add(5);
       List list1 = list.subList(0, 2);
       list1.clear();
       System.out.println(list);
       List list2 = new LinkedList();

        int a = 10;
        System.out.println(10>>1);
        System.out.println(a+(a>>1));
        Collections.synchronizedMap(new HashMap<>());
        Collections.synchronizedSet(new TreeSet<>());
        Collections.synchronizedList(new ArrayList<>());
        //TreeSet;
        //HashSet
        //LinkedHashSet
        // HashMap
        //        TreeMap
        //        LinkedHashMap
        //curm
        //二分查找法  查找8的位置 4
        System.out.println(3>>>1);
        int[] f = {1,2,29};
        int start = 0;//起始位置
        int end  = f.length -1 ;//终止位置
        int des = 29;
        while(start <= end){
            int middle = (start + end)>>>1;
            if (f[middle] == des) {
                System.out.println("目标数字所在的位置"+middle);
                break;
            }else if(des>f[middle]){
                start = middle+1;
            }else if (des<f[middle]){
                end = middle-1;
            }
        }


    }

    /**
     *
     */
    private static void maoPaoSort() {
        //从小到大
        int[] values = {1, 2, 34, 2, 23, 24, 231, 2};
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length - 1 - i; j++) {
                if (values[j] < values[j + 1]) {
                    max = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = max;
                }
            }

        }
        System.out.println(Arrays.toString(values));
    }

    /**
     * 排序，统计一个字符串中各个字符按出现的次数的大小从大到小排序
     */
    private static void stringSort() {
        String str = "agadfsffdfvasdf";
        final char[] chars = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                map.put(aChar, map.get(aChar) + 1);
            } else {
                map.put(aChar, 1);
            }
        }
        System.out.println(map);
        List<Map.Entry<Character, Integer>> list = new ArrayList<>();
        list.addAll(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
        System.out.println("从大到小的顺序：");
        for (Map.Entry<Character, Integer> characterIntegerEntry : list) {
            System.out.print(characterIntegerEntry.getKey() + ",");
        }
    }

    /**
     * 快速排序
     * <desc>
     * 思想：
     * i                   j
     * 12  3 4 0 34 13  23 9
     * 1.以12为基数，最左边为i 最右边为j
     * 从右往左，找第一个比12 小的数，为 9
     * 然后从左往右，找第一个比12大的数，为34
     * 将这两个位置的数换位，
     * i       j
     * 12 3 4 0 9 13 23 34
     * 然后再从23 开始往前找第一个比12小的数,知道i碰到j停下来，然后把i和j碰面的那个位置的元素he基准数替换
     * 9 3 4 0 12 13 23 34
     * 第一结束，此时12 右边都是比12 大的数 左边都是比12小的数
     * 继续，将9 3 4 0 分为一组 13 23 34 分为一组
     * i      j
     * 9 3 4 0
     * 从后向前找到第一个比9 小的数为 0 从前往后找第一个比9大的数，然后i和j碰面
     * 将基数9 和i和j碰面的这个位置的元素互换 为 0 3 4 9  这次分组结束0 3 4 为一组 继续上面的步骤
     * <p>
     * 1.首先定义一个基准数，基准数左边都是小于基准数的，右边都是大于基准数的
     * 2.将左边的和右边的再按上面的思想分开
     * </desc>
     */
    public static void speedSort() {

        int[] values = {12, 11,56,1,23,2,4,234,78,1, 87};
        quick_sort(values, 0, values.length - 1, 0);
        System.out.println(Arrays.toString(values));
        //TreeMap<String ,Integer> treeMap = new TreeMap<>(String::compareTo); lamb 表达式演示
    }

    private static void quick_sort(int[] values, int l, int r, int position) {
        int i = l,j = r,flag = values[position];
        while (j > i && values[j] > flag) {
            //从右边起找到第一个比基准数小的位置,找到就跳出循环
            j--;
        }
        //从左边起不包括基准数找到第一个比基准数大的位置，找到就跳出循环
        while (i < j && values[i] <= flag) {
            i++;
        }
        //如果i <> j 交换i和j位置的元素 然后
        if (j > i) {
            int temp = values[j];
            values[j] = values[i];
            values[i] = temp;
            quick_sort(values,i,j,position);
        } else if (j == i) {
            values[position] = values[j];
            values[j] = flag;
            quick_sort(values,position,i-1,position);
            quick_sort(values,i+1,r,i+1);
        }
        ArrayList a  = new ArrayList();
    }
    public static void quickSort(){
        int [] values = {1,3,2,56,32,0};
        int max = 0;
        /*for (int i = 0; i <values.length-1 ; i++) {
            for (int j = i+1; j <values.length ; j++) {
                if(values[i]<values[j]){
                    max = values[i];
                    values[i] = values[j];
                    values[j] = max;
                }
            }
        }*/
        for (int i = 0; i <values.length-1 ; i++) {
            for (int j = 0; j <values.length-i-1 ; j++) {
                if(values[j]>values[j+1]){
                    max = values[j];
                    values[j] = values[j+1];
                    values[j+1] = max;
                }
            }
        }
        System.out.println(Arrays.toString(values));
    }
}
