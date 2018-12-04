package com.injucksung.injucksung.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "passage")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public abstract class Passage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)//한 문제에 passage가 여러개 일 경우 정렬 순서
    private int sequence;
}
