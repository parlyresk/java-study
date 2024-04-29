package prob5;

public class MyStack02 {
	int top=0;
	
	Object[] buffer;

	public MyStack02(int size) {
		
		this.buffer=new String[size];
	}
	public void resize() {
		int size=buffer.length;
		Object[] temp=new Object[size*2];
		for(int i=0;i<size;i++) {
			temp[i]=buffer[i];
		}
		buffer=temp;
		return;
	}
	public void push(Object string) throws MyStackException {
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

	public Object pop() throws MyStackException{
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new MyStackException("Stack is empty");
		}
		return buffer[--top];
	}
}