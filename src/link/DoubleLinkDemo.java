package link;

/**
 * description: DoubleLink
 * date: 2021/11/15 下午8:15
 * author: cc
 */
public class DoubleLinkDemo {
    public static void main(String[] args) {
        DoubleNode node1 = new DoubleNode(1,"node1");
        DoubleNode node2 = new DoubleNode(2,"node2");
        DoubleNode node3 = new DoubleNode(3,"node3");
        DoubleNode node4 = new DoubleNode(4,"node4");
        // 创建链表
        DoubleLink doubleLink = new DoubleLink();
//        doubleLink.add(node1);
//        doubleLink.add(node2);
//        doubleLink.add(node3);
//        doubleLink.add(node4);
        
	    doubleLink.addSort(node1);
	    doubleLink.addSort(node3);
	    doubleLink.addSort(node2);
	    doubleLink.addSort(node4);
	    doubleLink.addSort(node4);
        doubleLink.del(node2);
        doubleLink.showList();

    }
}

class DoubleLink{
    DoubleNode head = new DoubleNode(0,"");

    public void add(DoubleNode node){
        DoubleNode temp = head;
        while (temp.getNext() != null){
            temp = temp.getNext();
        }
        temp.setNext(node);
        node.setPre(temp);
    }
    
    public void addSort(DoubleNode node) {
    	DoubleNode temp = head;
    	boolean flag = false;
    	while (temp.getNext() != null) {
			if(temp.getNext().getNo() > node.getNo()) {
				break;
			}
			if(temp.getNext().getNo() == node.getNo()) {
				flag = true;
				break;
			}
			temp = temp.getNext();
		}
    	if(flag) {
    		System.out.printf("链表已经存在元素%d\n", node.getNo());
    	}else {
    		node.setNext(temp.getNext());
    		if(temp.getNext()!=null) {
    			temp.getNext().setPre(node);
    		}
    		temp.setNext(node);
    		node.setPre(temp);    		
    	}
    }
    
    public void del(DoubleNode node){
        DoubleNode temp = head;
        while (temp!=null){
            if(temp.getNo() == node.getNo()){
                break;
            }
            temp = temp.getNext();
        }
        if(temp!=null){
            temp.getPre().setNext(temp.getNext());
            if(temp.getNext()!=null) {
                temp.getNext().setPre(temp.getPre());
            }
        }
    }
    public void showList(){
        DoubleNode temp = head.getNext();
        while (temp!=null){
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}


class DoubleNode {
    private int no;
    private String name;
    private DoubleNode next;
    private DoubleNode pre;

    public DoubleNode(int no, String name) {
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

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public DoubleNode getPre() {
        return pre;
    }

    public void setPre(DoubleNode pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "DoubleNode [no=" + no + ", name=" + name +"]";
    }

}