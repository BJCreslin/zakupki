package ru.bjcreslin.zakupki.controllers;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.bjcreslin.zakupki.DTO.PurchaseRegion70;
import ru.bjcreslin.zakupki.repositories.PurchaseRegion70Repo;

import java.io.IOException;

@Log
@Controller
public class InputURLWebController {
    final
    Region70UrlController region70UrlController;
    final
    PurchaseRegion70Repo purchaseRegion70repo;

    public InputURLWebController(Region70UrlController region70UrlController, PurchaseRegion70Repo purchaseRegion70repo) {
        this.region70UrlController = region70UrlController;
        this.purchaseRegion70repo = purchaseRegion70repo;
    }

    @GetMapping("")
    String input() {
        return "index";
    }

    @PostMapping("/addurl")
    String addURL(@RequestParam(name = "url", required = false, defaultValue = "")
                          String nameURL, Model model) {
        log.info(nameURL);
        if (nameURL.startsWith("https://region70.rts-tender.ru/")) {
            try {
                PurchaseRegion70 purchaseRegion70 = region70UrlController.getPurchaseFromRegion70(nameURL);
                log.info(purchaseRegion70.toString());
                purchaseRegion70repo.saveAndFlush(purchaseRegion70);
            } catch (IOException e) {
                log.severe("Невозможно распознать " + nameURL);
            }

        }

        return "index";


    }
}
