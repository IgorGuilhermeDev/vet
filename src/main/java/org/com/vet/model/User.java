package org.com.vet.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users", indexes = {@Index(name = "users__id_idx", columnList = "id")})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends org.com.vet.model.Entity {
    private String cpf;
    private String name;
    private String email;
    private String phone;
    private String password;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pet> pets;
}
