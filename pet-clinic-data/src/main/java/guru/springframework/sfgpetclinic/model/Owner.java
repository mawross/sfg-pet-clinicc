package guru.springframework.sfgpetclinic.model;/* 21/10/2022" "12:44" "Julian */


import java.util.Set;

public class Owner extends Person {

    private Set<Pet> pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
