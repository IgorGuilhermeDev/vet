package org.com.vet.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "pet", indexes = {@Index(name = "pet__id_idx", columnList = "id")})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pet extends org.com.vet.model.Entity {
    private String name;
    private String species;
    private String race;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;
}
