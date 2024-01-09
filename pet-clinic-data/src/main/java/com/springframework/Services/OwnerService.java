package com.springframework.Services;

import com.springframework.model.Owner;

import java.util.List;
import java.util.Set;

public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
