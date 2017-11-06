package Exceptions;

public class ApplicationLogicException extends RuntimeException{
    public ApplicationLogicException(String message) {
        super(message);
    }

    public ApplicationLogicException(String message, Throwable cause) {
        /*
        Т.к. мы унаследовали наше исключение от RuntimeException-->Exception-->Throwable, то
        мы можем переопределить его методы.
        А один из методов выгдяжит так:
        public Throwable(String message, Throwable cause) {
            fillInStackTrace();
            detailMessage = message;
            this.cause = cause;
         }
         Здесь мы видим, что у Throwable есть аргумент cause типа Throwable.
         Т.е. мы получаем LinkedList из исключений.
         */
        super(message, cause);
    }
}
