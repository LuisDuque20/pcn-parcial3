package com.example.parcial.parcial2.domain.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookRequestDto {

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    private String genre;

    @NotBlank
    private String isbn;

    private boolean available;

    @Min(0)
    private int availableCount;
}
