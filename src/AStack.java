/**
 * A class designed to implement stacks
 * @author brettnelson
 *
 * @param <T>
 */

public class AStack<T> {

	private T[] arr;
	private int top;
	
	public static class MyException extends RuntimeException{
		public MyException(){
			super();
		}
		
		public MyException(String s){
			super(s);
		}
	}
	
	public AStack(int x){
		arr = (T[]) new Object[x];
		top = -1;
	}
	
	public void push(T value){
		top++;
		if(top < arr.length - 1){
			arr[top] = value;
		}
		else{
			T[] store = arr;
			arr = (T[]) new Object[arr.length*2];
			for(int i = 0; i < store.length; i++){
				arr[i] = store[i];
			}
			arr[top] = value;
		}
	}
	
	public T pop(){
		
		if(isEmpty()){
			throw new MyException("This array is empty");
		}
		else{
			T store = arr[top];
			arr[top] = null;
			top--;
			return store;
		}
	}
	
	public int getSize(){
		return top+1;
	}
	
	public T peek(){
		
		if(isEmpty()){
			throw new MyException("This array is empty");
		}
		else{
			return arr[top];
		}
	}
	
	public boolean isEmpty(){
		
		if(top<0)
			return true;
		else
			return false;
	}
}//close class
