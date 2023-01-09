package com.example.pjwebback.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "departments")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "faculty_id")
    @ManyToOne
    @NotNull(message = "факультет необхідно обрати")
    private Faculty faculty;

    @NotBlank(message = "назва необхідна")
    @Pattern(regexp = "(^$)|[а-яА-ЯїієЄІЇa-zA-Z\\-\\d '']+", message = "назва повинна містити лише цифри, українські та англійські літери")
    private String name;





    @Column(name = "short_name")
    @Pattern(regexp = "(^$)|[а-яА-ЯїієЄІЇa-zA-Z\\-\\d '']+", message = "скорочена назва повинна містити лише цифри, українські та англійські літери")
    private String shortName;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Department that = (Department) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
