package think;

//The full process of initialization.初始化的整个过程


class Insect {
    private int i = 9;
    protected int j;
    Insect() {
        System.out.print("i = " +i+",j="+j);
        j = 39;
    }
    private static int x1 =
            printInit("static Insect.x1 initalized");
    static int printInit(String s) {
        System.out.print(s);
        return 47;
    }
}
public class Beetle extends Insect{
    private int k = printInit("Beetle.k initialized");
    public Beetle(){
        System.out.print("k = "+ k);
        System.out.print("j = " + j);
    }
    private static int x2 =
            printInit("static Beetle.x2 initialized");
    public static void main(String[] args){
        System.out.print("Beetle constructor");
        Beetle b = new Beetle();
    }
}
