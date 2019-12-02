package ru.bjcreslin.zakupki.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class InputURLWebController {
    @GetMapping("inputurl")

    String input() {
        return "test";
    }
}
