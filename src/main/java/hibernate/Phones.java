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
    @Column(name = "ID")
    @Getter
    @Setter
    private int id;

    @Column(name = "name")
    @Getter
    @Setter
    @NonNull
    private String name;

    @Column(name = "model")
    @Getter
    @Setter
    @NonNull
    private String model;

    public Phones(){

    }

}

