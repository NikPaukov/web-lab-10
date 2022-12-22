package com.example.lab10.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Table(name = "faculties")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "name is required")
    @Pattern(regexp = "(^$)|[а-яА-ЯїієЄІЇa-zA-Z\\-\\d ']+", message = "name should contain only english/ukrainian letters")
    private String name;

    @NotBlank(message = "shortName is required")
    @Pattern(regexp = "(^$)|[а-яА-ЯїієЄІЇa-zA-Z\\-\\d '']+", message = "shortName should contain only english/ukrainian letters")
    @Column(name = "short_name")
    private String shortName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Faculty faculty = (Faculty) o;
        return id != null && Objects.equals(id, faculty.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
