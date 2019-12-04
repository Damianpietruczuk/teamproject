package hibernate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Employees")
@ToString
public class Employees implements HibernateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Getter @Setter
    private int id;

    @Column(name = "LastName")
    @Getter @Setter
    private String lastName;

    @Column(name = "FirstName")
    @Getter @Setter
    private String firstName;

    @Column(name = "Address")
    @Getter @Setter
    private String address;

    @Column(name = "City")
    @Getter @Setter
    private String city;

    @Column(name = "Salary")
    @Getter @Setter
    private int salary;

    @Column(name = "Age")
    @Getter @Setter
    private int age;

    @Column(name = "StartJobDate")
    @Getter @Setter
    private Date startJobDate;

    @Column(name = "Benefit")
    @Getter @Setter
    private int benefit;


    public Employees(){

    }

    public Employees(String lastName, String firstName, String address, String city, int salary, int age, Date startJobDate, int benefit) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.city = city;
        this.salary = salary;
        this.age = age;
        this.startJobDate = startJobDate;
        this.benefit = benefit;
    }
}
