package com.example.pjwebback.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @Pattern(regexp = "(^$)|[а-яА-ЯїієЄІЇa-zA-Z\\-\\d ']++", message = "name should contain only english/ukrainian letters")
    private String name;
    @JoinColumn(name="teacher_id")
    @ManyToOne
    @NotNull(message = "teacher is required")
    private Teacher teacher;

    @JoinColumn(name="discipline_id")
    @ManyToOne
    @NotNull(message = "discipline is required")
    private Discipline discipline;

    @JoinColumn(name="group_id")
    @ManyToOne
    @NotNull(message = "group is required")
    private Group group;


    @NotNull(message = "lesson is required")
    @Min(value = 1, message = "should be from 1 to 6")
    @Max(value = 6, message = "should be from 1 to 6")
    private Integer lesson;

    @NotNull(message = "lesson is required")
    @Min(value = 1, message = "should be from 1 to 7")
    @Max(value = 7, message = "should be from 1 to 7")
    private Integer dayOfWeek;


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
