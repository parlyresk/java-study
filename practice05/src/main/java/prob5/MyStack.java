package prob5;

public class MyStack {
	int top=0;
	
	String[] buffer;

	public MyStack(int size) {
		
		this.buffer=new String[size];
	}
	public void resize() {
		int size=buffer.length;
		String[] temp=new String[size*2];
		for(int i=0;i<size;i++) {
			temp[i]=buffer[i];
		}
		buffer=temp;
		return;
	}
	public void push(String string) throws MyStackException {
		// TODO Auto-generated method stub
		if(top+1>=buffer.length) {
			resize();
		}
		
		buffer[top++]=string;
		return;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		
		return top==0;
	}

	public String pop() throws MyStackException{
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new MyStackException("Stack is empty");
		}
		return buffer[--top];
	}
}