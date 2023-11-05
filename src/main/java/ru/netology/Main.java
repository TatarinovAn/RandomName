package ru.netology;

import java.util.Random;

import static ru.netology.Tools.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }

        Thread palindrome = new Thread(() -> {
            for (String word : texts) {
                if (isItPalindrome(word) && !isItOneLetters(word)) {
                    incrementCounter(word.length());
                }
            }
        });
        palindrome.start();


        Thread oneLetters = new Thread(() -> {
            for (String word : texts) {
                if (isItOneLetters(word)) {
                    incrementCounter(word.length());
                }
            }
        });

        oneLetters.start();

        Thread increase = new Thread(() -> {
            for (String word : texts) {
                if (isItIncrease(word)) {
                    incrementCounter(word.length());
                }
            }
        });
        increase.start();


        palindrome.join();
        oneLetters.join();
        increase.join();

        System.out.println("Красивых слов с длиной 3: " + countOne + "\n" +
                "Красивых слов с длиной 4: " + countTwo + "\n" +
                "Красивых слов с длиной 5: " + countThree + "\n");

    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }
}