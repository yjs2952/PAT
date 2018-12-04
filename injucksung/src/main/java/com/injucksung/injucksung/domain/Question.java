package com.injucksung.injucksung.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "question")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public abstract class Question{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "BookContent_id", nullable = false)
    private BookContent bookContent;

    @Column(nullable = false)
    private int bookNumber;

    @Column(nullable = false)
    private String query;
}
