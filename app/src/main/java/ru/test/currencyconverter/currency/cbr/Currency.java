package ru.test.currencyconverter.currency.cbr;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Currency {
    @SerializedName("ID")
    @Expose
    public String iD;
    @SerializedName("NumCode")
    @Expose
    public String numCode;
    @SerializedName("CharCode")
    @Expose
    public String charCode;
    @SerializedName("Nominal")
    @Expose
    public Integer nominal;
    @SerializedName("Name")
    @Expose
    public String name;
    @SerializedName("Value")
    @Expose
    public Double value;
    @SerializedName("Previous")
    @Expose
    public Double previous;

    public Currency(){
        charCode = "RUB";
        name = "Российский рубль";
        nominal = 1;
        value = 1.;
    }
}
