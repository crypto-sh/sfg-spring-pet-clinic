package com.springframework.Services;

import com.springframework.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLastName(String lastName);

}
