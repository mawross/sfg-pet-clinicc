package guru.springframework.sfgpetclinic.model;/* 22/10/2022" "18:27" "Julian */

import java.io.Serializable;

public class BaseEntity implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
