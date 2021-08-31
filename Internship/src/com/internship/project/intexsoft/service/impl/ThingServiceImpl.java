package com.internship.project.intexsoft.service.impl;

import com.internship.project.intexsoft.model.Thing;
import com.internship.project.intexsoft.service.ThingService;
import com.internship.project.intexsoft.util.NumbersStorageService;

import java.util.List;
import java.util.Scanner;

public final class ThingServiceImpl implements ThingService {

    private final String SMALLEST_NUMBER = " is the smallest number it has encountered so far.";
    private final String LARGEST_NUMBER = " is the largest number it has encountered so far.";
    private final String AVERAGE_NUMBER = " is the average of all numbers it has encountered so far.";

    Scanner scanner = new Scanner(System.in);
    private final Integer number = scanner.nextInt();

    NumbersStorageService numbersStorageService = new NumbersStorageService();

    /**
     * Checking the entered number and saving it in the array
     */
    @Override
    public void getThingMessage(Thing thing) {

        thing.getNumbers().add(number);
        numbersStorageService.writeNumbers(thing.getNumbers());

        if (thing.getMinNumber() != null && thing.getMaxNumber() != null && thing.getAvgNumber() != null) {

            String answer = (thing.getMinNumber() > number) ?
                    (number + SMALLEST_NUMBER) : (number + LARGEST_NUMBER);

            if (thing.getMinNumber() < number && number < thing.getMaxNumber()) {
                thing.setAvgNumber(getAverageNumber(thing));
            }
            else {
                System.out.println(answer);
            }
        }
        else {
            thing.setMinNumber(number);
            System.out.println(number + SMALLEST_NUMBER);

            thing.setMaxNumber(number);
            System.out.println(number + LARGEST_NUMBER);

            thing.setAvgNumber(getAverageNumber(thing));
            System.out.println(thing.getAvgNumber() + AVERAGE_NUMBER);
        }
    }

    /**
     * Calculate the average of all the numbers in the array
     */
    @Override
    public Double getAverageNumber(Thing thing) {

        List<Integer> numbersStorage = numbersStorageService.readNumbers();

        thing.setAvgNumber(
                numbersStorage.stream()
                        .mapToInt(Integer::intValue)
                        .average()
                        .orElse(0.0)
        );
        String result = String.format("%.2f", thing.getAvgNumber());
        System.out.println(result + AVERAGE_NUMBER);
        return thing.getAvgNumber();
    }

    /**
     * Displaying all numbers in an array
     */
    @Override
    public void getNumbers(Thing thing) {

        List<Integer> numbers = numbersStorageService.readNumbers();
        System.out.println(numbers);
    }
}
