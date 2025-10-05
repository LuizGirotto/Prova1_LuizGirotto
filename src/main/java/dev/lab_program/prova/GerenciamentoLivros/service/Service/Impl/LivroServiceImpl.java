package dev.lab_program.prova.GerenciamentoLivros.service.Service.Impl;

import dev.lab_program.prova.GerenciamentoLivros.model.Livro;
import dev.lab_program.prova.GerenciamentoLivros.repository.LivroRepository;
import dev.lab_program.prova.GerenciamentoLivros.service.LivroService;
import dev.lab_program.prova.GerenciamentoLivros.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroServiceImpl implements LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Override
    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    @Override
    public Livro buscarPorId(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado com id: " + id));
    }

    @Override
    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    @Override
    public void excluirPorId(Long id) {
        if (!livroRepository.existsById(id)) {
            throw new ResourceNotFoundException("Livro não encontrado com id: " + id);
        }
        livroRepository.deleteById(id);
    }
}
