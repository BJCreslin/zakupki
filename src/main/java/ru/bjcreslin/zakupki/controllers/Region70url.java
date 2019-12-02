package ru.bjcreslin.zakupki.controllers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Region70url {

    public void action(String region70URL) throws IOException {

        Document document = Jsoup.connect(region70URL).get();

        Elements nameElement = document.getElementsByTag("h1");

        nameElement.eachText().forEach(System.out::println);
        br();

        document.getElementsByTag("label").eachText().forEach(System.out::println);

        br();
//        document.getElementsByTag("label").stream().map(x -> x.lastElementSibling().html()).forEach(System.out::println);
        for (Element element:document.getElementsByTag("label")){
            System.out.println(element.parent().nextElementSibling().text());

        }


    }

    private void br() {
        System.out.println("***********************");
    }
}
