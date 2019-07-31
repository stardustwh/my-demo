package java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamExample {

    @Test
    public void testFilter() {
        List<String> stringList = new ArrayList<>();
        stringList.add("ddd2");
        stringList.add("aaa2");
        stringList.add("bbb1");
        stringList.add("aaa1");
        stringList.add("bbb3");
        stringList.add("acc");
        stringList.add("bbb2");
        stringList.add("ddd1");

        //Filter 过滤
   /*     stringList
                .stream()
                .filter((s)->s.startsWith("a"))
                .forEach(System.out::println);
*/      //上面写法为函数式编程简写。上下效果一致
/*        stringList
                .stream()
                .filter((s)->s.startsWith("a"))
                .forEach(x -> {
                    System.out.println(x);
                });


        //Sorted 排序    如果你不指定一个自定义的comparator 则会使用默认排序。
        stringList
                .stream()
                .filter((s)->s.startsWith("a"))
                .sorted()
                .forEach(System.out::println);*/

        //Map 映射
        stringList
                .stream()
                .map(String::toUpperCase)
                .sorted((a,b) -> b.compareTo(a))
                .forEach(System.out::println);

        //Match匹配
        boolean anyStartsWithA =
                stringList
                .stream()
                .anyMatch((s) -> s.startsWith("a"));

        System.out.println(anyStartsWithA);

        boolean allStartWithA =
                stringList
                .stream()
                .allMatch((s) -> s.startsWith("a"));
        System.out.println(allStartWithA);

        boolean noneStartsWithZ =
                stringList
                .stream()
                .noneMatch((s) -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);

        //Count 计数
        long startsWithB =
                stringList
                .stream()
                .filter((s) -> s.startsWith("b"))
                .count();
        System.out.println(startsWithB);

        //Reduce 规约

        Optional<String> reduced = stringList
                .stream()
                .sorted()
                .reduce((s1, s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);


    }
}
