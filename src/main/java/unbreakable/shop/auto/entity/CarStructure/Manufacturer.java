package unbreakable.shop.auto.entity.CarStructure;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Manufacturer")
@Table(schema = "dbo", name = "manufacturer_tbl")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "manufacturer_name", nullable = false, length = 30)
    private String manufacturerName;
    @OneToMany
    @JoinColumn(name = "manufacturer_id")
    private Set<CarModel> carModelSet = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "manufacturer_id")
    private Set<Car> carSet = new HashSet<>();

    public Manufacturer() {
    }

    public Manufacturer(Integer id, String manufacturerName, Set<CarModel> carModelSet, Set<Car> carSet) {
        this.id = id;
        this.manufacturerName = manufacturerName;
        this.carModelSet = carModelSet;
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

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public Set<CarModel> getCarModelSet() {
        return carModelSet;
    }

    public void setCarModelSet(Set<CarModel> carModelSet) {
        this.carModelSet = carModelSet;
    }
}
