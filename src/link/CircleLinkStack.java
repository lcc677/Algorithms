package link;

public class CircleLinkStack {
	public static void main(String[] args) {
		Data data1 = new Data("data1", 1);
		Data data2 = new Data("data2", 2);
		Data data3 = new Data("data3", 3);
		Data data4 = new Data("data4", 4);
		Data data5 = new Data("data5", 5);
		
		Stack stack = new Stack();
		stack.pushStack(data1);
		stack.pushStack(data2);
		stack.pushStack(data3);
		stack.pushStack(data4);
		stack.pushStack(data5);
		
		for(int i=0;i<7;i++) {
			try {
				System.out.println(stack.popStack());
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}catch (Exception e) {
				System.out.println(e);
			}
		}
		stack.pushStack(data5);
		System.out.println(stack.popStack());
		System.out.println(stack.popStack());
		
	}
}

class CircleStack{
	Data head;
		
	public void pushStack(Data data) {
		if(head == null) {
			head = data;
		}else {
			Data temp = head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(data);
			data.setPre(temp);
		}
	}
	
	public Data popStack() {
		if(head == null) {
			throw new RuntimeException("栈空了");
		}		
		Data temp = head;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.getPre().setNext(null);
		return temp;
		
		
		
	}
}

