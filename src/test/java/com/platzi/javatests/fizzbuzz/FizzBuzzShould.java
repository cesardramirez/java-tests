package com.platzi.javatests.fizzbuzz;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FizzBuzzShould {
    /**
     * If the number is divisible by 3, it's "Fizz".
     * If the number is divisible by 5, it's "Buzz".
     * If the number is divisible by 3 and by 5, it's "FizzBuzz".
     */

    @Test
    public void returnFizz_whenTheNumberIsDivisibleBy3() {
        assertThat(FizzBuzz.fizzBuzz(3), is("Fizz"));
        assertThat(FizzBuzz.fizzBuzz(3627), is("Fizz"));
        assertThat(FizzBuzz.fizzBuzz(2553), is("Fizz"));
    }

    @Test
    public void returnBuzz_whenTheNumberIsDivisibleBy5() {
        assertThat(FizzBuzz.fizzBuzz(5), is("Buzz"));
        assertThat(FizzBuzz.fizzBuzz(32870), is("Buzz"));
        assertThat(FizzBuzz.fizzBuzz(7160), is("Buzz"));
    }

    @Test
    public void returnFizzBuzz_whenTheNumberIsDivisibleBy3AndBy5() {
        assertThat(FizzBuzz.fizzBuzz(15), is("FizzBuzz"));
        assertThat(FizzBuzz.fizzBuzz(2550), is("FizzBuzz"));
        assertThat(FizzBuzz.fizzBuzz(495), is("FizzBuzz"));
    }

    @Test
    public void returnNumberInString_whenTheNumberIsNotDivisibleBy3OrBy5() {
        assertThat(FizzBuzz.fizzBuzz(7), is("7"));
        assertThat(FizzBuzz.fizzBuzz(2), is("2"));
        assertThat(FizzBuzz.fizzBuzz(16), is("16"));
    }
}