package Threads;

public class BlockedMethodCallerH implements Runnable {
    private final BlockedSetExample ref;
    private final int k;

    public BlockedMethodCallerH(BlockedSetExample ref, int k) {
        this.ref = ref;
        this.k = k;
    }

    @Override
    public void run() {
        try {
            ref.h(k);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
