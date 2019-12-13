package hibernate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Employees")
@ToString
public class Employees implements HibernateEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Employee_ID")
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

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "StartJobDate")
    @Getter @Setter
    private Date startJobDate;

    @Column(name = "Benefit")
    @Getter @Setter
    private int benefit;

    @Column(name = "Email")
    @Getter @Setter
    private String email;

    @OneToMany(mappedBy = "employees", orphanRemoval = true, fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<Phones> phones;
//
//    @OneToOne(mappedBy = "employees", cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY, optional = false)
//    @ToString.Exclude
//    private Car car;

    @ManyToMany(mappedBy = "employees", fetch = FetchType.EAGER)
    @Getter @Setter
    @ToString.Exclude
    private Set<Printer> printers = new HashSet<>();



    public Employees(){

    }

    public Employees(String lastName, String firstName, String address, String city, int salary, int age, int benefit, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.city = city;
        this.salary = salary;
        this.age = age;
        this.startJobDate = new Date();
        this.benefit = benefit;
        this.email=email;
    }

    @Override public String toString() {
        return this.firstName +" "+this.lastName;
    }
}
