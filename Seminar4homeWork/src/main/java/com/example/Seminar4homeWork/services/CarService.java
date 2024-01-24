package com.example.Seminar4homeWork.services;

import com.example.Seminar4homeWork.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    List<Car> cars = new ArrayList<>();

    public void addCar(Car product){
        cars.add(product);
    }

    public List<Car> getAllCars(){
        return cars;
    }
}
