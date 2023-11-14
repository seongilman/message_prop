package com.message.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LocaleController {

    private final MessageSource messageSource;

    @Autowired
    public LocaleController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/")
    public String hello(Model model) {
        System.out.println("LocaleController.hello");
        System.out.println("message = " + messageSource.getMessage("home.lang.en", null, null, LocaleContextHolder.getLocale()));
        model.addAttribute("name", "Ilman SUNG");
        return "index";
    }
}
