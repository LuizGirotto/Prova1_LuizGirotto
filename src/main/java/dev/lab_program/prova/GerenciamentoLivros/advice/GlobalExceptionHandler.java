package dev.lab_program.prova.GerenciamentoLivros.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import dev.lab_program.prova.GerenciamentoLivros.exception.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public String tratarResourceNotFound(ResourceNotFoundException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error/404";  // você poderia ter um template error/404.html
    }

    @ExceptionHandler(Exception.class)
    public String tratarGeral(Exception ex, Model model) {
        model.addAttribute("errorMessage", "Erro interno: " + ex.getMessage());
        return "error/500";  // template error/500.html
    }
}
