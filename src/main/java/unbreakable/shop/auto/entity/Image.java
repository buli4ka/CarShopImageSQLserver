package unbreakable.shop.auto.entity;

import javax.persistence.*;

@Entity
@Table(name="Images_TBL")
public class Image {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String imageName;
    private String imageType;

    private String imagePath;

    public Image() {
    }

    public Image(String imageName, String imageType, String dataPath) {
        this.imageName = imageName;
        this.imageType = imageType;
        this.imagePath = dataPath;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}

