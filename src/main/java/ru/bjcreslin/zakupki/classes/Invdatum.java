package ru.bjcreslin.zakupki.classes;

import com.fasterxml.jackson.annotation.*;

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
public class Invdatum {

    @JsonProperty("TradeState")
    public Integer tradeState;
    @JsonProperty("TradeStateName")
    public String tradeStateName;
    @JsonProperty("CustomerFullName")
    public String customerFullName;
    @JsonProperty("CustomerId")
    public Integer customerId;
    @JsonProperty("TradeName")
    public String tradeName;
    @JsonProperty("Id")
    public Integer id;
    @JsonProperty("TradeNumber")
    public String tradeNumber;
    @JsonProperty("LotNumber")
    public Integer lotNumber;
    @JsonProperty("InitialPrice")
    public Double initialPrice;
    @JsonProperty("IsInitialPriceDefined")
    public Boolean isInitialPriceDefined;
    @JsonProperty("FillingApplicationEndDate")
    public String fillingApplicationEndDate;
    @JsonProperty("PublicationDate")
    public String publicationDate;
    @JsonProperty("HasApplications")
    public Boolean hasApplications;
    @JsonProperty("IsImmediate")
    public Boolean isImmediate;
    @JsonProperty("ParticipantHasApplicationsOnTrade")
    public Boolean participantHasApplicationsOnTrade;
    @JsonProperty("HasDealSignedOutsideEShop")
    public Boolean hasDealSignedOutsideEShop;
    @JsonProperty("LastModificationDate")
    public Object lastModificationDate;
    @JsonProperty("TradeLotState")
    public Integer tradeLotState;
    @JsonProperty("PublicApplications")
    public Object publicApplications;
    @JsonProperty("IsPublicApplicationsEnabled")
    public Boolean isPublicApplicationsEnabled;
    @JsonProperty("CountApplications")
    public Integer countApplications;
    @JsonProperty("IsHideApplicationData")
    public Boolean isHideApplicationData;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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