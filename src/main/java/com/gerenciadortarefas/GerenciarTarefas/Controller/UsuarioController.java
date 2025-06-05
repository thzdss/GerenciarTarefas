package com.gerenciadortarefas.GerenciarTarefas.Controller;

import com.gerenciadortarefas.GerenciarTarefas.Model.Usuario;
import com.gerenciadortarefas.GerenciarTarefas.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/cadastro")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro";
    }


    @PostMapping("/gravar")
    public String gravarUsuario(@ModelAttribute Usuario usuario, RedirectAttributes redirectAttributes) {
        usuarioService.salvar(usuario);
        redirectAttributes.addFlashAttribute("mensagemSucesso", "Usuário cadastrado com sucesso! Faça login.");
        return "redirect:/";
    }
}