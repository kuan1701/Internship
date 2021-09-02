package com.internship.project.intexsoft;

import com.internship.project.intexsoft.service.ThingService;
import com.internship.project.intexsoft.service.impl.ThingServiceImpl;

public class Main {

    public static void main(String[] args) {

        System.out.println("Please enter a number:");

        ThingService thingService = new ThingServiceImpl();

        System.out.println("All numbers in an array:");
        thingService.printNumbers();
    }
}
