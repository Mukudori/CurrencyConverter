
package ru.test.currencyconverter.currency.cbr;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public  class CBR {

    @SerializedName("Date")
    @Expose
    public String date;
    @SerializedName("PreviousDate")
    @Expose
    public String previousDate;
    @SerializedName("PreviousURL")
    @Expose
    public String previousURL;
    @SerializedName("Timestamp")
    @Expose
    public String timestamp;
    @SerializedName("Valute")
    @Expose
    public Valute valute;

}
