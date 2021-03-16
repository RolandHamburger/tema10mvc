package com.tema10.mvc.service;

import com.tema10.mvc.model.dto.CarCreationRequest;
import com.tema10.mvc.model.dto.CarUpdateRequest;
import com.tema10.mvc.model.entity.CarEntity;

import java.util.List;

public interface CarService {
    List<CarEntity> getAllCars();

    CarEntity getCarById(Integer id);

    CarEntity addNewCar(CarCreationRequest request);

    CarEntity updateCar(CarUpdateRequest request);

    void deleteCarById(Integer id);
}
