package com.example.movieservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class Rating {

    @Id
    private String id;

    private Double rating;

    private Integer popularity;
}
