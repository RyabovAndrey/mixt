package Exceptions;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class XAccount implements Account {
    private Random rnd;
    private AtomicBoolean atm;

    public XAccount(Random rnd, AtomicBoolean atm) {
        this.rnd = rnd;
        this.atm = atm;
    }

    @Override
    public void change(int delta) throws ZedDeadException, TryAgainException {

    }
    public int getTotalChange() {
        return 0;
    }
}
