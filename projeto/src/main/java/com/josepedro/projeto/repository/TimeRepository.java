package com.josepedro.projeto.repository;

import com.josepedro.projeto.entity.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time,Long> {
}
