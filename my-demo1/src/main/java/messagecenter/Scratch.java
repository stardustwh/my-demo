package messagecenter;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 单机版消息中心
 */
public class Scratch {

    public static void main(String[] args){
        //实际中会有nameserver 服务来找到broker 具体位置以及broker主从信息
        Broker broker = new Broker();
        Producer producer1 = new Producer();
        producer1.connectBroker(broker);
        Producer producer2 = new Producer();
        producer2.connectBroker(broker);

        Consumer consumer1 = new Consumer();
        consumer1.connectBroker(broker);
        Consumer consumer2 = new Consumer();
        consumer2.connectBroker(broker);

        for(int i = 0;i<2;i++){
            producer1.asyncSendMsg("producer1 send msg"+i);
            producer2.asyncSendMsg("producer2 send msg"+i);
        }
        System.out.println("broker has msg:"+ broker.getAllMagByDisk());

        for(int i = 0;i<1;i++){
            System.out.println("consumer1 consume msg:"+consumer1.syncPullMsg());
        }
        for(int i = 0;i<3;i++){
            System.out.println("consumer2 consume msg:"+consumer2.syncPullMsg());
        }
    }

}

class Producer {

    private Broker broker;

    public void connectBroker(Broker broker){
        this.broker = broker;
    }

    public void asyncSendMsg(String msg){
        if(broker == null){
            throw new RuntimeException("please connect broker first");
        }
        new Thread(() -> {
            broker.sendMessage(msg);
        }).start();
    }


}

class Consumer {
    private Broker broker;

    public void connectBroker(Broker broker){
        this.broker = broker;
    }

    public String syncPullMsg(){
        return broker.getMsg();
    }
}

class Broker {

    //对应RocketMQ中MessageQueue,默认情况下1个topic包含4个MessageQueue
    private LinkedBlockingQueue<String> messageQueue = new LinkedBlockingQueue<>(Integer.MAX_VALUE);

    //实际发送消息到 broker 服务器使用netty发送
    public void sendMessage(String msg){
        try {
            messageQueue.put(msg);
            //实际会同步或异步落盘，异步落盘使用的定时任务定时扫描落盘
        } catch (InterruptedException e) {

        }

    }

    public String getMsg(){

        try {
            return messageQueue.take();
        } catch (InterruptedException e) {

        }
        return null;
    }

    public String getAllMagByDisk(){
        StringBuilder sb = new StringBuilder("\n");
        messageQueue.iterator().forEachRemaining((msg) -> {
            sb.append(msg +"\n");
        });
        return sb.toString();
    }

}
