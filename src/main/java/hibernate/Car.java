package hibernate;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cars")
@Data
@RequiredArgsConstructor
public class Car implements HibernateEntity{

    @Id
    @Column(name = "Id")
    private int id;

    @Column(name = "Name")
    @NonNull
    private String name;

    @Column(name = "Model")
    @NonNull
    private String model;

//    @OneToOne(fetch = FetchType.LAZY)
//    @ToString.Exclude
//    @MapsId
//    private Employees employees;

    public Car(){

    }
//    public Car(String name, String model, Employees employees){
//        this.name = name;
//        this.model=model;
//        this.employees = employees;
//    }

    @Override public String toString() {
        return this.name;
    }
}
