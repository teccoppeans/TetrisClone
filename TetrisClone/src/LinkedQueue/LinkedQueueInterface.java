package LinkedQueue;

public interface LinkedQueueInterface<T> {
	
	public void add(T object);
	public T remove() throws QueueUnderflowException;
	public T examine() throws QueueUnderflowException;
	public boolean isEmpty();
	public void clear();
	
}
