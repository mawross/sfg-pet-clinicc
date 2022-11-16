package guru.springframework.sfgpetclinic.model;/* 21/10/2022" "12:40" "Julian */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

   public Person(Long id, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
   }

}
