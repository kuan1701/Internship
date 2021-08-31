package com.internship.project.intexsoft.model;

import com.internship.project.intexsoft.util.NumbersStorageService;

import java.util.Collections;
import java.util.List;

public class Thing {

    private Double avgNumber;
    private Integer minNumber;
    private Integer maxNumber;

    NumbersStorageService numbersStorageService = new NumbersStorageService();
    List<Integer> numbers = numbersStorageService.readNumbers();

    public Thing() {
        this.avgNumber = 0.0;
        this.minNumber = Collections.min(numbers);
        this.maxNumber = Collections.max(numbers);
    }

    public Double getAvgNumber() {
        return avgNumber;
    }

    public void setAvgNumber(Double avgNumber) {
        this.avgNumber = avgNumber;
    }

    public Integer getMinNumber() {
        return minNumber;
    }

    public void setMinNumber(Integer minNumber) {
        this.minNumber = minNumber;
    }

    public Integer getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
