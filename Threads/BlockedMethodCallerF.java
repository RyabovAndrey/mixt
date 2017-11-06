package Threads;

public class BlockedMethodCallerF implements Runnable {
    private final BlockedSetExample ref;
    private final int k;

    public BlockedMethodCallerF(BlockedSetExample ref, int k) {
        this.ref = ref;
        this.k = k;
    }

    @Override
    public void run() {
        try {
            ref.f(k);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
