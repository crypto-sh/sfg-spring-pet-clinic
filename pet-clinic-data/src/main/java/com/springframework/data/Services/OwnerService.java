package com.springframework.data.Services;

import com.springframework.data.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLastName(String lastName);

}
