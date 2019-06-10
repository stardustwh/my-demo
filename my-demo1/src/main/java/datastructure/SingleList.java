package datastructure;

public class SingleList<E> {

    private class Node{
        public E val;
        public Node next;

        public Node(E val,Node next){
            this.next=next;
            this.val=val;
        }
        public Node(E val){
            this(val,null);
        }
        public Node(){
            this(null);
        }

        @Override
        public String toString(){
            return val.toString();
        }

    }

    private Node dummyHead;//虚拟的头结点
    private int size;//表示链表当前元素

    public SingleList(){
        dummyHead= new Node();
        size=0;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void rangeCheck(int index){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("Index is Illegal!");
        }
    }

    //insert
    public void add(int index,E e){
        if(index<0||index>size){
            throw new IllegalArgumentException("Index is Illegal!");
        }
        Node prev = dummyHead;//设置虚拟头结点的目的是 为了插入和删除的方便（不需要判断第一个和最后一个位置）
        for(int i =0;i<index;i++) {
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
        size++;

    }
    public void addFirst(E e){
        add(0,e);
    }
    public void addLast(E e){
        add(size,e);
    }

    //获取
    public E get(int index){
        rangeCheck(index);
        Node cur = dummyHead.next;
        for(int i =0; i<index;i++){
            cur = cur.next;
        }
        return cur.val;
    }
    public E getFirst(){
        return get(0);
    }
    public E getLast(){
        return get(size -1);
    }

    //remove
    public E remove(int index){
        rangeCheck(index);
        Node prev = dummyHead;
        for(int i=0; i<index; i++){
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.val;
    }
    public E removeFirst(){
        return remove(0);
    }
    public E removeLast(){
        return remove(size -1);
    }

    public void set(int index,E e){
        rangeCheck(index);
        Node cur = dummyHead.next;
        for(int i =0;i<index; i++){
            cur = cur.next;
        }
        cur.val=e;

    }

    public boolean contains(E e){
        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.val.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void removeElement(E e){
        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.val.equals(e)){
                break;
            }
            prev = prev.next;
        }
        if(prev.next!=null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while(cur!=null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    //for test
    public static void main(String[] args) {
        SingleList<Integer> singleList = new SingleList<>();
        for(int i = 0 ; i < 5 ; i ++){
            singleList.addFirst(i);//头插
        }
        System.out.println(singleList);

        singleList.add(2, 666);
        System.out.println(singleList);

        singleList.remove(2);
        System.out.println(singleList);

        singleList.removeFirst();
        System.out.println(singleList);

        singleList.removeLast();
        System.out.println(singleList);

        singleList.removeElement(2);
        System.out.println(singleList);

        System.out.println(singleList.contains(3));

        singleList.set(1,999);
        System.out.println(singleList);

        singleList.addLast(888);
        System.out.println(singleList);

        System.out.println(singleList.getFirst() +" " +  singleList.getLast());
        System.out.println(singleList.size());
    }
    
}
