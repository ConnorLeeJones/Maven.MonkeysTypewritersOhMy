package io.zipcoder;

import sun.text.resources.vi.CollationData_vi;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {
    private final ReentrantLock lock = new ReentrantLock();

    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        synchronized (lock) {
            while (stringIterator.hasNext()) {
                this.lock.lock();
                String word = stringIterator.next() + " ";
                copied += word;
                this.lock.unlock();
            }
        }
    }
}
