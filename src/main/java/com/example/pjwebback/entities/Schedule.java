package com.example.pjwebback.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name="SCHEDULES")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Pattern(regexp = "(^$)|[а-яА-ЯїієЄІЇa-zA-Z\\-\\d '']++", message = "назва повинна містити лише цифри, українські та англійські літери")
    private String name;
    @JoinColumn(name="teacher_id")
    @ManyToOne
    @NotNull(message = "вчителя необхідно обрати")
    private Teacher teacher;

    @JoinColumn(name="discipline_id")
    @ManyToOne
    @NotNull(message = "диспицліну необхідно обрати")
    private Discipline discipline;

    @JoinColumn(name="group_id")
    @ManyToOne
    @NotNull(message = "групу необхідно обрати")
    private Group group;

    @NotBlank(message = "час необхідно обрати")
    @Pattern(regexp = "(^$)|[а-яА-ЯїієЄІЇa-zA-Z\\-\\d '']+", message = "час повинен містити лише цифри, українські та англійські літери")
    private String time;

    @Pattern(regexp = "(^$)|[а-яА-ЯїієЄІЇa-zA-Z\\-\\d '']+", message = "кабінет повинен містити лише цифри, українські та англійські літери")
    private String classroom;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Schedule schedule = (Schedule) o;
        return id != null && Objects.equals(id, schedule.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
