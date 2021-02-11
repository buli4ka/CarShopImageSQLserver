package unbreakable.shop.auto.entity.CarStructure;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "BodyType")
@Table(schema = "dbo", name = "body_type_tbl")
public class BodyType {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "body_type_name", nullable = false, length = 20)
    private String bodyTypeName;

    @OneToMany
    @JoinColumn(name = "body_type_id")
    private Set<Car> carSet = new HashSet<>();


    public BodyType() {
    }
    public BodyType(Integer id, String bodyTypeName, Set<Car> carSet) {
        this.id = id;
        this.bodyTypeName = bodyTypeName;
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

    public String getBodyTypeName() {
        return bodyTypeName;
    }

    public void setBodyTypeName(String bodyTypeName) {
        this.bodyTypeName = bodyTypeName;
    }
}
