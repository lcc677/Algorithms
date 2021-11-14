package arry;

public class CircleArrayQueue {
	public static void main(String[] args) {
		CircleQueue circleQueue = new CircleQueue(5);
		circleQueue.addQueue(1);
		circleQueue.addQueue(2);
		circleQueue.addQueue(3);
		circleQueue.addQueue(4);
		circleQueue.addQueue(5);
		circleQueue.addQueue(6);
		
		circleQueue.showQueue();
		
		
		circleQueue.getQueue();
		circleQueue.getQueue();
		circleQueue.getQueue();
		circleQueue.getQueue();
		circleQueue.getQueue();
		try {
			circleQueue.getQueue();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println("新的+++-----------");
		circleQueue.addQueue(1);
		circleQueue.addQueue(2);
		circleQueue.getQueue();
		circleQueue.getQueue();
		
		circleQueue.showQueue();
		try {
			circleQueue.getQueue();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
	}
}

class CircleQueue{
	public int[] queue;
	public int maxSize;
	public int front;
	public int rear;
	
	public CircleQueue(int maxSize) {
		this.maxSize = maxSize;
		queue = new int[maxSize];
		front = 0;  //指向队列的头部元素  刚创建的时候，没有头部，我们指向0
		rear = -1;   //指向队列的最后一个元素  刚创建的时候，没有尾部，我们指向0
	}
	
	public boolean isFull() {
//		return rear == maxSize-1;
		
		return front + (maxSize-1) == rear;
		
	}
	
	public boolean isEmpty() {
//		return rear == front;
		return front > rear;
		
// front + (maxSize-1) = rear
	}
	
	public void addQueue(int item) {
		if(isFull()) {
			System.out.println("队列满了，不能添加元素");
		}else {
//			queue[rear] = item;
			rear ++;
			queue[rear % maxSize] = item;
			System.out.println("我插入了数据"+ item);
		}
	}
	
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("队列死空的，不能取出元素");
		}else {
			int item = queue[front%maxSize];
			front++;
			System.out.println("我取出元素" + item);
			return item;
		}	
	}
	
	public void showQueue() {
		for (int i : queue) {
			System.out.println(i);
			
		}
	}
}
