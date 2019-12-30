package ru.bjcreslin.zakupki;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.bjcreslin.zakupki.DTO.DataJSONFromServer;
import ru.bjcreslin.zakupki.classes.sites.Region70Site;

@SpringBootApplication
@Log
public class ZakupkiConsoleApplication implements CommandLineRunner {
    String text = "{\"page\":3,\"itemsPerPage\":100,\"tradeState\":\"\",\"OnlyTradesWithMyApplications\":false,\"filterPriceMin\":\"\",\"filterPriceMax\":\"\",\"filterDateFrom\":null,\"filterDateTo\":null,\"filterFillingApplicationEndDateFrom\":null,\"FilterFillingApplicationEndDateTo\":null,\"filterTradeEasuzNumber\":\"\",\"showOnlyOwnTrades\":true,\"IsImmediate\":false,\"UsedClassificatorType\":5,\"classificatorCodes\":[],\"CustomerFullNameOrInn\":\"\",\"CustomerAddress\":\"\",\"ParticipantHasApplicationsOnTrade\":\"\",\"UseCustomerInn\":false,\"UseCustomerName\":true,\"ZmoFzTypeFz44p4\":true,\"ZmoFzTypeFz44p5\":true,\"ZmoFzTypeFz44NotP4Or5\":true,\"ZmoFzTypeFzFz223\":true,\"ZmoFinanceSourceBudget\":true,\"ZmoFinanceSourceOutOfBudget\":true,\"ZmoFinanceSourceMixedBudget\":true,\"TradeSearchType\":50}";

    public static void main(String[] args) {
        log.info("Starting application....");
        SpringApplication.run(ZakupkiConsoleApplication.class, args);
        log.info("Finishing application");
    }

    @Override
    public void run(String... args) throws Exception {
        Region70Site region70Site = new Region70Site();
        region70Site.setPurchasesOnPage(100);
        region70Site.getHttpPost().setEntity(new StringEntity(text));
        HttpResponse response = region70Site.getHttpClient().execute(region70Site.getHttpPost());
        String textFromResponse = EntityUtils.toString(response.getEntity());
        ObjectMapper objectMapper = new ObjectMapper();
        DataJSONFromServer dataJSONFromServer = objectMapper.readValue(textFromResponse, DataJSONFromServer.class);
        dataJSONFromServer.logObject();
    }


}
