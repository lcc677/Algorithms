package link;

public class JosephusDemo {
	public static void main(String[] args) {
		int number = 10;
		int step = 3;
		Josephus josephus = new Josephus();
		for(int i=0;i<number;i++) {
			Persion persion = new Persion(i+1);
			josephus.add(persion);
		}
		int[] result = josephus.solution(step, number);
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]);
		}
		
		
		
	}
}

class Josephus{
	Persion head;
	
	public void add(Persion persion) {
		if(head == null) {
			head = persion;
			head.setNext(head);
		}else {
			Persion temp = head;
			while(temp.getNext() != head) {
				temp = temp.getNext();
			}
			temp.setNext(persion);
			persion.setNext(head);
		}
	}
	public int[] solution(int step,int number) {
		int[] result = new int[number];
		Persion temp = head;
		int index = 1;
		int i = 0;
		while(temp.getNext() != temp) {
			if(index == step-1) {
				result[i] = temp.getNext().getNo();
				temp.setNext(temp.getNext().getNext());
				i++;
				index = 0;
			}
			index++;
			temp = temp.getNext();
		}
		result[i] = temp.getNo();
		return result;
		
	}
}

class Persion{
	private int no;
	private Persion next;
	
	public Persion(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Persion getNext() {
		return next;
	}

	public void setNext(Persion next) {
		this.next = next;
	}
	
	
}