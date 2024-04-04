package com.springframework.pets;

import org.springframework.stereotype.Service;

//@Service - Lets make as java configuration instead
public class PetServiceFactory {


    public PetService getPetService(String petType) {

        switch(petType) {
            case "dog" :
                return new DogPetService();
            case "cat":
                return new CatPetService();
            default:
                return new DogPetService();
        }


    }


}
