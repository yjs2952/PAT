package com.injucksung.injucksung.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor @Builder
@EqualsAndHashCode
public class CommentContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;
}
