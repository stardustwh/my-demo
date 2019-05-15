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



}
