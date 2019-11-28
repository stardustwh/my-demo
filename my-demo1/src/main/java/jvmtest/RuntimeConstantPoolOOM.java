package jvmtest;

public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("i").append("nt").toString();
        System.out.println(str2.intern() == str2);

        String suffix = "ssss.xlsx".substring("ssss.xlsx".lastIndexOf("."));

        System.out.println(suffix);
    }
}
