package java8;

import org.junit.Test;

import java.util.*;

public class LambdaExample {

    /**
     * 1.8之前的字符串排列
     */
    @Test
    public void java8After(){
        List<String> names = Arrays.asList("peter","anna","mike","xenia");

        Collections.sort(names,new Comparator<String>() {
            @Override
            public int compare(String a,String b){
                return b.compareTo(a);
            }
        });
        System.out.println(names.toString());
    }

    /**
     * 1.8之后的字符串排列
     */
    @Test
    public void java8Before(){
        List<String> names = Arrays.asList("peter","anna","mike","xenia");
        Collections.sort(names,(String a,String b)->b.compareTo(a));
        System.out.println(names.toString());

    }

    public static <T> List<T> filter(List<T> list,Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T e: list){
            if(p.test(e)){
                result.add(e);
            }
        }
        return result;
    }

    /**
     * java行为参数化
     */
    @Test
    public void test(){
        List<Integer> numbers = new ArrayList<>();
        for(int i =0; i<10; i++){
            numbers.add(i);
        }

        List<Integer> evenNumbers = filter(numbers,(Integer i) -> i % 2 == 0);
        System.out.println(evenNumbers);
    }



}
