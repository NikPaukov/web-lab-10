package com.example.pjwebback.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Table(name = "teachers")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "ім'я необхідно")
    @Pattern(regexp = "(^$)|[а-яА-ЯїієЄІЇa-zA-Z\\- '']+", message = "ім'я повинно містити лише цифри, українські та англійські літери")
    private String name;

    @NotBlank(message = "необхідно")
    @Pattern(regexp = "(^$)|[а-яА-ЯїієЄІЇa-zA-Z\\- '']+", message = "ім'я повинно містити лише цифри, українські та англійські літери")
    private String surname;

    @Email(message = "емайл некоректний")
    private String email;

    @Pattern(regexp = "(^$)|[+\\d{13}]", message = "Некоректний номер")
    private String phone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Teacher teacher = (Teacher) o;
        return id != null && Objects.equals(id, teacher.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

