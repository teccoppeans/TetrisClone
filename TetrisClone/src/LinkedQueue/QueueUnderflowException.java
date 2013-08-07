package LinkedQueue;

public class QueueUnderflowException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1433095954537773319L;

	QueueUnderflowException() {
		super();
	}
	
	QueueUnderflowException(String message) {
		super(message);
	}
}
