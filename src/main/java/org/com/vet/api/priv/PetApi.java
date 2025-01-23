package org.com.vet.api.priv;

import lombok.AllArgsConstructor;
import org.com.vet.representation.CreatePetDto;
import org.com.vet.representation.CreateUserDto;
import org.com.vet.usecase.UseCaseCreatePet;
import org.com.vet.usecase.UseCaseCreateUser;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("pet")
@AllArgsConstructor
public class PetApi {
    private final UseCaseCreatePet useCaseCreatePet;

    @PostMapping
    public ResponseEntity<Object> save(@Validated @RequestBody CreatePetDto dto){
        System.out.println(dto.toModel().getName());
        var pet = dto.toModel();
        var savedUser = this.useCaseCreatePet.save(pet);
        var headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("id={id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }
}
