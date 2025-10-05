package dev.lab_program.prova.GerenciamentoLivros.repository;

import dev.lab_program.prova.GerenciamentoLivros.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
