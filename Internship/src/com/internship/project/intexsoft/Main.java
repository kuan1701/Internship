package com.internship.project.intexsoft;

import com.internship.project.intexsoft.model.Thing;
import com.internship.project.intexsoft.service.impl.ThingServiceImpl;

public class Main {

    public static void main(String[] args) {

        System.out.println("Please enter a number:");

        ThingServiceImpl thingService = new ThingServiceImpl();

        Thing thing = new Thing();

        thingService.getThingMessage(thing);

        System.out.println("All numbers in an array:");
        thingService.getNumbers(thing);
    }
}
