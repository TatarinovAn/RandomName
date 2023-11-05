package ru.netology;

import java.util.concurrent.atomic.AtomicInteger;

public class Tools {
    static AtomicInteger countOne = new AtomicInteger(0);
    static AtomicInteger countTwo = new AtomicInteger(0);
    static AtomicInteger countThree = new AtomicInteger(0);

    static public boolean isItPalindrome(String text) {
        return text.equals(new StringBuilder(text).reverse().toString());
    }

    static public boolean isItOneLetters(String text) {
        for (int i = 0; i < text.length() - 1; i++) {
            if (text.charAt(i) != text.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    static public boolean isItIncrease(String text) {
        for (int i = 0; i < text.length() - 1; i++) {
            if (text.charAt(i) > text.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    static public void incrementCounter(int length) {
        if (length == 3) {
            countOne.getAndIncrement();
        } else if (length == 4) {
            countTwo.getAndIncrement();
        } else {
            countThree.getAndIncrement();
        }
    }
}
