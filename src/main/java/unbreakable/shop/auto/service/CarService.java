package unbreakable.shop.auto.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unbreakable.shop.auto.entity.car_structure.*;
import unbreakable.shop.auto.repository.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
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

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Car> getCars() {
        return carRepository.findAll();
    }

//    public List<Car> getCarsWithOneImage() {
//        ImageRepository imageRepository;
//        List<Car> cars = carRepository.findAll();
//        List<Car> carList;
//        for (Car car : cars) {
//            car.setImages(imageRepository.findFirstByCar_Id(car.getId()));
//        }
//    }
    public void deleteCarById(Integer id){
        try {
            carRepository.deleteById(id);
        }
        catch (Exception e){e.printStackTrace();}
    }
    public Optional<Car> getCar(Integer id){return carRepository.findById(id);}


}
