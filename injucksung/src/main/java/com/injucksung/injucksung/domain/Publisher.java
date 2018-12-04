package com.injucksung.injucksung.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "publisher")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 100, nullable = false)
    private String name;
}
