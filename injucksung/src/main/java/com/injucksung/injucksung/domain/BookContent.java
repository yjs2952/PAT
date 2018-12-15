package com.injucksung.injucksung.domain;

import lombok.*;

import javax.persistence.*;

@ToString
@Entity
@Table(name = "book_content")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // (cascade = CascadeType.REMOVE) 설정은 누가 넣은거지?
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(length = 100, nullable = false)
    private String name;

    @Column
    private Long parentId;

    @Column(nullable = false)
    private int sequence;

    @Column(nullable = false)
    private Boolean isMockTest;

    @Column
    private Integer recommandTime; //권장시간 (단위 초)
}
