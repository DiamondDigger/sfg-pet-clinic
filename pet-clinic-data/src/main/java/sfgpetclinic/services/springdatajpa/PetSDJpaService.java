package sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sfgpetclinic.model.Pet;
import sfgpetclinic.repositories.PetRepository;
import sfgpetclinic.services.PetService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

    private final PetRepository petRepository;

    public PetSDJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet pet) {
        System.out.println("PET-PET");
        System.out.println("PET-PET");
        System.out.println("PET-PET");
        System.out.println("PET-PET");
        System.out.println("PET-PET");
        System.out.println("--------------------------");

        pet.getOwner().getPets().add(pet);
        return petRepository.save(pet);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
