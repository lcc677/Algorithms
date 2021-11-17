package link;

public class LinkQueue {
	public static void main(String[] args) {
		Data data1 = new Data("data1", 1);
		Data data2 = new Data("data2", 2);
		Data data3 = new Data("data3", 3);
		Data data4 = new Data("data4", 4);
		Data data5 = new Data("data5", 5);
				
		Queue queue = new Queue();
		
		queue.addQueue(data1);
		queue.addQueue(data5);
		queue.addQueue(data4);
		queue.addQueue(data2);
		queue.addQueue(data3);
		
		
		
		for (int i=0;i<7;i++) {
			try {
				System.out.println(queue.getQueue());
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		queue.addQueue(data1);
		System.out.println(queue.getQueue());
		
		
	}
	
}

class Queue{
	private Data head;
	private Data end;
	
	public Queue() {
		head = new Data("我是一个头",10);
		end = new Data("我是一个尾", -1);
	}
	
	public Data getQueue() {
		if(head.getNext() == null) {
			end.setNext(null);
			throw new RuntimeException("我这个队列空了");
		}
		Data resultData = head.getNext();
		head.setNext(head.getNext().getNext());
		return resultData;
	}
	
	public void addQueue(Data data) {
		if (end.getNext() == null) {
			head.setNext(data);
			end.setNext(data);
		}else {
			end.getNext().setNext(data);
			end.setNext(data);
		}
	}
}
