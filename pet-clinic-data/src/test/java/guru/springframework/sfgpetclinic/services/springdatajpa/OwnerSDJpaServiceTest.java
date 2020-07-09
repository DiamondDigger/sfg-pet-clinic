package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    final String LAST_NAME = "Kelly";
    Owner owner;

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService jpaService;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(owner);
        Owner returnedOwner = jpaService.findByLastName(LAST_NAME);
        assertEquals(owner, returnedOwner);
        verify(ownerRepository,atLeastOnce()).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        Owner returnedOwner = jpaService.findByLastName(LAST_NAME);
        owners.add(returnedOwner);
        owners.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> findAllSet = jpaService.findAll();

        assertNotNull(findAllSet);
        assertEquals(2, findAllSet.size());

    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));
        Long ownerId = owner.getId();

        Owner returnedOwner = jpaService.findById(1L);
        assertNotNull(returnedOwner);
        assertEquals(ownerId, returnedOwner.getId());

        log.debug(returnedOwner.getId().toString());
        log.debug(returnedOwner.getLastName());
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Long ownerId = owner.getId();

        Owner returnedOwner = jpaService.findById(1L);
        assertNull(returnedOwner);
    }

    @Test
    void save() {
        Set<Owner> owners = new HashSet<>();
        owners.add(owner);

        when(ownerRepository.save(any())).thenReturn(owners.iterator().next());

        Set<Owner> returnedSet = new HashSet<>();
        returnedSet.add(jpaService.save(any()));

        assertNotNull(jpaService.save(any()));
        assertEquals(owners.size(), returnedSet.size());
        verify(ownerRepository, atLeastOnce()).save(any());
    }

    @Test
    void delete() {
        jpaService.save(owner);
        jpaService.delete(owner);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        jpaService.save(owner);
        jpaService.deleteById(owner.getId());
        verify(ownerRepository,times(1)).deleteById(anyLong());
    }
}