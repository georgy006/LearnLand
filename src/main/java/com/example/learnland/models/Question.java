package com.example.learnland.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "question")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "question_text", columnDefinition = "TEXT", nullable = false)
    private String textQuestion;
}
