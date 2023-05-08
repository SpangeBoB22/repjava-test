package tasks;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.jackson.Jacksonized;
import java.io.Serial;
import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Jacksonized
@Entity
@Table(name = "address")
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = 2L;
    @Id

    @Column(name = "id")
    private int id;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
}
