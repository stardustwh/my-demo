package proxy.jdkproxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.LocalDate;

/**
 * jdk动态代理的缺点——被代理的类一定要实现了某个接口。
 */
public class DynamicAgent {

    //实现invocationHandler接口，并且可以初始化被代理类的对象
    static class MyHandler implements InvocationHandler{
        private Object proxy;
        public MyHandler(Object proxy) {
            this.proxy = proxy;
        }

        //自定义invoke方法
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(">>>>before invoking");
            //真正调用方法的地方
            Object ret = method.invoke(this.proxy,args);
            System.out.println(">>>>after invoking");
            return ret;
        }
    }

    //返回一个被修改过的对象
    public static Object agent(Class interfaceClazz,Object proxy){
        return Proxy.newProxyInstance(interfaceClazz.getClassLoader(),new Class[]{interfaceClazz},new MyHandler(proxy));
    }

    @Test
    public void test1(){
        System.out.println(LocalDate.now().getMonthValue());
        //注意一定要返回接口，不能返回实现类否则会报错
        //Fruit fruit = (Fruit)DynamicAgent.agent(Fruit.class,new Apple());
        //fruit.show();
    }

}
