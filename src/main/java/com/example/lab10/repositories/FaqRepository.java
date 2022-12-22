package com.example.lab10.repositories;

import com.example.lab10.entities.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaqRepository extends JpaRepository<Faq, Integer> {
    List<Faq> searchAllByQuestionContainingOrderByQuestion(String question);
}
