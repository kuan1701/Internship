package com.internship.project.intexsoft.service.impl;

import com.internship.project.intexsoft.service.ThingService;
import com.internship.project.intexsoft.util.NumbersStorageService;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public final class ThingServiceImpl implements ThingService {

    private static final String AVERAGE_FORMAT = "%.2f";
    private static final String LARGEST_NUMBER = " is the largest number it has encountered so far.";
    private static final String SMALLEST_NUMBER = " is the smallest number it has encountered so far.";
    private static final String AVERAGE_NUMBER = " is the average of all numbers it has encountered so far.";

    private static final NumbersStorageService numbersStorageService = new NumbersStorageService();
    private static final List<Integer> numbers = numbersStorageService.readNumbers();
    private static Integer number;

    public ThingServiceImpl()
    {
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        initThingMessage();
    }

    /**
     * Here we are assigning values to the fields of entity Thing
     * and checking the entered number and saving it in the array
     */
    public void initThingMessage()
    {

        numbers.add(number);

        if (numbers.size() == 1)
        {
            printResultForOneNumber();
        }
        else
        {
            Integer min = Collections.min(numbers);
            Integer max = Collections.max(numbers);

            printResultForMultipleNumbers(min, max);
        }
        numbersStorageService.writeNumbers(numbers);
    }

    private static void printResultForOneNumber()
    {
        System.out.println(number + LARGEST_NUMBER);
        System.out.println(number + SMALLEST_NUMBER);
        System.out.println(getAverageNumber() + AVERAGE_NUMBER);
    }

    private static void printResultForMultipleNumbers(Integer min, Integer max)
    {
        if (min < number && number < max)
        {
            String result = String.format(AVERAGE_FORMAT, getAverageNumber());
            System.out.println(result + AVERAGE_NUMBER);
        }
        else
        {
            String answer = (min > number) ?
                    (number + SMALLEST_NUMBER) : (number + LARGEST_NUMBER);
            System.out.println(answer);
        }
    }

    /**
     * Calculate the average of all the numbers in the array
     */
    public static Double getAverageNumber()
    {
        return numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    /**
     * Displaying all numbers in an array
     */
    @Override
    public void printNumbers()
    {
        System.out.println(numbersStorageService.readNumbers());
    }
}
