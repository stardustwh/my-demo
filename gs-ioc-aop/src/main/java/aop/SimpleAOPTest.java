package aop;

import org.junit.Test;

public class SimpleAOPTest {

    @Test
    public void getProxy() throws Exception {
        //1.创建一个MethodInvocation 实现类
        MethodInvocation logTask = () ->System.out.println("log task start");
        HelloServiceImpl helloServiceImpl = new HelloServiceImpl();

        //2.创建一个Advice
        Advice beforeAdvice = new BeforeAdvice(helloServiceImpl,logTask);

        //3.为目标对象生成代理
        HelloService helloServiceImplProxy = (HelloService)SimpleAOP.getProxy(helloServiceImpl,beforeAdvice);

        helloServiceImplProxy.sayHelloWorld();
    }
}
