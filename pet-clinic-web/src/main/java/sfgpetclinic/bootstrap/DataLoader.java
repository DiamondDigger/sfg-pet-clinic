package sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sfgpetclinic.model.Owner;
import sfgpetclinic.model.Pet;
import sfgpetclinic.model.PetType;
import sfgpetclinic.model.Vet;
import sfgpetclinic.services.OwnerService;
import sfgpetclinic.services.PetTypeService;
import sfgpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;

        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("Brooklyn street 23/2");
        owner1.setCity("NY");
        owner1.setTelephone("2234-123-124");

        Pet michaelDog = new Pet();
        michaelDog.setPetType(savedDogPetType);
        michaelDog.setName("Rocco");
        michaelDog.setOwner(owner1);
        michaelDog.setBirthDate(LocalDate.now());
        owner1.getPets().add(michaelDog);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("Brooklyn street 23/2");
        owner2.setCity("NY");
        owner2.setTelephone("2234-123-124");

        Pet fionasCat = new Pet();
        fionasCat.setPetType(savedCatPetType);
        fionasCat.setName("Hurricane");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        System.out.println("Loading Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loading Vets...");

    }
}
