package org.com.vet.representation;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.com.vet.model.Pet;
import org.com.vet.model.User;

import java.util.UUID;

@Data
public class CreatePetDto {

    @NotBlank(message = "O nome deve ser informado") private String name;
    @NotBlank(message = "A raça deve ser informada")private String race;
    @NotBlank(message = "A espécie deve ser informada") private String species;
    @NotBlank(message = "O pet deve possuir um tutor") private String owner;

    public Pet toModel(){
        var user = User.builder().build();
        user.setId(UUID.fromString(this.owner));
        return Pet.builder()
                .name(this.name)
                .race(this.race)
                .species(this.species)
                .owner(user)
                .build();
    }
}
