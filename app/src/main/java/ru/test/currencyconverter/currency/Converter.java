package ru.test.currencyconverter.currency;

import java.util.HashMap;

import ru.test.currencyconverter.currency.cbr.CBR;
import ru.test.currencyconverter.currency.cbr.Currency;
import ru.test.currencyconverter.currency.cbr.Valute;

public class Converter {
    private Currency a, b;

    public static Valute valute;

    public Converter(String car1, String car2){
        if (valute!=null) {
            a = valute.getFromCharCode(car1);
            b = valute.getFromCharCode(car2);
        }
        else {
            System.out.println("Valute не инициализирован");
        }

    }

    public void swap(){
        Currency buf;
        buf = a;
        a=b;
        b=buf;
    }

    public Currency getA() {
        return a;
    }




    public String convertFromA(String sA){
        double sumA = 0;
        try {
             sumA = Double.valueOf(sA);
        }catch (NumberFormatException e) {
            System.err.println("Неверный формат строки! (" + sA + ")");

        }


        double baseA = a.value / a.nominal;
        double baseB = b.value / b.nominal;
        double sumB = baseA * sumA / baseB;
        return String.format("%.2f", sumB);
    }

    public String convertFromB(String sB){
        double sumB = 0;
        try {
             sumB=Double.valueOf(sB);
        }catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }

        double baseA = a.value / a.nominal;
        double baseB = b.value / b.nominal;
        double sumA = baseB * sumB / baseA;
        return String.format("%.2f", sumA);
    }

    public void setA(Currency a) {
        this.a = a;
    }
    public void setA(String aCode) {
        this.a = valute.getFromCharCode(aCode);
    }

    public Currency getB() {
        return b;
    }


    public void setB(Currency b) {
        this.b = b;
    }

    public void setB(String bCode) {
        this.b = valute.getFromCharCode(bCode);
    }


}
