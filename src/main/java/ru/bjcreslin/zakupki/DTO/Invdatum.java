package ru.bjcreslin.zakupki.DTO;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "TradeState",
        "TradeStateName",
        "CustomerFullName",
        "CustomerId",
        "TradeName",
        "Id",
        "TradeNumber",
        "LotNumber",
        "InitialPrice",
        "IsInitialPriceDefined",
        "FillingApplicationEndDate",
        "PublicationDate",
        "HasApplications",
        "IsImmediate",
        "ParticipantHasApplicationsOnTrade",
        "HasDealSignedOutsideEShop",
        "LastModificationDate",
        "TradeLotState",
        "PublicApplications",
        "IsPublicApplicationsEnabled",
        "CountApplications",
        "IsHideApplicationData"
})
@Getter
@Setter
public class Invdatum {

    @JsonProperty("TradeState")
    private Integer tradeState;
    @JsonProperty("TradeStateName")
    private String tradeStateName;
    @JsonProperty("CustomerFullName")
    private String customerFullName;
    @JsonProperty("CustomerId")
    private Integer customerId;
    @JsonProperty("TradeName")
    private String tradeName;
    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("TradeNumber")
    private String tradeNumber;
    @JsonProperty("LotNumber")
    private Integer lotNumber;
    @JsonProperty("InitialPrice")
    private Double initialPrice;
    @JsonProperty("IsInitialPriceDefined")
    private Boolean isInitialPriceDefined;
    @JsonProperty("FillingApplicationEndDate")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime fillingApplicationEndDate;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonProperty("publicationDate")
    private LocalDateTime publicationDate;
    @JsonProperty("HasApplications")
    private Boolean hasApplications;
    @JsonProperty("IsImmediate")
    private Boolean isImmediate;
    @JsonProperty("ParticipantHasApplicationsOnTrade")
    private Boolean participantHasApplicationsOnTrade;
    @JsonProperty("HasDealSignedOutsideEShop")
    private Boolean hasDealSignedOutsideEShop;
    @JsonProperty("LastModificationDate")
    private Object lastModificationDate;
    @JsonProperty("TradeLotState")
    private Integer tradeLotState;
    @JsonProperty("publicApplications")
    private Object publicApplications;
    @JsonProperty("isPublicApplicationsEnabled")
    private Boolean isPublicApplicationsEnabled;
    @JsonProperty("CountApplications")
    private Integer countApplications;
    @JsonProperty("IsHideApplicationData")
    private Boolean isHideApplicationData;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Invdatum{" +
                "tradeState=" + tradeState +
                ", tradeStateName='" + tradeStateName + '\'' +
                ", customerFullName='" + customerFullName + '\'' +
                ", customerId=" + customerId +
                ", tradeName='" + tradeName + '\'' +
                ", id=" + id +
                ", tradeNumber='" + tradeNumber + '\'' +
                ", lotNumber=" + lotNumber +
                ", initialPrice=" + initialPrice +
                ", isInitialPriceDefined=" + isInitialPriceDefined +
                ", fillingApplicationEndDate='" + fillingApplicationEndDate + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                ", hasApplications=" + hasApplications +
                ", isImmediate=" + isImmediate +
                ", participantHasApplicationsOnTrade=" + participantHasApplicationsOnTrade +
                ", hasDealSignedOutsideEShop=" + hasDealSignedOutsideEShop +
                ", lastModificationDate=" + lastModificationDate +
                ", tradeLotState=" + tradeLotState +
                ", publicApplications=" + publicApplications +
                ", isPublicApplicationsEnabled=" + isPublicApplicationsEnabled +
                ", countApplications=" + countApplications +
                ", isHideApplicationData=" + isHideApplicationData +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}