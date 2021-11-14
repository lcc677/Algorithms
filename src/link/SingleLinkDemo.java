package link;


public class SingleLinkDemo {
	public static void main(String[] args) {
		// 创建一些节点
		Node node1 = new Node(1, "node1");
		Node node2 = new Node(2, "node2");
		Node node3 = new Node(3, "node3");
		Node node4 = new Node(4, "node4");
		
		// 创建一个链表
		SingleLink singleLink = new SingleLink();
//		singleLink.add(node1);
//		singleLink.add(node2);
//		singleLink.add(node3);
//		singleLink.add(node4);
		
		
		singleLink.addBySort(node1);
		singleLink.addBySort(node3);
		singleLink.addBySort(node2);
		singleLink.addBySort(node4);
		singleLink.addBySort(node4);
		
		node1.setName("node1update");
		singleLink.update(node1);
		
		singleLink.delete(4);
		singleLink.delete(1);
		singleLink.list();
		
	}
}

class SingleLink {
	Node head = new Node(0, null);
	
	/**
	 * 单纯的向链表的最后面添加
	 * @param node
	 */
	public void add(Node node) {
		Node temNode = head ;
		// 查找 链表中的最后一个元素，并将最后一个元素的nextNode设置成添加的节点
		// 当我们的我们的节点的nextNode是空的时候，tempNode就是我们想要的最后的节点
		while (temNode.getNextNode()!=null) {
			temNode = temNode.getNextNode();
		}
		temNode.setNextNode(node);
	}
	public void delete(int no) {
		Node tempNode = head;
		boolean flag = false; // 判断是否存在元素
		while (tempNode != null) {
			if(tempNode.getNextNode().getNo() == no) {
				flag = true;
				break;
			}
			tempNode = tempNode.getNextNode();
		}
		if(!flag) {
			System.out.printf("链表中没有要删除的元素%d\n",no);
		}else {
			tempNode.setNextNode(tempNode.getNextNode().getNextNode());
		}
		
	}
	public void update(Node node) {
		Node tempNode = head;
		boolean flag = false; // 判断是否存在元素
		while (tempNode != null) {
			if(tempNode.getNo() == node.getNo()) {
				flag = true;
				break;
			}
			tempNode = tempNode.getNextNode();
		}
		if(flag) {
			tempNode.setName(node.getName());
		}else {
			System.out.printf("链表中不存在%d元素，修改不成功", node.getNo());
		}
		
		
	}
	/**
	 * 插入链表中的时候，是有顺序的
	 * @param node
	 */
	public void addBySort(Node node) {
		Node tempNode = head;
		boolean flag = false;
		while (tempNode.getNextNode()!=null) {
			if(tempNode.getNextNode().getNo() == node.getNo()) {
				flag = true;
				break;
			}
			if(tempNode.getNextNode().getNo() > node.getNo()) {
				break;
			}
			tempNode = tempNode.getNextNode();
		}
		if(flag) {
			System.out.printf("链表中已经存在了%d元素，不能添加了\n",node.getNo());
		}else {
			node.setNextNode(tempNode.getNextNode());
		}
		tempNode.setNextNode(node);
	}
	
	public void list() {
		if(head.getNextNode() == null) {
			System.out.println("链表是空的！！");
		}else {
			Node tempNode = head.getNextNode();
			while (tempNode!=null) {
				System.out.println(tempNode);
				tempNode = tempNode.getNextNode();
			}
		}
	}
}

class Node {
	private int no;
	private String name;
	private Node nextNode;
	
	public Node(int no, String name) {
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
	public Node getNextNode() {
		return nextNode;
	}
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	@Override
	public String toString() {
		return "Node [no=" + no + ", name=" + name +"]";
	}
	
	
	
	
}