package jvmtest;

public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackleak() {
        stackLength++;
        stackleak();
    }

    public static void main(String[] args) throws Throwable{
        JavaVMStackSOF oom = new JavaVMStackSOF();

        try {
            oom.stackleak();
        } catch (Exception e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }

    }
}
