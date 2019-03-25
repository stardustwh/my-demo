package test;

import org.junit.Test;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//统计在文件中字符串出现的次数
public class ScanTest {

    @Test
    public void test1() {

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("E:\\project\\my-demo\\my-demo1\\src\\main\\resources\\test.txt"));
            StringBuffer sb = new StringBuffer();
            String str = null;
            while((str = br.readLine()) != null) {
                sb.append(str);
            }

            String regex = "test";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(sb);

            int num =0;
            while(matcher.find()) {
                num++;
            }

            System.out.println("次数为：" +num);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != br){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
