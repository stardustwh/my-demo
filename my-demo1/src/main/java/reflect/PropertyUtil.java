package reflect;

import java.lang.reflect.Field;

public class PropertyUtil {

    //给任何对象，任何属性赋值
    public static void setProperty(Object obj,String propertyName,Object value){
        Class<?> clazz = obj.getClass();//反射得到class

        try {
            Field declaredField = clazz.getDeclaredField(propertyName);
            declaredField.setAccessible(true);
            declaredField.set(obj,value);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        Dog dog = new Dog();
        PropertyUtil.setProperty(dog,"name","旺财");
        System.out.println(dog.getName());
    }
}
