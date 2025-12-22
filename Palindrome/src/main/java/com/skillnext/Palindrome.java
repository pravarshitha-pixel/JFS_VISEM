package com.skillnext;

import java.util.Scanner;   // <-- THIS LINE IS MISSING

public class Palindrome {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String reversed = new StringBuilder(text).reverse().toString();

        if (text.equals(reversed)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
    }
}
