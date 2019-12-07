package hibernate;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Printer")
@Data
@RequiredArgsConstructor
public class Printer implements HibernateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Printer_ID")
    private int id;

    @Column(name = "Name")
    @NonNull
    private String name;

//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "EMPLOYEE_ID", nullable = false, referencedColumnName="ID")
//    @NonNull
//    private Employees employees;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @ToString.Exclude
    @JoinTable(name = "Employees_Printers",
            joinColumns = { @JoinColumn(name = "Printer_ID") },
            inverseJoinColumns = { @JoinColumn(name = "Employee_ID") }
    )
     Set<Employees> employees = new HashSet<>();

    public Printer(){
    }

    public Printer(String name,Set<Employees> employees){
        this.name=name;
        this.employees=employees;
    }
    @Override public String toString() {
        return this.name;
    }
}
