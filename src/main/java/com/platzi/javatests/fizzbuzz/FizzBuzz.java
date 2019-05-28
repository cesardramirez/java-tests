package com.platzi.javatests.fizzbuzz;

public class FizzBuzz {

    public static String fizzBuzz(int num) {
        /*
        if (num % 3 == 0 && num % 5 == 0) return "FizzBuzz";
        if (num % 3 == 0) return "Fizz";
        if (num % 5 == 0) return "Buzz";
        return String.valueOf(num);
        */
        return num % 3 == 0 && num % 5 == 0 ? "FizzBuzz" : num % 3 == 0 ? "Fizz" : num % 5 == 0 ? "Buzz" : String.valueOf(num);
    }
}
