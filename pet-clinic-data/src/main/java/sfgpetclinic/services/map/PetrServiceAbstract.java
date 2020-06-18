package sfgpetclinic.services.map;

import sfgpetclinic.model.Pet;
import sfgpetclinic.services.CrudService;

import java.util.Set;

public class PetrServiceAbstract extends AbstractMapService<Long, Pet> implements CrudService <Pet, Long> {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }
}
