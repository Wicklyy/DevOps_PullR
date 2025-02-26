package datastruct;

public class EmptyListException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    // Constructeur sans message
    public EmptyListException() {
        super();
    }

    // Constructeur avec message
    public EmptyListException(String message) {
        super(message);
    }
}
