package unbreakable.shop.auto.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unbreakable.shop.auto.entity.car_structure.BodyType;
import unbreakable.shop.auto.entity.car_structure.Manufacturer;
import unbreakable.shop.auto.repository.BodyTypeRepository;

import java.util.List;

@Service
public class BodyTypeService {
    @Autowired
    private BodyTypeRepository bodyTypeRepository;

    public BodyType saveBodyType(String bodyTypeName) {
        try {
            BodyType bodyType = new BodyType();
            bodyType.setBodyTypeName(bodyTypeName);
            return bodyTypeRepository.save(bodyType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public BodyType getBodyType(String bodyTypeName) {
        try {
            BodyType bodyType = bodyTypeRepository.findFirstByBodyTypeName(bodyTypeName);
            if (bodyType != null)
                return bodyType;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public BodyType notExistCreate(String bodyTypeName) {
        try {
            BodyType bodyType = bodyTypeRepository.findFirstByBodyTypeName(bodyTypeName);
            if (bodyType != null)
                return bodyType;
            else {
                bodyType = new BodyType();
                bodyType.setBodyTypeName(bodyTypeName);
                return bodyTypeRepository.save(bodyType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public List<BodyType> getBodyTypes() {
        return bodyTypeRepository.findAll();
    }

    public void deleteBodyType(String bodyTypeName) {
        try {
            BodyType bodyType = bodyTypeRepository.findFirstByBodyTypeName(bodyTypeName);
            bodyTypeRepository.delete(bodyType);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateManufacturer(String bodyTypeName, String newBodyTypeName) {
        try {
            BodyType bodyType = bodyTypeRepository.findFirstByBodyTypeName(bodyTypeName);
            bodyType.setBodyTypeName(newBodyTypeName);
            bodyTypeRepository.save(bodyType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
