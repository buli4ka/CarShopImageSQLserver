package unbreakable.shop.auto.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unbreakable.shop.auto.entity.CarStructure.BodyType;
import unbreakable.shop.auto.entity.CarStructure.Car;
import unbreakable.shop.auto.entity.CarStructure.CarModel;
import unbreakable.shop.auto.entity.CarStructure.Manufacturer;
import unbreakable.shop.auto.repository.CarRepository;

import java.util.List;

@Service
public class CreatingCarService {
    @Autowired
    private CarRepository carRepository;

    public Car saveCar(double price
            , Manufacturer manufacturer
            , BodyType bodyType
            , short carYearOfIssue
            , CarModel carModel
            , String carDescription) {

        try {
            Car car = new Car();
            car.setBodyType(bodyType);
            car.setCarModel(carModel);
            car.setManufacturer(manufacturer);
            car.setYearOfIssue(carYearOfIssue);
            car.setCarDescription(carDescription);
            car.setPrice(price);
            return carRepository.save(car);

        }
        catch (Exception e){e.printStackTrace();}
        return null;
    }
    public List<Car> getCars(){return carRepository.findAll();}



}
