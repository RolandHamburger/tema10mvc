package com.tema10.mvc.service;

import com.tema10.mvc.exception.CarNotFoundException;
import com.tema10.mvc.model.dto.CarCreationRequest;
import com.tema10.mvc.model.dto.CarUpdateRequest;
import com.tema10.mvc.model.entity.CarEntity;
import com.tema10.mvc.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public List<CarEntity> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public CarEntity getCarById(Integer id){
        return carRepository.findById(id).orElseThrow(() -> new CarNotFoundException("No car found for given id"));
    }

    @Override
    public CarEntity addNewCar(CarCreationRequest request) {
        var carEntityBuilder = CarEntity.builder()
                .carModel(request.getCarModel())
                .carColour(request.getCarColour())
                .horsePower(request.getHorsePower())
                .build();
        return carRepository.save(carEntityBuilder);
    }

    @Override
    public CarEntity updateCar(CarUpdateRequest request) {
        CarEntity carEntity = carRepository.findById(request.getId()).orElseThrow(() -> new CarNotFoundException("Car not found!"));

        carEntity.setCarModel(request.getCarModel());
        carEntity.setCarColour(request.getCarColour());
        carEntity.setHorsePower(request.getHorsePower());

        return carRepository.save(carEntity);
    }

    @Override
    public void deleteCarById(Integer id) {
        carRepository.deleteById(id);
    }
}
