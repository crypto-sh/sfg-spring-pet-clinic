package com.springframework.repositories;

import com.springframework.Services.CrudService;
import com.springframework.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {

}
