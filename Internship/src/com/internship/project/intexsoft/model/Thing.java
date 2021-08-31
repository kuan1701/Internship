package com.internship.project.intexsoft.model;

import com.internship.project.intexsoft.util.NumbersStorageService;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public final class Thing {

    Scanner scanner = new Scanner(System.in);

    NumbersStorageService numbersStorageService = new NumbersStorageService();
    List<Integer> numbers = numbersStorageService.readNumbers();

    private Double avgNumber = 0.0;
    private Integer minNumber = Collections.min(numbers);
    private Integer maxNumber = Collections.max(numbers);
    private final Integer number = scanner.nextInt();

    public final void getThingMessage() {

        numbers.add(number);
        numbersStorageService.writeNumbers(numbers);

        if (minNumber != null && maxNumber != null && avgNumber != null) {

            if (minNumber > number) {
                System.out.println("Number " + number + " is the smallest number it has encountered so far");
            }
            else if (maxNumber < number) {
                System.out.println("Number " + number + " is the largest number it has encountered so far");
            }
            else if (minNumber < number && number < maxNumber) {
                avgNumber = getAverageNumber();
            }
        }
        else {
            minNumber = number;
            System.out.println("Number " + number + " is the smallest number it has encountered so far");

            maxNumber = number;
            System.out.println("Number " + number + " is the largest number it has encountered so far");

            avgNumber = getAverageNumber();
            System.out.println("Number " + avgNumber + " is the average of all numbers it has encountered so far");
        }
    }

    public final Double getAverageNumber() {

        List<Integer> numbersStorage = numbersStorageService.readNumbers();

        avgNumber = numbersStorage.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        String result = String.format("%.2f", avgNumber);
        System.out.println("Number " + result + " is the average of all numbers it has encountered so far");
        return avgNumber;
    }

    public final void getNumbers() {

        List<Integer> numbers = numbersStorageService.readNumbers();
        System.out.println(numbers);
    }
}
