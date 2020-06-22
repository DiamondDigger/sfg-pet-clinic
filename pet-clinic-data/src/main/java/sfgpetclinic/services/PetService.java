package sfgpetclinic.services;


import sfgpetclinic.model.BaseEntity;
import sfgpetclinic.model.Pet;

public interface PetService<P extends BaseEntity, L extends Number> extends CrudService<Pet, Long>{
}
