package ru.bjcreslin.zakupki.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.bjcreslin.zakupki.DTO.PurchaseRegion70;
import ru.bjcreslin.zakupki.classes.AbsttractSite;
import ru.bjcreslin.zakupki.classes.DataJSONFromServer;
import ru.bjcreslin.zakupki.classes.Region70Site;
import ru.bjcreslin.zakupki.repositories.PurchaseRegion70Repo;
import ru.bjcreslin.zakupki.services.Purchaseregion70ToDBaseService;
import ru.bjcreslin.zakupki.services.Region70UrlService;

import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;


@Log
@Controller
public class InputURLWebController {
    final
    Region70UrlService region70UrlService;
    final
    PurchaseRegion70Repo purchaseRegion70repo;
    final
    Purchaseregion70ToDBaseService purchaseregion70ToDBaseService;
    //Сайт с данными
    AbsttractSite siteWithDate;


    public InputURLWebController(Region70UrlService region70UrlService, PurchaseRegion70Repo purchaseRegion70repo, Purchaseregion70ToDBaseService purchaseregion70ToDBaseService) {
        this.region70UrlService = region70UrlService;
        this.purchaseRegion70repo = purchaseRegion70repo;
        this.purchaseregion70ToDBaseService = purchaseregion70ToDBaseService;
    }

    @GetMapping("")
    String indexPage() {

        return "index";
    }

    @PostMapping("/addurl")
    String addURL(@RequestParam(name = "url", required = false, defaultValue = "")
                          String nameURL, Model model) {
        log.info(nameURL);
        if (nameURL.startsWith("https://region70.rts-tender.ru/")) {
            try {
                PurchaseRegion70 purchaseRegion70 = region70UrlService.getPurchaseFromRegion70(nameURL);
                log.info(purchaseRegion70.toString());
                purchaseregion70ToDBaseService.save(purchaseRegion70);

            } catch (IOException e) {
                log.severe("Невозможно распознать " + nameURL);
            }

        }
        return "index";
    }

    @GetMapping("/testerone")
    String testerone() throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException {
        //Пока один сайт выставляем его жёстко
        siteWithDate = new Region70Site();
        HttpClient httpClient = siteWithDate.getHttpClient();
        HttpPost httpPost = siteWithDate.getHttpPost();
        httpPost.setEntity(siteWithDate.getHttpEntity(1, 10));

        try {
            HttpResponse response = httpClient.execute(httpPost);
            String textFromResponse = EntityUtils.toString(response.getEntity());
            ObjectMapper objectMapper = new ObjectMapper();
            DataJSONFromServer dataJSONFromServer = objectMapper.readValue(textFromResponse, DataJSONFromServer.class);
            for (int i = 0; i < dataJSONFromServer.invdata.size(); i++) {
                System.out.println(dataJSONFromServer.invdata.get(i).toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }


}
