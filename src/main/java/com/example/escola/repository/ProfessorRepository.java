package com.example.escola.repository;

import com.example.escola.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    List<Professor> findByNomeContainingIgnoreCase(String nome);

    Optional<Professor> findByCpf(String cpf);

    Optional<Professor> findByRg(String rg);

    List<Professor> findByLicenciaturaContainingIgnoreCase (String licenciatura);

    @Query("SELECT e FROM Professor e WHERE e.dataDeNascimento = :data")
    List<Professor> finByDate(LocalDate date);
}
