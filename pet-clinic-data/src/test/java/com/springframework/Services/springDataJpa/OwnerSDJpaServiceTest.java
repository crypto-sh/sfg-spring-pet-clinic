package com.springframework.Services.springDataJpa;

import com.springframework.Services.PetTypeService;
import com.springframework.model.Owner;
import com.springframework.repositories.OwnerRepository;
import com.springframework.repositories.PetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeService petTypeService;

    @InjectMocks
    OwnerSDJpaService service;
    String LAST_NAME = "Smith";
    Owner returnOwner;
    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {

        Owner returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();

        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner owner = service.findByLastName(LAST_NAME);

        assertNotNull(owner);
        assertEquals(LAST_NAME, owner.getLastName());

        verify(ownerRepository, times(1)).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnerSet = new HashSet<>();
        returnOwnerSet.add(Owner.builder().id(1L).build());
        returnOwnerSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnOwnerSet);

        Set<Owner> owners = service.findAll();

        assertEquals(2, owners.size());

        verify(ownerRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        Long mId = 1L;
        Owner returnOwner = Owner.builder().id(mId).build();
        when(ownerRepository.findById(any())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(mId);

        assertNotNull(owner);
        assertEquals(mId, owner.getId());

        verify(ownerRepository, times(1)).findById(any());
    }

    @Test
    void findByIdNotFound() {
        Long mId = 1L;
        when(ownerRepository.findById(any())).thenReturn(Optional.empty());

        Owner owner = service.findById(mId);

        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = service.save(ownerToSave);

        assertNotNull(savedOwner);
    }

    @Test
    void deleteById() {
        Long mId = 1L;
        service.deleteById(mId);
        verify(ownerRepository, times(1)).deleteById(mId);
    }

    @Test
    void delete() {
        service.delete(returnOwner);

        verify(ownerRepository, times(1)).delete(returnOwner);
    }
}