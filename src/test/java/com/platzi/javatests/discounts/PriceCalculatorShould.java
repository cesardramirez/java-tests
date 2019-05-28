package com.platzi.javatests.discounts;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class PriceCalculatorShould {

    @Mock
    PriceCalculator calculator;

    @Before
    public void setUp() {
        calculator = new PriceCalculator();
    }

    @Test
    public void totalZero_whenThereAreNotPrices() {
        assertThat(calculator.getTotal(), is(0.0));
    }

    @Test
    public void totalIsTheSumOfThePrices() {
        calculator.addPrice(10.2);
        calculator.addPrice(15.5);

        assertThat(calculator.getTotal(), is(25.7));
    }

    @Test
    public void applyDiscountToPrices() {
        calculator.addPrice(100);
        calculator.addPrice(50);
        calculator.addPrice(50);

        calculator.setDiscount(25);

        assertThat(calculator.getTotal(), is(150.0));
    }
}