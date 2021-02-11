package unbreakable.shop.auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unbreakable.shop.auto.entity.CarStructure.Manufacturer;
import unbreakable.shop.auto.repository.CarModelRepository;
import unbreakable.shop.auto.repository.ManufacturerRepository;

import java.util.List;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private CarModelRepository carModelRepository;

    public Manufacturer saveManufacturer(String manufacturerName){
        try {
            Manufacturer manufacturer = new Manufacturer();
            manufacturer.setManufacturerName(manufacturerName);
            return manufacturerRepository.save(manufacturer);
        }
        catch (Exception e){e.printStackTrace();}
        return null;
    }
    public Manufacturer getManufacturer(String manufacturerName){
        try {
            Manufacturer manufacturer = manufacturerRepository.findByManufacturerName(manufacturerName);
            if(manufacturer != null)
                return manufacturer;
        } catch (Exception e){e.printStackTrace();}
        return null;
    }
    public List<Manufacturer> getManufacturers(){
        return manufacturerRepository.findAll();
    }

    public void deleteManufacturer(String manufacturerName){
        try {
            Manufacturer manufacturer = manufacturerRepository.findFirstByManufacturerName(manufacturerName);

            manufacturerRepository.delete(manufacturer);
        }
        catch (Exception e){e.printStackTrace();}
    }

    public void updateManufacturer(String manufacturerName, String newManufacturerName){
        try{

            Manufacturer manufacturer = manufacturerRepository.findFirstByManufacturerName(manufacturerName);

            manufacturer.setManufacturerName(newManufacturerName);

            manufacturerRepository.save(manufacturer);

        } catch (Exception e){e.printStackTrace();}
    }





}
