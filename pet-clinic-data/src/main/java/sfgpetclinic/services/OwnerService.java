package sfgpetclinic.services;

import sfgpetclinic.model.Owner;
import sfgpetclinic.model.Person;

public interface OwnerService<O extends Person, L extends Number> extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}

