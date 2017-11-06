package Threads;

public class BlockedMethodCallerG implements Runnable {
    private final BlockedSetExample ref;
    private final int k;

    public BlockedMethodCallerG(BlockedSetExample ref, int k) {
        this.ref = ref;
        this.k = k;
    }

    @Override
    public void run() {
        try {
            ref.g(k);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
