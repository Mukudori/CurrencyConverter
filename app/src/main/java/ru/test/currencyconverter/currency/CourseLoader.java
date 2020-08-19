package ru.test.currencyconverter.currency;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Scanner;

import ru.test.currencyconverter.R;
import ru.test.currencyconverter.currency.cbr.CBR;

public class CourseLoader  extends Thread{
    private Document doc;
    private String urlJson;
    private InputStream fileStream;
    private CBR cbr;
    private boolean online;

    public CourseLoader(String url){
        urlJson = url;
        this.online = true;
    }

    public CourseLoader(InputStream is){

       fileStream = is;
       online=false;
    }



    public void run(){
        Gson g = new Gson();
        if (online) {
            try {
                doc = Jsoup.connect(urlJson).ignoreContentType(true).get();
                Elements element = doc.select("body");

                cbr = g.fromJson(element.text(), CBR.class);

                Converter.valute = cbr.valute;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            Scanner s = new Scanner(fileStream).useDelimiter("\\A");
            String json = s.hasNext() ? s.next() : "";
            cbr = g.fromJson(json, CBR.class);

            Converter.valute = cbr.valute;

        }
        Thread.yield();
    }


}
