package io.zipcoder;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.Random;

/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {

    public UnsafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
            try {
                while (stringIterator.hasNext()) {
                    int rando = (int) Math.floor(Math.random()*30);
                    String word = stringIterator.next() + " ";
                    Thread.sleep(rando);
                    copied += word;
                }
            } catch (InterruptedException e){
                System.out.println("Thread Interrupted");
                e.printStackTrace();
            }
        }
    }
