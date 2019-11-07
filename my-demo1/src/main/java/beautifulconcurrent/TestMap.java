package beautifulconcurrent;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestMap {
    static ConcurrentHashMap<String, List<String>> map = new ConcurrentHashMap<>();
//    static Map<String, List<String>> map = new HashMap<>();
    public static void main(String[] args) {

        List<String> list2 = new ArrayList<>();
        list2.add("device1");
        list2.add("device2");
        Map map1 = new HashMap();
        map1.put("list2",list2);

        list2.add("sb");
        System.out.println(map1);
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> list1 = new ArrayList<>();
                list1.add("device1");
                list1.add("device2");

                List<String> oldList = map.putIfAbsent("topic1", list1);
                if (null != oldList) {
//                    oldList.addAll(list1);
                    list1.addAll(oldList);
                }

                list1.add("cnm");

//                map.putIfAbsent("topic1", list1);
                System.out.println("111111111111"+JSON.toJSONString(map));
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> list1 = new ArrayList<>();
                list1.add("device11");
                list1.add("device22");
                List<String> oldList = map.putIfAbsent("topic1", list1);
                if (null != oldList) {
                    //                    oldList.addAll(list1);
                    list1.addAll(oldList);
                }
                System.out.println(oldList);
                System.out.println(list1);
//                map.putIfAbsent("topic1", list1);
                System.out.println("2222222222"+JSON.toJSONString(map));
            }
        });

        Thread threadThree = new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> list1 = new ArrayList<>();
                list1.add("device111");
                list1.add("device222");
                List<String> oldList = map.putIfAbsent("topic2", list1);
                if (null != oldList) {
                    //                    oldList.addAll(list1);
                    list1.addAll(oldList);
                }
//                map.put("topic2", list1);
                System.out.println("333333333333"+JSON.toJSONString(map));
            }
        });

        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }
}
