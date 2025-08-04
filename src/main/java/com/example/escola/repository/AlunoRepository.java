package com.example.escola.repository;

import com.example.escola.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByName(String name);

    List<Aluno> findByCpf(String cpf);

    List<Aluno> findByRg(String rg);

    @Query("SELECT e FROM Aluno e WHERE e.dataDeNascimento = :data")
    List<Aluno> findByDate(@Param("data") LocalDate date);
}
