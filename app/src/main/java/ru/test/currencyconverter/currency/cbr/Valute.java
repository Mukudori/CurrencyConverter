
package ru.test.currencyconverter.currency.cbr;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Valute {

    @SerializedName("AUD")
    @Expose
    public Currency aUD;
    @SerializedName("AZN")
    @Expose
    public Currency aZN;
    @SerializedName("GBP")
    @Expose
    public Currency gBP;
    @SerializedName("AMD")
    @Expose
    public Currency aMD;
    @SerializedName("BYN")
    @Expose
    public Currency bYN;
    @SerializedName("BGN")
    @Expose
    public Currency bGN;
    @SerializedName("BRL")
    @Expose
    public Currency bRL;
    @SerializedName("HUF")
    @Expose
    public Currency hUF;
    @SerializedName("HKD")
    @Expose
    public Currency hKD;
    @SerializedName("DKK")
    @Expose
    public Currency dKK;
    @SerializedName("USD")
    @Expose
    public Currency uSD;
    @SerializedName("EUR")
    @Expose
    public Currency eUR;
    @SerializedName("INR")
    @Expose
    public Currency iNR;
    @SerializedName("KZT")
    @Expose
    public Currency kZT;
    @SerializedName("CAD")
    @Expose
    public Currency cAD;
    @SerializedName("KGS")
    @Expose
    public Currency kGS;
    @SerializedName("CNY")
    @Expose
    public Currency cNY;
    @SerializedName("MDL")
    @Expose
    public Currency mDL;
    @SerializedName("NOK")
    @Expose
    public Currency nOK;
    @SerializedName("PLN")
    @Expose
    public Currency pLN;
    @SerializedName("RON")
    @Expose
    public Currency rON;
    @SerializedName("XDR")
    @Expose
    public Currency xDR;
    @SerializedName("SGD")
    @Expose
    public Currency sGD;
    @SerializedName("TJS")
    @Expose
    public Currency tJS;
    @SerializedName("TRY")
    @Expose
    public Currency tRY;
    @SerializedName("TMT")
    @Expose
    public Currency tMT;
    @SerializedName("UZS")
    @Expose
    public Currency uZS;
    @SerializedName("UAH")
    @Expose
    public Currency uAH;
    @SerializedName("CZK")
    @Expose
    public Currency cZK;
    @SerializedName("SEK")
    @Expose
    public Currency sEK;
    @SerializedName("CHF")
    @Expose
    public Currency cHF;
    @SerializedName("ZAR")
    @Expose
    public Currency zAR;
    @SerializedName("KRW")
    @Expose
    public Currency kRW;
    @SerializedName("JPY")
    @Expose
    public Currency jPY;

    public Currency rUB = new Currency();

    public Currency getFromCharCode(String code){
        switch (code){
            case "AUD": return aUD;
            case "AZN": return aZN;
            case "GBP": return gBP;
            case "AMD": return aMD;
            case "BYN": return bYN;
            case "BGN": return bGN;
            case "BRL": return bRL;
            case "HUF": return hUF;
            case "HKD": return hKD;
            case "DKK": return dKK;
            case "USD": return uSD;
            case "EUR": return eUR;
            case "INR": return iNR;
            case "KZT": return kZT;
            case "CAD": return cAD;
            case "KGS": return kGS;
            case "CNY": return cNY;
            case "MDL": return mDL;
            case "NOK": return nOK;
            case "PLN": return pLN;
            case "RON": return rON;
            case "SGD": return sGD;
            case "XDR": return xDR;
            case "RUB" :return rUB;
            case "TJS": return tJS;
            case "TRY": return tRY;
            case "TMT": return tMT;
            case "UZS": return uZS;
            case "UAH": return uAH;
            case "CZK": return cZK;
            case "SEK": return sEK;
            case "CHF": return cHF;
            case "ZAR": return zAR;
            case "KRW": return kRW;
            case "JPY": return jPY;
            default: return null;
        }
    }

    public List<String> getCharCodeList(){
        String[] strings =  new String[] {"AUD",  "AZN", "GBP", "AMD", "BYN", "BGN", "BRL", "HUF", "HKD", "DKK",
                "USD", "EUR", "INR", "KZT", "CAD", "KGS", "CNY", "MDL", "NOK", "PLN",
                "RON", "RUB", "XDR", "SGD", "TJS", "TRY", "TMT", "UZS", "UAH", "CZK", "SEK",
                "CHF", "ZAR", "KRW", "JPY" };
        return Arrays.asList(strings);
    }

    public int getIDFromCharCode(String charCode){
        List codes = getCharCodeList();
        for (int i=0; i<codes.size(); i++)
            if (codes.get(i) ==charCode)
                return i;
        return -1;
    }



}
