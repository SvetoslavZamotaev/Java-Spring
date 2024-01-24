package com.example.Seminar4homeWork.controllers;

import com.example.Seminar4homeWork.model.Car;
import com.example.Seminar4homeWork.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class CarController {

    private CarService carService;

    @GetMapping("/products")
    public String getAllProducts(Model model){
        model.addAttribute("cars", carService.getAllCars()) ;
        return "products";
    }


    @PostMapping("/products")
    public String addProduct(Car p, Model model){
        carService.addCar(p);
        model.addAttribute("cars", carService.getAllCars());
        return "products";
    }


}
