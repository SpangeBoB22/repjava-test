package task5;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Builder
@Jacksonized
public class Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private Address address;
}
