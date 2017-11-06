package Exceptions;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class TestTransactionManager {
    public static void main(String[] args) {
        for (int k = 0; k <1000000 ; k++) {
            final Random rnd=new Random(k);
            TransactionManager manager=new YTransactionManager();
            final AtomicBoolean zedDead=new AtomicBoolean(false);
            XAccount[] accounts={
                    new XAccount(rnd,zedDead),
                    new XAccount(rnd,zedDead),
                    new XAccount(rnd,zedDead)};
            int[] money={-1,-1,2};
            boolean ok=manager.transfer(accounts,money);
            if (ok) {
                for (int i = 0; i <accounts.length ; i++) {
                    if (accounts[i].getTotalChange()!=money[i]) {
                        throw new AssertionError(" ");
                    }
                }
            }
            else {
                if (!zedDead.get()) {
                    throw new AssertionError("Zed alive but rollback");
                }
                for (int i = 0; i <accounts.length ; i++) {
                    if (accounts[i].getTotalChange()!=money[i]) {
                        throw new AssertionError(" ");
                    }
                }
                
            }
        }
    }
}
