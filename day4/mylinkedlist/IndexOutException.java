package day4.mylinkedlist;

public class IndexOutException extends RuntimeException{
    public IndexOutException() {
        super();
    }

    public IndexOutException(String message) {
        super(message);
    }
}
