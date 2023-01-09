package com.example.pjwebback.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name="faqs")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Faq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "питання необхідне")
    String question;

    @NotBlank(message = "відповідь необхідна")
    String answer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Faq faq = (Faq) o;
        return id != null && Objects.equals(id, faq.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
