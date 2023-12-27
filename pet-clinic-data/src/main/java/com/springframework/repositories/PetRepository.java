package com.springframework.repositories;

import com.springframework.Services.CrudService;
import com.springframework.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository  extends CrudRepository<Pet, Long> {

}
