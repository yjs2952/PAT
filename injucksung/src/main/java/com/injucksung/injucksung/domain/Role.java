package com.injucksung.injucksung.domain;

import lombok.*;

import javax.persistence.*;

@ToString
@Entity
@Table(name = "role")
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(length = 20, nullable = false, unique = true)
    private String name;
}