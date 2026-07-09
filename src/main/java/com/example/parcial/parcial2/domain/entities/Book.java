package com.example.parcial.parcial2.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.util.UUID;

@Entity
@Table(name = "books")
@SQLRestriction("active = true")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private boolean available;

    @Column(nullable = false)
    private int availableCount;

    @Column(nullable = false)
    private boolean active = true;
}
