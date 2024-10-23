package com.example.learnland.repositories;

import com.example.learnland.models.AIInteraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AIInterectionRepository extends JpaRepository<AIInteraction, Long> {
}
