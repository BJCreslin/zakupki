package ru.bjcreslin.zakupki.DTO;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//{"page":4,"itemsPerPage":10,"tradeState":"","OnlyTradesWithMyApplications":false,"filterPriceMin":"","filterPriceMax":"","filterDateFrom":null,"filterDateTo":null,"filterFillingApplicationEndDateFrom":null,"FilterFillingApplicationEndDateTo":null,"filterTradeEasuzNumber":"","showOnlyOwnTrades":true,"IsImmediate":false,"UsedClassificatorType":5,"classificatorCodes":[],"CustomerFullNameOrInn":"","CustomerAddress":"","ParticipantHasApplicationsOnTrade":"","UseCustomerInn":false,"UseCustomerName":true,"TradeSearchType":50}

/**
 * Класс запроса данных с сервера
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "page",
        "itemsPerPage",
        "tradeState",
        "OnlyTradesWithMyApplications",
        "filterPriceMin",
        "filterPriceMax",
        "filterDateFrom",
        "filterDateTo",
        "filterFillingApplicationEndDateFrom",
        "FilterFillingApplicationEndDateTo",
        "filterTradeEasuzNumber",
        "showOnlyOwnTrades",
        "IsImmediate",
        "UsedClassificatorType",
        "classificatorCodes",
        "CustomerFullNameOrInn",
        "CustomerAddress",
        "ParticipantHasApplicationsOnTrade",
        "UseCustomerInn",
        "UseCustomerName",
        "TradeSearchType"
})
public class RequestRegion70 {


    @JsonProperty("page")
    private Integer page;
    @JsonProperty("itemsPerPage")
    private Integer itemsPerPage;
    @JsonProperty("tradeState")
    private String tradeState;
    @JsonProperty("OnlyTradesWithMyApplications")
    private Boolean onlyTradesWithMyApplications;
    @JsonProperty("filterPriceMin")
    private String filterPriceMin;
    @JsonProperty("filterPriceMax")
    private String filterPriceMax;
    @JsonProperty("filterDateFrom")
    private Object filterDateFrom;
    @JsonProperty("filterDateTo")
    private Object filterDateTo;
    @JsonProperty("filterFillingApplicationEndDateFrom")
    private Object filterFillingApplicationEndDateFrom;
    @JsonProperty("FilterFillingApplicationEndDateTo")
    private Object filterFillingApplicationEndDateTo;
    @JsonProperty("filterTradeEasuzNumber")
    private String filterTradeEasuzNumber;
    @JsonProperty("showOnlyOwnTrades")
    private Boolean showOnlyOwnTrades;
    @JsonProperty("IsImmediate")
    private Boolean isImmediate;
    @JsonProperty("UsedClassificatorType")
    private Integer usedClassificatorType;
    @JsonProperty("classificatorCodes")
    private List<Object> classificatorCodes;
    @JsonProperty("CustomerFullNameOrInn")
    private String customerFullNameOrInn;
    @JsonProperty("CustomerAddress")
    private String customerAddress;
    @JsonProperty("ParticipantHasApplicationsOnTrade")
    private String participantHasApplicationsOnTrade;
    @JsonProperty("UseCustomerInn")
    private Boolean useCustomerInn;
    @JsonProperty("UseCustomerName")
    private Boolean useCustomerName;
    @JsonProperty("TradeSearchType")
    private Integer tradeSearchType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    public String toString() {
        return "{" +
                "page=" + page +
                ", itemsPerPage=" + itemsPerPage +
                ", tradeState='" + tradeState + '\'' +
                ", onlyTradesWithMyApplications=" + onlyTradesWithMyApplications +
                ", filterPriceMin='" + filterPriceMin + '\'' +
                ", filterPriceMax='" + filterPriceMax + '\'' +
                ", filterDateFrom=" + filterDateFrom +
                ", filterDateTo=" + filterDateTo +
                ", filterFillingApplicationEndDateFrom=" + filterFillingApplicationEndDateFrom +
                ", filterFillingApplicationEndDateTo=" + filterFillingApplicationEndDateTo +
                ", filterTradeEasuzNumber='" + filterTradeEasuzNumber + '\'' +
                ", showOnlyOwnTrades=" + showOnlyOwnTrades +
                ", isImmediate=" + isImmediate +
                ", usedClassificatorType=" + usedClassificatorType +
                ", classificatorCodes=" + classificatorCodes +
                ", customerFullNameOrInn='" + customerFullNameOrInn + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", participantHasApplicationsOnTrade='" + participantHasApplicationsOnTrade + '\'' +
                ", useCustomerInn=" + useCustomerInn +
                ", useCustomerName=" + useCustomerName +
                ", tradeSearchType=" + tradeSearchType +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

    public RequestRegion70() {
        this(1);
    }

    public RequestRegion70(Integer page) {
        this(page, 100);
    }

    public RequestRegion70(Integer page, Integer itemsPerPage) {
        this.page = page;
        this.itemsPerPage = itemsPerPage;
        tradeState = "";
        onlyTradesWithMyApplications = false;
        filterPriceMin = "";
        filterPriceMax = "";
        filterDateFrom = null;
        filterDateTo = null;
        filterFillingApplicationEndDateFrom = null;
        filterFillingApplicationEndDateTo = null;
        filterTradeEasuzNumber = "";
        showOnlyOwnTrades = true;
        isImmediate = false;
        usedClassificatorType = 5;
        classificatorCodes = null;
        customerFullNameOrInn = "";
        customerAddress = "";
        participantHasApplicationsOnTrade = "";
        useCustomerInn = false;
        useCustomerName = true;
        tradeSearchType = 50;
    }

    /*
            {"page":4,
            "itemsPerPage":10,
            "tradeState":"",
            "OnlyTradesWithMyApplications":false,
            "filterPriceMin":"",
            "filterPriceMax":"",
            "filterDateFrom":null,
            "filterDateTo":null,
            "filterFillingApplicationEndDateFrom":null,
            "FilterFillingApplicationEndDateTo":null,
            "filterTradeEasuzNumber":"",
            "showOnlyOwnTrades":true,
            "IsImmediate":false,
            "UsedClassificatorType":5,
            "classificatorCodes":[],
            "CustomerFullNameOrInn":"",
            "CustomerAddress":"",
            "ParticipantHasApplicationsOnTrade":"",
            "UseCustomerInn":false,
            "UseCustomerName":true,
            "TradeSearchType":50}
             */

    @JsonProperty("page")
    public Integer getPage() {
        return page;
    }

    @JsonProperty("page")
    public void setPage(Integer page) {
        this.page = page;
    }

    @JsonProperty("itemsPerPage")
    public Integer getItemsPerPage() {
        return itemsPerPage;
    }

    @JsonProperty("itemsPerPage")
    public void setItemsPerPage(Integer itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    @JsonProperty("tradeState")
    public String getTradeState() {
        return tradeState;
    }

    @JsonProperty("tradeState")
    public void setTradeState(String tradeState) {
        this.tradeState = tradeState;
    }

    @JsonProperty("OnlyTradesWithMyApplications")
    public Boolean getOnlyTradesWithMyApplications() {
        return onlyTradesWithMyApplications;
    }

    @JsonProperty("OnlyTradesWithMyApplications")
    public void setOnlyTradesWithMyApplications(Boolean onlyTradesWithMyApplications) {
        this.onlyTradesWithMyApplications = onlyTradesWithMyApplications;
    }

    @JsonProperty("filterPriceMin")
    public String getFilterPriceMin() {
        return filterPriceMin;
    }

    @JsonProperty("filterPriceMin")
    public void setFilterPriceMin(String filterPriceMin) {
        this.filterPriceMin = filterPriceMin;
    }

    @JsonProperty("filterPriceMax")
    public String getFilterPriceMax() {
        return filterPriceMax;
    }

    @JsonProperty("filterPriceMax")
    public void setFilterPriceMax(String filterPriceMax) {
        this.filterPriceMax = filterPriceMax;
    }

    @JsonProperty("filterDateFrom")
    public Object getFilterDateFrom() {
        return filterDateFrom;
    }

    @JsonProperty("filterDateFrom")
    public void setFilterDateFrom(Object filterDateFrom) {
        this.filterDateFrom = filterDateFrom;
    }

    @JsonProperty("filterDateTo")
    public Object getFilterDateTo() {
        return filterDateTo;
    }

    @JsonProperty("filterDateTo")
    public void setFilterDateTo(Object filterDateTo) {
        this.filterDateTo = filterDateTo;
    }

    @JsonProperty("filterFillingApplicationEndDateFrom")
    public Object getFilterFillingApplicationEndDateFrom() {
        return filterFillingApplicationEndDateFrom;
    }

    @JsonProperty("filterFillingApplicationEndDateFrom")
    public void setFilterFillingApplicationEndDateFrom(Object filterFillingApplicationEndDateFrom) {
        this.filterFillingApplicationEndDateFrom = filterFillingApplicationEndDateFrom;
    }

    @JsonProperty("FilterFillingApplicationEndDateTo")
    public Object getFilterFillingApplicationEndDateTo() {
        return filterFillingApplicationEndDateTo;
    }

    @JsonProperty("FilterFillingApplicationEndDateTo")
    public void setFilterFillingApplicationEndDateTo(Object filterFillingApplicationEndDateTo) {
        this.filterFillingApplicationEndDateTo = filterFillingApplicationEndDateTo;
    }

    @JsonProperty("filterTradeEasuzNumber")
    public String getFilterTradeEasuzNumber() {
        return filterTradeEasuzNumber;
    }

    @JsonProperty("filterTradeEasuzNumber")
    public void setFilterTradeEasuzNumber(String filterTradeEasuzNumber) {
        this.filterTradeEasuzNumber = filterTradeEasuzNumber;
    }

    @JsonProperty("showOnlyOwnTrades")
    public Boolean getShowOnlyOwnTrades() {
        return showOnlyOwnTrades;
    }

    @JsonProperty("showOnlyOwnTrades")
    public void setShowOnlyOwnTrades(Boolean showOnlyOwnTrades) {
        this.showOnlyOwnTrades = showOnlyOwnTrades;
    }

    @JsonProperty("IsImmediate")
    public Boolean getIsImmediate() {
        return isImmediate;
    }

    @JsonProperty("IsImmediate")
    public void setIsImmediate(Boolean isImmediate) {
        this.isImmediate = isImmediate;
    }

    @JsonProperty("UsedClassificatorType")
    public Integer getUsedClassificatorType() {
        return usedClassificatorType;
    }

    @JsonProperty("UsedClassificatorType")
    public void setUsedClassificatorType(Integer usedClassificatorType) {
        this.usedClassificatorType = usedClassificatorType;
    }

    @JsonProperty("classificatorCodes")
    public List<Object> getClassificatorCodes() {
        return classificatorCodes;
    }

    @JsonProperty("classificatorCodes")
    public void setClassificatorCodes(List<Object> classificatorCodes) {
        this.classificatorCodes = classificatorCodes;
    }

    @JsonProperty("CustomerFullNameOrInn")
    public String getCustomerFullNameOrInn() {
        return customerFullNameOrInn;
    }

    @JsonProperty("CustomerFullNameOrInn")
    public void setCustomerFullNameOrInn(String customerFullNameOrInn) {
        this.customerFullNameOrInn = customerFullNameOrInn;
    }

    @JsonProperty("CustomerAddress")
    public String getCustomerAddress() {
        return customerAddress;
    }

    @JsonProperty("CustomerAddress")
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @JsonProperty("ParticipantHasApplicationsOnTrade")
    public String getParticipantHasApplicationsOnTrade() {
        return participantHasApplicationsOnTrade;
    }

    @JsonProperty("ParticipantHasApplicationsOnTrade")
    public void setParticipantHasApplicationsOnTrade(String participantHasApplicationsOnTrade) {
        this.participantHasApplicationsOnTrade = participantHasApplicationsOnTrade;
    }

    @JsonProperty("UseCustomerInn")
    public Boolean getUseCustomerInn() {
        return useCustomerInn;
    }

    @JsonProperty("UseCustomerInn")
    public void setUseCustomerInn(Boolean useCustomerInn) {
        this.useCustomerInn = useCustomerInn;
    }

    @JsonProperty("UseCustomerName")
    public Boolean getUseCustomerName() {
        return useCustomerName;
    }

    @JsonProperty("UseCustomerName")
    public void setUseCustomerName(Boolean useCustomerName) {
        this.useCustomerName = useCustomerName;
    }

    @JsonProperty("TradeSearchType")
    public Integer getTradeSearchType() {
        return tradeSearchType;
    }

    @JsonProperty("TradeSearchType")
    public void setTradeSearchType(Integer tradeSearchType) {
        this.tradeSearchType = tradeSearchType;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
