package hibernate;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Printer")
@Data
@RequiredArgsConstructor
public class Printer implements HibernateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Name")
    @NonNull
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false, referencedColumnName="ID")
    @NonNull
    private Employees employees;

//    @ManyToMany(cascade = { CascadeType.ALL })
//    @JoinTable(name = "Employees",
//            joinColumns = { @JoinColumn(name = "Employee_ID") },
//            inverseJoinColumns = { @JoinColumn(name = "ID") }
//    )
//    private List<Employees> employees;

    public Printer(){
    }
}
