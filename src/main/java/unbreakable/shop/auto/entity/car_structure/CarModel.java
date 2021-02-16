package unbreakable.shop.auto.entity.car_structure;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "CarModel")
@Table(schema = "carshop", name = "car_model_tbl")
public class CarModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "car_model_name", nullable = false, length = 30)
    private String carModelName;
    @ManyToOne
    @JoinColumn(name="manufacturer_id")
    private Manufacturer manufacturer;

    @OneToMany
    @JoinColumn(name = "car_model_id")
    private Set<Car> carSet = new HashSet<>();

    public CarModel() {
    }

    public CarModel(Integer id
            , String carModelName
            , Manufacturer manufacturer
            , Set<Car> carSet) {
        this.id = id;
        this.carModelName = carModelName;
        this.manufacturer = manufacturer;
        this.carSet = carSet;
    }

    public Set<Car> getCarSet() {
        return carSet;
    }

    public void setCarSet(Set<Car> carSet) {
        this.carSet = carSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }


}
