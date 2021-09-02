package com.internship.project.intexsoft.util;

import java.util.List;

public class NumbersStorageService {

    private static final String STORAGE_FILENAME = "/home/hp/IdeaProjects/Internship_Intexsoft/Internship/src/com/internship/project/intexsoft/resources/numbers.txt";

    public final void writeNumbers(List<Integer> numbers) {

        SerializationService.serialize(numbers, STORAGE_FILENAME);
    }

    public final List<Integer> readNumbers() {

        return (List<Integer>) SerializationService.deserialize(STORAGE_FILENAME);
    }
}
