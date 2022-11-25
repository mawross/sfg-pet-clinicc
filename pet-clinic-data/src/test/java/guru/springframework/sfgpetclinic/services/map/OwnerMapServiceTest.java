package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static junit.framework.Assert.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    final Long ownerId = 1L;
    final String lastname = "Smith";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerId).lastname(lastname).build());
    }



    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(ownerId, owner.getId());
        //Set<Owner> ownerSet = ownerMapService.findAll();
        //assertEquals(1, ownerSet.size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner = ownerMapService.save(owner2);
        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
        Long id = savedOwner.getId();
    }

    @Test
    void findAll() {
        HashSet<Owner> ownerSet = (HashSet<Owner>) ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
        assertEquals(ownerSet.size(), 1);
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertNull(ownerMapService.findById(ownerId));
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(lastname);
        assertNotNull(owner);
        assertEquals(lastname, owner.getLastName());
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner owner = ownerMapService.findByLastName("foo");
        assertNull(owner);
    }
}