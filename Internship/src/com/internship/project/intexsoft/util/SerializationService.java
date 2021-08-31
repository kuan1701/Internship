package com.internship.project.intexsoft.util;

import java.io.*;
import java.util.List;

public class SerializationService {

    public SerializationService() {
    }

    protected static void serialize(List<Integer> numbers, String fileName) {

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))){
            objectOutputStream.writeObject(numbers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static Object deserialize(String fileName){

        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
