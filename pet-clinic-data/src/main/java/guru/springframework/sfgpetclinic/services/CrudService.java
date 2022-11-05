package guru.springframework.sfgpetclinic.services;/* 24/10/2022" "12:54" "Julian */

import java.util.Set;

public interface CrudService <T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
