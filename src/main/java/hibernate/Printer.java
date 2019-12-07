package hibernate;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

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

    @Column(name = "EmployeeID")
    @NonNull
    private int EmployeeID;

    public Printer(){
    }
}
