package com.example.pjwebback.entities;


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
public class Faculty  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "необхідна")
    @Pattern(regexp = "(^$)|[а-яА-ЯїієЄІЇa-zA-Z\\-\\d '']+", message = "назва повинна містити лише цифри, українські та англійські літери")
    private String name;

    @NotBlank(message = "необхідна")
    @Pattern(regexp = "(^$)|[а-яА-ЯїієЄІЇa-zA-Z\\-\\d '']+", message = "скорочена повинна містити лише цифри, українські та англійські літери")
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
