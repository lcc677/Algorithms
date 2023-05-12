package link;

public class Data {
	private String name;
	private int no;
	private Data next;
	private Data pre;
	
	public Data(String name, int no) {
		this.name = name;
		this.no = no;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Data getNext() {
		return next;
	}
	public void setNext(Data next) {
		this.next = next;
	}

	public Data getPre() {
		return pre;
	}

	public void setPre(Data pre) {
		this.pre = pre;
	}

	@Override
	public String toString() {
		return this.no + "";
	}

}
