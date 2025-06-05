package com.gerenciadortarefas.GerenciarTarefas.Controller;

import com.gerenciadortarefas.GerenciarTarefas.Model.Tarefa;
import com.gerenciadortarefas.GerenciarTarefas.Model.Usuario;
import com.gerenciadortarefas.GerenciarTarefas.Service.TarefaService;
import com.gerenciadortarefas.GerenciarTarefas.Service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller

public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @Autowired
    private UsuarioService usuarioService;


    @ModelAttribute("usuarioLogado")
    public Usuario getUsuarioLogado(HttpSession session) {
        Integer usuarioId = (Integer) session.getAttribute("usuarioLogadoId");
        if (usuarioId != null) {
            return usuarioService.buscarPorId(usuarioId);
        }
        return null;
    }


    @PostMapping("/login")
    public String fazerLogin(@RequestParam String email, @RequestParam String senha,
                             HttpSession session, RedirectAttributes redirectAttributes) {
        Usuario usuario = usuarioService.buscarPorEmail(email);

        if (usuario != null && usuario.getSenha().equals(senha)) {
            session.setAttribute("usuarioLogadoId", usuario.getId());
            session.setAttribute("usuarioLogadoNome", usuario.getNome());
            return "redirect:/tarefas";
        } else {
            redirectAttributes.addFlashAttribute("mensagemErro", "E-mail ou senha inválidos!");
            return "redirect:/";
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }


    @GetMapping("/tarefas")
    public String listarTarefas(Model model, HttpSession session) {
        Usuario usuarioLogado = (Usuario) getUsuarioLogado(session);
        if (usuarioLogado == null) {
            return "redirect:/";
        }
        model.addAttribute("tarefas", tarefaService.listarPorUsuario(usuarioLogado.getId()));
        model.addAttribute("nomeUsuario", usuarioLogado.getNome());
        return "tarefas";
    }


    @GetMapping({"/tarefas/novo", "/tarefas/editar/{id}"})
    public String exibirFormularioTarefa(@PathVariable(required = false) Integer id, Model model, HttpSession session) {
        Usuario usuarioLogado = (Usuario) getUsuarioLogado(session);
        if (usuarioLogado == null) {
            return "redirect:/";
        }

        Tarefa tarefa = new Tarefa();
        if (id != null) {
            tarefa = tarefaService.buscarPorId(id);

            if (tarefa == null || tarefa.getUsuario().getId() != usuarioLogado.getId()) {
                return "redirect:/tarefas";
            }
        }
        model.addAttribute("tarefa", tarefa);
        model.addAttribute("nomeUsuario", usuarioLogado.getNome());
        return "editar-tarefa";
    }


    @PostMapping("/tarefas/gravar")
    public String gravarTarefa(@ModelAttribute Tarefa tarefa, HttpSession session) {
        Usuario usuarioLogado = (Usuario) getUsuarioLogado(session);
        if (usuarioLogado == null) {
            return "redirect:/";
        }


        tarefa.setUsuario(usuarioLogado);
        tarefaService.salvar(tarefa);
        return "redirect:/tarefas";
    }


    @GetMapping("/tarefas/excluir/{id}")
    public String excluirTarefa(@PathVariable int id, HttpSession session) {
        Usuario usuarioLogado = (Usuario) getUsuarioLogado(session);
        if (usuarioLogado == null) {
            return "redirect:/";
        }

        Tarefa tarefa = tarefaService.buscarPorId(id);
        if (tarefa != null && tarefa.getUsuario().getId() == usuarioLogado.getId()) {
            tarefaService.excluir(id);
        }
        return "redirect:/tarefas";
    }


    @PostMapping("/tarefas/toggle-status/{id}")
    @ResponseBody
    public String toggleStatusTarefa(@PathVariable int id, HttpSession session) {
        Usuario usuarioLogado = (Usuario) getUsuarioLogado(session);
        if (usuarioLogado == null) {
            return "redirect:/";
        }

        Tarefa tarefa = tarefaService.buscarPorId(id);
        if (tarefa != null && tarefa.getUsuario().getId() == usuarioLogado.getId()) {
            tarefa.setConcluida(!tarefa.isConcluida());
            tarefaService.salvar(tarefa);
            return "success";
        }
        return "error";
    }
}