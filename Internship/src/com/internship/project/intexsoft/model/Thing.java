package com.internship.project.intexsoft.model;

public class Thing {

    private Double avgNumber;
    private Integer minNumber;
    private Integer maxNumber;

//    NumbersStorageService numbersStorageService = new NumbersStorageService();
//    List<Integer> numbers = numbersStorageService.readNumbers();

//    public Thing() {
//        this.avgNumber = 0.0;
//        this.minNumber = Collections.min(numbers);
//        this.maxNumber = Collections.max(numbers);
//    }


    public Thing() {
    }

    public final Double getAvgNumber() {
        return avgNumber;
    }

    public final void setAvgNumber(Double avgNumber) {
        this.avgNumber = avgNumber;
    }

    public final Integer getMinNumber() {
        return minNumber;
    }

    public final void setMinNumber(Integer minNumber) {
        this.minNumber = minNumber;
    }

    public final Integer getMaxNumber() {
        return maxNumber;
    }

    public final void setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
    }

//    public List<Integer> getNumbers() {
//        return numbers;
//    }
}
