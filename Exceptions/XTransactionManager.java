package Exceptions;

public class XTransactionManager implements TransactionManager{

    @Override
    public boolean transfer(Account[] accounts, int[] money) {
        for (int i = 0; i <accounts.length ; i++) {
            try {
                accounts[i].change(money[i]);
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
}
