package sfgpetclinic.services;


import sfgpetclinic.model.Person;
import sfgpetclinic.model.Vet;

public interface VetService<V extends Person, L extends Number> extends CrudService<Vet, Long>{
}
