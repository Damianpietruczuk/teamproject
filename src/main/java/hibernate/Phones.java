package hibernate;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Phones")
@ToString
@RequiredArgsConstructor
public class Phones implements HibernateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Phone_ID")
    @Getter
    @Setter
    private int id;

    @Column(name = "Name")
    @Getter
    @Setter
    @NonNull
    private String name;

    @Column(name = "Model")
    @Getter
    @Setter
    @NonNull
    private String model;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false, referencedColumnName="Employee_ID")
    @Getter @Setter
    @NonNull
    @ToString.Exclude
    private Employees employees;

    public Phones(){

    }

}

