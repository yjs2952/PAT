package com.injucksung.injucksung.domain;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity @Table(name = "book_content")
@Setter @Getter
@NoArgsConstructor @EqualsAndHashCode
public class BookContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Book book;

    @Column(length = 100, nullable = false)
    private String name;

    @Column
    private Long parentId;

    @Column
    private Long groupId;

    @Column(nullable = false)
    private Integer sequence;

    @Column(nullable = false)
    private Integer depth;

    @Column(nullable = false)
    private Boolean isMockTest; //모의고사 인지 일반 문제인지

    @Column
    private Integer recommendTime; //권장시간 (단위 초)

    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer questionCount; //이 목차에 해당하는 문제 갯수
}
