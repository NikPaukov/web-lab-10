package com.example.pjwebback.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Table(name = "students")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "group_id")
    @ManyToOne
    @NotNull(message = "необхідно обрати")
    private Group group;

    @NotBlank(message = "ім'я необхідно")
    @Pattern(regexp = "(^$)|[а-яА-ЯїієЄІЇa-zA-Z\\- '']+", message = "ім'я повинно містити лише цифри, українські та англійські літери")
    private String name;
    @Email(message = "емайл некоректний")
    private String email;
    @Pattern(regexp = "(^$)|[+\\d{13}]+", message = "Некоректний номер")
    private String phone;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;
        return id != null && Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
