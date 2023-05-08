package tasks;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.jackson.Jacksonized;


@EqualsAndHashCode
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Jacksonized
@Entity
@Table(name = "interest")
public class Interest {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
}
