package sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sfgpetclinic.model.Owner;
import sfgpetclinic.repositories.OwnerRepository;
import sfgpetclinic.services.OwnerService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService<Owner, Long > {

    private final OwnerRepository ownerRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();

        ownerRepository.findAll().forEach( owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {

        if (ownerRepository.findById(aLong).isPresent()) {
            return ownerRepository.findById(aLong).get();
        } else {
            return null;
        }
    }

    @Override
    public Owner save(Owner object) {
        System.out.println("OWNER-OWNER");
        System.out.println("OWNER-OWNER");
        System.out.println("OWNER-OWNER");
        System.out.println("OWNER-OWNER");
        System.out.println("OWNER-OWNER");
        System.out.println("--------------------------");

        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}
