package unbreakable.shop.auto.entity.car_structure;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Car")
@Table(schema = "carshop",name="car_tbl")
public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "price", nullable = false)
    private double price;

    @OneToMany
    @JoinColumn(name = "car_id")
    private Set<Image> images = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="manufacturer_id")
    private Manufacturer manufacturer;

    @ManyToOne
    @JoinColumn(name="body_type_id")
    private BodyType bodyType;

    @Column(name = "year_of_issue", nullable = false)
    private short yearOfIssue;

    @ManyToOne
    @JoinColumn(name="car_model_id")
    private CarModel carModel;

    @Column(name = "car_description")
    private String carDescription;

    public Car(double price
            , Set<Image> images
            , Manufacturer manufacturer
            , BodyType bodyType
            , short yearOfIssue
            , CarModel carModel
            , String carDescription)
    {
        this.id = id;
        this.price = price;
        this.images = images;
        this.manufacturer = manufacturer;
        this.bodyType = bodyType;
        this.yearOfIssue = yearOfIssue;
        this.carModel = carModel;
        this.carDescription = carDescription;
    }

    public Car() {
    }
    public short getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(short yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }



    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public String getCarDescription() {
        return carDescription;
    }

    public void setCarDescription(String carDescription) {
        this.carDescription = carDescription;
    }
}
