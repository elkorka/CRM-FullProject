package com.elz.backend.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "idClient")
    private int idClient;

    @Column(nullable = false)
    private String nom;

    private String prenom;

    @Column(unique = true, nullable = false)
    private String email;

    private String telephone;
    private String adresse;

    @CreationTimestamp
    @Column( updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


}
