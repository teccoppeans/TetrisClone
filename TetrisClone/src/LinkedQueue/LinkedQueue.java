package LinkedQueue;

public class LinkedQueue<T> implements LinkedQueueInterface<T> {

	Node<T> rear;

	public LinkedQueue() {
		rear = null;
	}
	
	public LinkedQueue(T object) {
		rear = new Node<T>(object);
		rear.setNext(rear);
	}
	
	@Override
	public void add(T object) {
		// TODO Auto-generated method stub
		if (rear == null) {
			rear = new Node<T>(object);
			rear.setNext(rear);
		}
		else {
			Node<T> temp = new Node<T>(object);
			temp.setNext(rear.getNext());
			rear.setNext(temp);
			rear = temp;
		}
	}
	
	@Override
	public T remove() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		T data;
		if (rear == null)
			throw new QueueUnderflowException();
		Node<T> first = rear.getNext();
		if (rear.getNext() == rear) {
			data = rear.getValue();
			rear = null;
		}
		else {
			data = first.getValue();
			rear.setNext(first.getNext());
		}
		
		return data;
	}

	@Override
	public T examine() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		if (rear == null)
			throw new QueueUnderflowException();
		return rear.getNext().getValue();
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return rear == null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		rear = null;
	}
	
	public String toString() {
		String s = "";
		Node<T> current;
		try {
		current = rear.getNext();
		} 
		catch (NullPointerException e) {
			return s;
		}
		do {
			s += current.getValue();
			current = current.getNext();
		} while (current != rear.getNext());
		
		return s;
}
	
}
