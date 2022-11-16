package guru.springframework.sfgpetclinic.model;/* 21/10/2022" "12:44" "Julian */


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
//@NoArgsConstructor

@Entity
//@Builder
@Table(name = "owners")
public class Owner extends Person {

    @Builder
    public Owner(Long id, String firstname, String lastname,
                 String address, String city, String telephone, Set<Pet> pets) {
        super(id, firstname, lastname);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }

    public Owner() {
        super();
    }

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

}
