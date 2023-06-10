package com.yuba.cafe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Snack {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String imageUrl;
    private Long price;
    private String tagline;

    @ElementCollection
    private Set<String> tags;
    private Long available;
    @Column(columnDefinition = "TEXT")
    private String detail;
    @Column(columnDefinition = "TEXT")
    private String ingredients;
}