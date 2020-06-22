package sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import sfgpetclinic.model.Owner;
import sfgpetclinic.services.OwnerService;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Long, Owner> implements OwnerService<Owner, Long> {
    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
