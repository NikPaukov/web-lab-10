package com.example.lab10.entities;

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

    @NotBlank(message = "необхідно")
    @Pattern(regexp = "(^$)|[а-яА-ЯїієЄІЇa-zA-Z\\-\\d ']+", message = "name should contain only english/ukrainian letters")
    private String name;

    @NotBlank(message = "необхідно")
    @Pattern(regexp = "(^$)|[а-яА-ЯїієЄІЇa-zA-Z\\-\\d ']+", message = "surname should contain only english/ukrainian letters")
    private String surname;

    @Email(message = "invalid email")
    private String email;

    @Pattern(regexp = "(^$)|[+\\d{13}]", message = "invalid number")
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

