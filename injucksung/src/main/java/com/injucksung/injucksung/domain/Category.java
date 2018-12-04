package com.injucksung.injucksung.domain;

import lombok.*;

import javax.persistence.*;

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
    private int type; //인성(1)인지 적성(2)인지
}
