package com.example.escola.repository;

import com.example.escola.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    List<Aluno> findByNomeContainsIgnoreCase(String nome);

    List<Aluno> findBySerieId(Long serieId);

    List<Aluno> findBySerieNomeContainsIgnoreCase(String serieNome);

    Optional<Aluno> findByMatriculaContainingIgnoreCase(String matricula);

    Optional<Aluno> findByCpf(String cpf);

    Optional<Aluno> findByRg(String rg);

    @Transactional
    void deleteByMatricula(String matricula);

    @Query("SELECT e FROM Aluno e WHERE e.dataDeNascimento = :data")
    List<Aluno> findByDate(@Param("data") LocalDate date);
}
