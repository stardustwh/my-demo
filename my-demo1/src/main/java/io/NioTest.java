package io;

import org.junit.Test;

import java.io.*;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class NioTest {

    @Test
    public void readNIO() {
        String pathname = "E:\\project\\my-demo\\my-demo1\\src\\main\\resources\\temp.txt";
        FileInputStream fin = null;

        try {
            fin = new FileInputStream(new File(pathname));
            FileChannel channel = fin.getChannel();

            int capacity = 100; //字节
            ByteBuffer bf = ByteBuffer.allocate(capacity);
            System.out.println("限制是：" + bf.limit() + "容量是：" + bf.capacity()
                            + "位置是:" + bf.position());
            int length = -1;

            while ((length = channel.read(bf)) != -1) {

                /**
                 * 注意，读取后，将位置置为0，将Limit置为容量，以备下次读入到字节缓冲中，从0开始存储
                 */
                bf.clear();
                byte[] bytes = bf.array();
                System.out.write(bytes, 0, length);
                System.out.println();

                System.out.println("限制是：" + bf.limit() + "容量是:" + bf.capacity()
                                + "位置是：" +bf.position());
            }

            channel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void writeNIO() {
        String filename = "out.txt";
        FileOutputStream fos = null;

        BigDecimal p1 = new BigDecimal(100);
        BigDecimal p2 = new BigDecimal(50);
        System.out.println(p1.subtract(p2));
        try {
            fos = new FileOutputStream(new File(filename));
            FileChannel channel = fos.getChannel();
            ByteBuffer src = Charset.forName("utf-8").encode("你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好");
            // 字节缓冲的容量和limit会随着数据长度变化，不是固定不变的
            System.out.println("初始容量和limit: " + src.capacity() + ","
                            + src.limit());
            int length = 0;


            while ((length = channel.write(src)) != 0) {
                /**
                 * 注意，这里不需要clear，将缓冲中的数据写入到通道后 第二次接着上一次的顺序往下读
                 */
                System.out.println("写入长度：" + length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }
}
