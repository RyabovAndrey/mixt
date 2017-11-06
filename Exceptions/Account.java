package Exceptions;

public interface Account {
    public void change(int delta) throws ZedDeadException, TryAgainException;
}
