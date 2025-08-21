package org.example;

import java.util.Scanner;

public class Main {
    public static int countVowels(String str){

        int count = 0;
        String vowels = "aeiouAEIOU";

        for(char ch : str.toCharArray()){
            if(vowels.indexOf(ch) != -1){
                count++;
            }
        }

        return count;

    }

    public static int countConsonants(String str){
        int count = 0;
        for(char ch : str.toLowerCase().toCharArray()){
            if (Character.isLetter(ch) && "aeiou".indexOf(ch) == -1) {
                count++;
            }
        }
        return  count;
    }

    public static String replaceCharacter(String str, char oldChar, char newChar){
        return str.replace(oldChar, newChar);
    }

    public static boolean isPalindrome(String str){
        String cleaned = str.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();

        return cleaned.equals(reversed);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String str = sc.nextLine();

         int vowels = countVowels(str);
         int consonants = countConsonants(str);

        System.out.println("Number of vowels: " + vowels);
        System.out.println("Number of consonants: " + consonants);

        System.out.println("Enter a character to replace: ");
        char oldChar = sc.next().charAt(0);
        System.out.print("Enter replacement character: ");
        char newChar = sc.next().charAt(0);

        String replaced = replaceCharacter(str, oldChar, newChar);
        System.out.println("String after replacement: " + replaced);


        if(isPalindrome(str)){
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }
}