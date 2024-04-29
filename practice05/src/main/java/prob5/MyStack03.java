package prob5;

public class MyStack03<T> {
	int top=0;
	
	T[] buffer;

	@SuppressWarnings("unchecked")
	public MyStack03(int size) {
		
		this.buffer=(T[])new Object[size];
		
	}
	@SuppressWarnings("unchecked")
	public void resize() {
		int size=buffer.length;
		Object[] temp=new Object[size*2];
		for(int i=0;i<size;i++) {
			temp[i]=buffer[i];
		}
		buffer=(T[]) temp;
		return;
	}
	public void push(T string) throws MyStackException {
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

	public T pop() throws MyStackException{
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new MyStackException("Stack is empty");
		}
		return buffer[--top];
	}
}