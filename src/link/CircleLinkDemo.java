package link;

/**
 * description: CircleLinkDemo
 * date: 2021/11/16 下午7:04
 * author: cc
 */
public class CircleLinkDemo {
    public static void main(String[] args) {
        CircleNode node1 = new CircleNode(1, "1");
        CircleNode node2 = new CircleNode(2, "2");
        CircleNode node3 = new CircleNode(3, "3");
        CircleNode node4 = new CircleNode(4, "4");

        CircleLink circleLink = new CircleLink();
        circleLink.add(node1);
        circleLink.add(node2);
        circleLink.add(node3);
        circleLink.add(node4);

        circleLink.show();

        CircleLink2 circleLink2 = new CircleLink2();
        circleLink2.add(node1);
        circleLink2.add(node2);
        circleLink2.add(node3);
        circleLink2.add(node4);
        circleLink2.show();
    }

}

/**
 * 包含一个不在还内的头结点.
 * 我们的头结点不在环内,所以我们真正的数据的开头是在head.next上.
 */
class CircleLink {
    private CircleNode head;

    public CircleLink() {
        this.head = new CircleNode(0, "0");
    }

    public void add(CircleNode node) {
        if(head.getNext() == null){
            head.setNext(node);
            node.setNext(node);
        }else{
            CircleNode temp = head.getNext();
            while (!temp.getNext().equals(head.getNext())) {
                temp = temp.getNext();
            }
            temp.setNext(node);
            node.setNext(head.getNext());
        }
    }

    public void show() {
        CircleNode temp = head.getNext();
        // 我要循环temp,直到我的temp的next等于我第一个节点(即head.getNext)
        // 我们不能使用temp!=head.getNext() 因为初始化,我们的temp就是head.getNext(),所以第一步,他就不符合条件,就不会进while循环内.
        // 但是我们用temp.getNext() != head.getNext().当我们程序结束的时候,我们最后一个元素没有进循环内,所以打印不出来.我们需要在最后打印一下
        while (temp.getNext() != head.getNext()) {
            System.out.println(temp);
            temp = temp.getNext();
        }
        System.out.println(temp);
    }
}


/**
 * 不包含头结点的
 * 我们真正的数据的开头就是在head上.
 */
class CircleLink2 {
    private CircleNode head;

    public void add(CircleNode node) {
        if(head == null){
            head = node;
            head.setNext(head);
        }else{
            CircleNode temp = head.getNext();
            while (!temp.getNext().equals(head)) {
                temp = temp.getNext();
            }
            temp.setNext(node);
            node.setNext(head);
        }
    }

    public void show() {
        CircleNode temp = head;
        // 我要循环temp,直到我的temp的next等于我第一个节点(即head)
        while (temp.getNext() != head) {
            System.out.println(temp);
            temp = temp.getNext();
        }
        System.out.println(temp);
    }
}

class CircleNode {
    private int no;
    private String name;
    private CircleNode next;

    public CircleNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CircleNode getNext() {
        return next;
    }

    public void setNext(CircleNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "CircleNode{" + "no=" + no + ", name='" + name + '\'' + '}';
    }
}