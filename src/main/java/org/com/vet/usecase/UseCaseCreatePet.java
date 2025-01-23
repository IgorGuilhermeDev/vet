package org.com.vet.usecase;

import lombok.AllArgsConstructor;
import org.com.vet.model.Pet;
import org.com.vet.repository.PetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class UseCaseCreatePet {
    private final PetRepository repository;

    @Transactional
    public Pet save(Pet pet) {
        return repository.save(pet);
    }
}
