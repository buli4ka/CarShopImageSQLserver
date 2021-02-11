package unbreakable.shop.auto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unbreakable.shop.auto.entity.CarStructure.Car;


public interface CarRepository extends JpaRepository<Car,Integer> {
}
