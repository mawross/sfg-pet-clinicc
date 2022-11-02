package guru.springframework.sfgpetclinic.model;/* 02/11/2022" "15:42" "Julian */

public class Specialty extends BaseEntity {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
