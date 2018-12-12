package com.injucksung.injucksung.domain;

import lombok.*;

import javax.persistence.*;

@ToString
@Entity
@Table(name = "category")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column
    private Long parentId;

    @Column
    private String type; //인성 "per" 적성 "apt
}
