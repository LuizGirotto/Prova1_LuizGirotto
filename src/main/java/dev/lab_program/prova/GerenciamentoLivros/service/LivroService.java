package dev.lab_program.prova.GerenciamentoLivros.service;

import dev.lab_program.prova.GerenciamentoLivros.model.Livro;

import java.util.List;

public interface LivroService {
    List<Livro> listarTodos();
    Livro buscarPorId(Long id);
    Livro salvar(Livro livro);
    void excluirPorId(Long id);
}
