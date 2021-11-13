package queue;

public class ArrayQueue {
	public static void main(String[] args) {
		Queue queue = new Queue(5);
		queue.addQueue(1);
		queue.addQueue(2);
		queue.addQueue(3);
		queue.addQueue(4);
		queue.addQueue(5);
		queue.addQueue(6);
		queue.showQueue();
		System.out.print(queue.headQueue());
		try {
			queue.getQueue();
			queue.getQueue();
			queue.getQueue();
			queue.getQueue();
			queue.getQueue();
			queue.getQueue();
			queue.getQueue();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		queue.addQueue(6);
	}
}

class Queue{
	int[] queue;
	int front;
	int rear;
	int maxSize;
	public Queue(int maxSize) {
		this.maxSize = maxSize;
		queue = new int[maxSize];
		front = -1;
		rear = -1;
	}
	public boolean isEmpty() {
		return front == rear;
	}
	
	public boolean isFull() {
		return rear +1 == maxSize;
	}
	
	public void addQueue(int item) {
		if(isFull()) {
			System.out.println("队列满了！！");
		}else {
			queue[++rear] = item;
		}
	}
	
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("队列空了，不能取数据");
		}else {
			return queue[++front];
		}
	}
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("队列是空的");
		}else {
			for (int i = 0; i < queue.length; i++) {
				System.out.printf("arry[%d] = %d\n", i,queue[i]);
			}
		}
		
	}
	public int headQueue() {
		if(isEmpty()) {
			throw new RuntimeException("队列空了，不能取数据");
		}else {
			return queue[front+1];
		}
		
	}
}
