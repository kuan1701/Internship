package com.internship.project.intexsoft.service;

import com.internship.project.intexsoft.model.Thing;

public interface ThingService {

    void getThingMessage(Thing thing);

    Double getAverageNumber(Thing thing);

    void getNumbers(Thing thing);
}
