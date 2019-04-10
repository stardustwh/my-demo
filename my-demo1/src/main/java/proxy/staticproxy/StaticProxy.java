package proxy.staticproxy;

import org.junit.Test;

/**
 * 代理模式实现——静态代理
 */
interface Person {
    void speak();
}

class Actor implements Person {
    private String content;
    public Actor(String content){
        this.content = content;
    }

    @Override
    public void speak() {
        System.out.println(this.content);
    }
}

class Agent implements Person {
    private Actor actor;
    private String before;
    private String after;
    public Agent (Actor actor,String before,String after) {

        this.actor = actor;
        this.before = before;
        this.after = after;

    }
    @Override
    public void speak() {

        System.out.println("Before actor speak,DynamicAgent say:" +before);
        this.actor.speak();
        System.out.println("After actor speak,DynamicAgent say:" + after);
    }

}
public class StaticProxy {

    @Test
    public void test(){
        Actor actor = new Actor("I am a famous actor!");
        Agent agent = new Agent(actor,"Hello I am a agent!","that's all!");
        agent.speak();
    }
}
