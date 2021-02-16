package unbreakable.shop.auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unbreakable.shop.auto.entity.car_structure.CarModel;
import unbreakable.shop.auto.entity.car_structure.Manufacturer;
import unbreakable.shop.auto.repository.CarModelRepository;

import java.util.List;

@Service
public class CarModelService {
    @Autowired
    private CarModelRepository carModelRepository;

    public CarModel saveCarModel(String model, Manufacturer carManufacturer){
        try {
            CarModel carModel = new CarModel();
            carModel.setCarModelName(model);
            carModel.setManufacturer(carManufacturer);
            return carModelRepository.save(carModel);
        }
        catch (Exception e){e.printStackTrace();}
        return null;
    }
    public CarModel getCarModel(String carModelName){
        try {
            CarModel carModel = carModelRepository.findFirstByCarModelName(carModelName);
            if(carModel != null)
                return carModel;
        } catch (Exception e){e.printStackTrace();}
        return null;
    }
    public CarModel notExistCreate(String carModelName, Manufacturer carManufacturer){
        try {
            CarModel carModel = carModelRepository.findFirstByCarModelName(carModelName);
            if(carModel != null)
                return carModel;
            else {
                carModel = new CarModel();
                carModel.setCarModelName(carModelName);
                carModel.setManufacturer(carManufacturer);
                return carModelRepository.save(carModel);
            }
        } catch (Exception e){e.printStackTrace();}
        return null;
    }
    public List<CarModel> getCarModels(){return carModelRepository.findAll();}

    public void deleteCarModel(String carModelName){
        try {
            CarModel carModel = carModelRepository.findFirstByCarModelName(carModelName);
            carModelRepository.delete(carModel);
        }
        catch (Exception e){e.printStackTrace();}
    }
    public void updateCarModel(String carModelName, String newCarModelName){
        try{

            CarModel carModel = carModelRepository.findFirstByCarModelName(carModelName);

            carModel.setCarModelName(newCarModelName);

            carModelRepository.save(carModel);

        } catch (Exception e){e.printStackTrace();}
    }
}
