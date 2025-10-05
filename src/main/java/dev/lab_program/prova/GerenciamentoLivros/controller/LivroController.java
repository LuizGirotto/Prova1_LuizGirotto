package dev.lab_program.prova.GerenciamentoLivros.controller;

import dev.lab_program.prova.GerenciamentoLivros.model.Livro;
import dev.lab_program.prova.GerenciamentoLivros.service.LivroService;
import dev.lab_program.prova.GerenciamentoLivros.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("livros", livroService.listarTodos());
        return "livros/list";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Livro livro, RedirectAttributes redirectAttributes) {
        try {
            livroService.salvar(livro);
            redirectAttributes.addFlashAttribute("mensagemSucesso", "Livro salvo com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erro ao salvar livro: " + e.getMessage());
        }
        return "redirect:/livros";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Livro livro = livroService.buscarPorId(id);
        model.addAttribute("livro", livro);
        return "livros/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            livroService.excluirPorId(id);
            redirectAttributes.addFlashAttribute("mensagemSucesso", "Livro excluído com sucesso!");
        } catch (ResourceNotFoundException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/livros";
    }

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Long id, Model model) {
        Livro livro = livroService.buscarPorId(id);
        model.addAttribute("livro", livro);
        return "livros/view";
    }
}
