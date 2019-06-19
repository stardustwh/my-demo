package reflect;

import org.junit.Test;

import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

public class ReflectEntrance {

    //创建反射的三种方法
    public static void main(String[] args) throws ClassNotFoundException {
        //1.Class.forName()
        Class<?> dClazz = Class.forName("reflect.Dog");
        System.out.println(dClazz);

        //2.类名.class
        Class<Dog> dClazz2 = Dog.class;
        System.out.println(dClazz2);

        //3.对象.getClass
        Dog dog = new Dog();
        Class<?> dClazz3 = dog.getClass();
        System.out.println(dClazz3);
    }

    //用反射获取类的方法
    @Test
    public void test1() throws ClassNotFoundException {

        Class<?> dClazz = Class.forName("reflect.Dog");

        //获取所有的公共方法（没有private)
        //但是有它所有有关联的类的方法，包括接口，他的父类Object
        Method[] methods = dClazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        System.out.println("----------------------------------");

        //可以得到当前类的所有的方法，包括私有的方法
        Method[] declaredMethods = dClazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method.getName());
        }

    }

    //用反射获取接口
    @Test
    public void test2() throws ClassNotFoundException {
        Class<?> dClazz = Class.forName("reflect.Dog");

        //获取Dog实现的所有的接口
        Class<?>[] interfaces = dClazz.getInterfaces();
        for (Class<?> inter : interfaces) {
            System.out.println(inter);
        }
    }

    //用反射获取成员变量
    @Test
    public void test3() throws ClassNotFoundException {
        Class<?> dClazz = Class.forName("reflect.Dog");

        //只能获取到公共的属性，为了测试我这里用了一个public 的desc属性
        Field[] fields = dClazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("---------------------");

        Field[] declaredFields = dClazz.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }
    }

    //用反射获取构造器
    @Test
    public void test4() throws ClassNotFoundException {

        Class<?> dClazz = Class.forName("reflect.Dog");

        //注意没有获取到私有的那个构造方法 private Dog(String name)
        Constructor<?>[] constructors = dClazz.getConstructors();
        for (Constructor<?> c : constructors) {
            System.out.println(c);
        }
        System.out.println("---------------------");

        //这里可以获取到当前类的所有方法（包括private)
        Constructor<?>[] declaredConstructors = dClazz.getDeclaredConstructors();
        for (Constructor<?> dc : declaredConstructors) {
            System.out.println(dc);
        }
    }

    //用反射获取父类
    @Test
    public void test5() throws ClassNotFoundException {
        Class<?> dClazz = Class.forName("reflect.Dog");

        Class<?> superClass = dClazz.getSuperclass();
        System.out.println(superClass);//默认就是Object

    }

    //用反射创建实例
    @Test
    public void test6() throws Exception {
        Class<?> dClazz = Class.forName("reflect.Dog");

        Object o = dClazz.newInstance();
        Dog dog = (Dog) o;
        System.out.println(dog);
        dog.eat();//调用dog的eat()
    }

    //获取到对象的实例，并操作对象
    @Test
    public void test7() throws Exception {
        Class<?> dClazz = Class.forName("reflect.Dog");

        Dog dog = (Dog) dClazz.newInstance();
        //操作属性
        dog.setName("旺财");
        dog.setId(101);

        System.out.println(dog.getName());


    }

    //setAcdessible在属性上的使用
    @Test
    public void test8() throws Exception {

        Class<?> dClazz = Class.forName("reflect.Dog");

        Dog dog = (Dog) dClazz.newInstance();

        Field nameField = dClazz.getDeclaredField("name");

        //下面是很关键的yi'bu一步，如果没有这一步，就会出错（访问权限不够）
        //修改访问权限
        //nameField.setAccessible(true);//打开属性的访问权限
        nameField.set(dog, "旺财");
        System.out.println(dog.getName());

    }

    //setAccessible 在方法上的使用
    @Test
    public void test9() throws Exception {
        Class<?> dClazz = Class.forName("reflect.Dog");

        Dog dog = (Dog) dClazz.newInstance();

        //获取到一个私有方法
        Method pmethod = dClazz.getDeclaredMethod("privateMethod");

        pmethod.setAccessible(true);
        //方法不是set，而是invoke(),第一个参数是：方法调用的对象，第二个参数是：方法的参数
        pmethod.invoke(dog,null);//因为privateMethod()没有参数，所以args = null

        Method pmethod2 = dClazz.getDeclaredMethod("privateMethod2",String.class);//这里要传入privateMethod2参数的类型
        pmethod2.setAccessible(true);
        pmethod2.invoke(dog,"旺财");
    }

    /**
     * 操作构造方法
     * setAccessible的使用
     */
    @Test
    public void test10() throws Exception{
        Class<?> dClazz = Class.forName("reflect.Dog");

        //获取指定的构造方法，那个三个参数的构造方法

        Constructor<?> threeCtr = dClazz.getConstructor(int.class,String.class,int.class);
        //下面这种写法是错误的，在反射中,Int和Integer是不同的，即Int.class != Integer.class
        //Constructor<?> threeCtr = dClazz.getConstructor(Integer.class,String.class,Integer.class);
        Dog dog = (Dog)threeCtr.newInstance(101,"旺财",2);
        System.out.println("id :" + dog.getId() + ", name :" + dog.getName());

        Constructor<?> oneCtr = dClazz.getDeclaredConstructor(String.class);//拿到私有的构造方法
        oneCtr.setAccessible(true);//这一步很重要
        Dog dog2 = (Dog) oneCtr.newInstance("大黄");
        System.out.println(dog2.getName());

    }

    /**
     * 反射的应用实例
     * 通过配置文件生成类
     */
    @Test
    public void test11() throws Exception {
        Properties prop = new Properties();
        prop.load(new FileReader("E:\\project\\my-demo\\my-demo1\\src\\main\\resources\\class.txt"));

        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");

        Class<?> clazz = Class.forName(className);

        Method method = clazz.getMethod(methodName);
        method.invoke(clazz.newInstance());//后面是可变参数，可以省略
    }

    /**
     * 反射略过泛型检查
     */
    @Test
    public void test12() throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(1);
        //list.add("ff");//编译报错

        //下面可以通过编译
        Class<?> listClass = list.getClass();

        Method addMethod = listClass.getMethod("add",Object.class);//传一个Object，此时可以添加任意类型。
        addMethod.invoke(list,"ff");

        System.out.println(list);
    }




}

