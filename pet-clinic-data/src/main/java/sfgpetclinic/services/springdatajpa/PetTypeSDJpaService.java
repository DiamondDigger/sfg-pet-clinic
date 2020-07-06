package sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sfgpetclinic.model.PetType;
import sfgpetclinic.repositories.PetTypeRepository;
import sfgpetclinic.services.PetTypeService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        System.out.println("PETTYPE-PETTYPE-PETTYPE-PETTYPE-PETTYPE-PETTYPE-");
        System.out.println("PETTYPE-PETTYPE-PETTYPE-PETTYPE-PETTYPE-PETTYPE-");
        System.out.println("PETTYPE-PETTYPE-PETTYPE-PETTYPE-PETTYPE-PETTYPE-");
        System.out.println("PETTYPE-PETTYPE-PETTYPE-PETTYPE-PETTYPE-PETTYPE-");
        System.out.println("--------------------------");

        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
