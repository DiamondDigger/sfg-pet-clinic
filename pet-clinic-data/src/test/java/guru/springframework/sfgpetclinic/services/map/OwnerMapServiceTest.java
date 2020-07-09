package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    Owner owner;

    final Long id = 1L;
    final String lastName = "John";

    @BeforeEach
    void setUp(){
        ownerMapService = new OwnerMapService(new PetMapService(),new PetTypeMapService());

        owner = Owner.builder().id(id).build();

        ownerMapService.save(owner);
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void findById() {
        Long ownerId = owner.getId();
        assertEquals(owner, ownerMapService.findById(ownerId));
    }

    @Test
    void save() {
        Owner owner2 = Owner.builder().build();
        ownerMapService.save(owner2);
        assertNotNull(owner2.getId());
        assertEquals(2, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(owner);
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        Long ownerId = owner.getId();
        ownerMapService.deleteById(ownerId);
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        owner.setLastName(lastName);
        assertNotNull(ownerMapService.findByLastName(lastName));
        assertEquals(owner, ownerMapService.findByLastName(lastName));
    }
    @Test
    void findByLastNameNotFound() {

        owner.setLastName(lastName);
        assertNull(ownerMapService.findByLastName("some Name"));
    }
}