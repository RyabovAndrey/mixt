package Exceptions;

public class YTransactionManager implements TransactionManager {
    @Override
    public boolean transfer(Account[] accounts, int[] money) {
        try {
            for (int i = 0; i <accounts.length ; i++) {
                while (true) {
                    try {
                        accounts[i].change(money[i]);
                        break;
                    } catch (TryAgainException e) {
                        //NOP
                    }
                }
            }
        } catch (ZedDeadException e) {
            return false;
        }
        return true;
    }
}
