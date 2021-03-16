package com.tema10.mvc.controller;

import com.tema10.mvc.model.dto.CarCreationRequest;
import com.tema10.mvc.model.dto.CarUpdateRequest;
import com.tema10.mvc.model.entity.CarEntity;
import com.tema10.mvc.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @RequestMapping(method = RequestMethod.GET, path = {"/", "/showCars"})
    public String showCarsPage(Model model){

        List<CarEntity> employeeEntityList = carService.getAllCars();

        model.addAttribute("carList", employeeEntityList);
        CarCreationRequest attributeValue = new CarCreationRequest();

        model.addAttribute("carToAdd", attributeValue);

        return "cars";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/add")
    public String showAddPage(ModelMap model){

        CarCreationRequest attributeValue = new CarCreationRequest();

        model.addAttribute("carToAdd", attributeValue);

        return "addCar";
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String add(@ModelAttribute(name = "carToAdd") @Valid CarCreationRequest request, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "addCar";
        }
        carService.addNewCar(request);

        return showCarsPage(model);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{carId}/edit")
    public String showEditPage(@PathVariable(name = "carId") String id,
                               ModelMap model) {

        CarEntity carEntity = carService.getCarById(Integer.parseInt(id));
        model.addAttribute("carToEdit", carEntity);

        return "editCar";
    }

    //    @RequestMapping(method = RequestMethod.POST, path = "/{employeeId}/edit")
    @PostMapping("/{carId}/edit")
    public String editCar(@PathVariable int carId,
                               @ModelAttribute(name = "carToEdit") @Valid CarUpdateRequest request,
                               BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "editCar";
        }

        request.setId(carId);
        carService.updateCar(request);

        return showCarsPage(model);
    }

    @PostMapping("/{carId}/delete")
    public String deleteCar(@PathVariable int carId,
                                 Model model) {

        carService.deleteCarById(carId);

        return showCarsPage(model);
    }
}
