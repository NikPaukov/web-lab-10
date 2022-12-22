package com.example.lab10.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Table(name = "faqs")
@Entity
@Setter
@Getter
public class Faq {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "question is required")
    private String question;
    @NotBlank(message = "answer is required")
    private String answer;
}
