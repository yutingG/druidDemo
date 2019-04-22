package com.example.demo.controller;

import com.example.demo.dao.CityRepository;
import com.example.demo.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    //http://localhost:8080/saveCity?cityName=北京&cityIntroduce=中国首都
    @PostMapping(value = "saveCity")
    public String saveCity(String cityName,String cityIntroduce){
        City city = new City(cityName,cityIntroduce);
        cityRepository.save(city);
        return "success";
    }

    //http://localhost:8080/deleteCity?cityId=2
    @GetMapping(value = "deleteCity")
    public String deleteCity(int cityId){
        cityRepository.deleteById(cityId);
        return "success";
    }

    //http://localhost:8080/updateCity?cityId=3&cityName=沈阳&cityIntroduce=辽宁省省会
    @GetMapping(value = "updateCity")
    public String updateCity(int cityId,String cityName,String cityIntroduce){
        City city = new City(cityId,cityName,cityIntroduce);
        cityRepository.save(city);
        return "success";
    }


    //http://localhost:8080/getCityById?cityId=3
    @GetMapping(value = "getCityById")
    public Optional<City> getCityById(int cityId){
        Optional<City> city = cityRepository.findById(cityId);
        return city;
    }


}
