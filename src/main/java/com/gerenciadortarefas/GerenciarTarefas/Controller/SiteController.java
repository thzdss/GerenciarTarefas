package com.gerenciadortarefas.GerenciarTarefas.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {

    @GetMapping("/")
    public String inicio() {
        return "index";
    }
}