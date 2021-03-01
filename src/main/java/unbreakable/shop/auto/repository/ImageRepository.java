package unbreakable.shop.auto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unbreakable.shop.auto.entity.car_structure.Car;
import unbreakable.shop.auto.entity.car_structure.Image;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image,Integer> {
    Image findFirstByCar_Id(Integer id);
    Image findFirstByCar(Car car);
    List<Image>findAllByCar_Id(Integer id);
}
