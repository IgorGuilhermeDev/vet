package org.com.vet.api.priv;

import lombok.AllArgsConstructor;
import org.com.vet.representation.CreateUserDto;
import org.com.vet.usecase.UseCaseCreateUser;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserApi {

    private final UseCaseCreateUser useCaseCreateUser;

    @PostMapping
    public ResponseEntity<Object> save(@Validated @RequestBody CreateUserDto createUserDto){
        var user = createUserDto.toModel();
        var savedUser = this.useCaseCreateUser.save(user);
        var headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("id={id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

}
