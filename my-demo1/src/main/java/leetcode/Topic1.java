package leetcode;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 两数之和
 */
public class Topic1 {

    @Test
    public void test(){
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] nums1 = twoSum(nums,target);
        System.out.println(nums1[0]+"---------"+nums1[1]);
    }

    //暴力破解法
    public int[] twoSum(int[] nums,int target){

        for(int i =0; i<nums.length; i++){
            for(int j=1; j<nums.length; j++){
                if(nums[i]+nums[j]==target){
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }

    @Test
    public void test1(){
        String value = "DHGUDHO3JGK2KJFK23";
        String strings[] = value.split("\\D+");
        int sum = 0;
        for (String s : strings) {
            if (!s.equals("")) {
                sum += Integer.parseInt(s);
            }
        }

        System.out.println(sum);

        /*String str = "DHGUDHO3JGK2KJFK23";

        char[] chars = str.toCharArray();
        List<String> list = new ArrayList();

        for (int i=0; i<chars.length; i++){
            list.add(String.valueOf(chars[i]));
        }

        list.stream().filter((s)->s.startsWith("a")).forEach(System.out::println);
        System.out.println(list.get(0));*/

        //System.out.println(Integer.parseInt(chars[0]));
    }


}
