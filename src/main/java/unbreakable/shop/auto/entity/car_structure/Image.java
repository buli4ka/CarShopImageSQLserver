package unbreakable.shop.auto.entity.car_structure;

import javax.persistence.*;

@Entity(name = "Image")
@Table(schema = "carshop",name="images_tbl")
public class Image {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "image_name", nullable = true, length = 255)
    private String imageName;
    @Column(name = "image_type", nullable = true, length = 10)
    private String imageType;

    @Lob
    @Column(name = "image", nullable = false)
    private byte[] image;

    @ManyToOne
    @JoinColumn(name="car_id")
    private Car car;


    public Image() {
    }

    public Image(Integer id, String imageName, String imageType, byte[] image, Car car) {
        this.id = id;
        this.imageName = imageName;
        this.imageType = imageType;
        this.image = image;
        this.car = car;
    }
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] imagePath) {
        this.image = imagePath;
    }
}

