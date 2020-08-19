package ru.test.currencyconverter.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import ru.test.currencyconverter.R;
import ru.test.currencyconverter.currency.Converter;
import ru.test.currencyconverter.currency.CourseLoader;
import ru.test.currencyconverter.currency.cbr.Currency;

public class MainActivity extends AppCompatActivity {



    private EditText etA, etB;
    private TextView tvA, tvB;
    private Converter converter;
    private Spinner spinnerA;
    private Spinner spinnerB;
    private ArrayAdapter<String> adapterA;
    private ArrayAdapter<String> adapterB;
    private List<String> valutes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            init();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Toast toast = Toast.makeText(getApplicationContext(),
                    e.getMessage(), Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private void init() throws InterruptedException {
        etA =  findViewById(R.id.etA);
        etB =  findViewById(R.id.etB);
        etA.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                setSumB();
                return true;
            }
        });
        etB.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                setSumA();
                return true;
            }
        });

        tvA =findViewById(R.id.tvA);
        tvB =findViewById(R.id.tvB);


        valutes =  Converter.valute.getCharCodeList();

        // Если не удалось загрузить по сети
        // то грузим старые данные из файла
        if (Converter.valute==null) {

            Toast toast = Toast.makeText(getApplicationContext(),
                    "Не удалось получить актуальные данные о валюте", Toast.LENGTH_SHORT);
            toast.show();
            CourseLoader courseLoader = new CourseLoader(getResources().openRawResource(R.raw.data));
            courseLoader.start();
            courseLoader.join();
        }

        converter = new Converter("RUB", "USD");
        etB.setText("1");
        etA.setText(converter.convertFromB("1"));

        spinnerA = findViewById(R.id.spA);
        spinnerB = findViewById(R.id.spB);



        adapterA = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,
                valutes);
        adapterB = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,
                valutes);
        adapterA.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapterB.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerA.setAdapter(adapterA);
        spinnerB.setAdapter(adapterB);
        spinnerA.setPrompt("Выберите валюту");
        spinnerB.setPrompt("Выберите валюту");
        spinnerA.setSelection(Converter.valute.getIDFromCharCode("RUB"));
        spinnerB.setSelection(Converter.valute.getIDFromCharCode("USD"));

        spinnerA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // показываем позиция нажатого элемента
                setValuteA();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        spinnerB.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // показываем позиция нажатого элемента
                setValuteB();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        updateNameA();
        updateNameB();
    }

    public void setSumA(){
        etA.setText(
                converter.convertFromB( etB.getText().toString())
        );
    }

    public void setSumB(){
        etB.setText(
                converter.convertFromA( etA.getText().toString())
        );
    }

    public void setValuteA(){
        converter.setA(spinnerA.getSelectedItem().toString());
        setSumB();
        updateNameA();
    }

    public void setValuteB(){
        converter.setB(spinnerB.getSelectedItem().toString());
        setSumA();
        updateNameB();
    }

    public void swapValute(View view){

       int buf =  spinnerA.getSelectedItemPosition();
       spinnerA.setSelection(spinnerB.getSelectedItemPosition());
       spinnerB.setSelection(buf);
       String bufS = etA.getText().toString();
       etA.setText(etB.getText().toString());
       etB.setText(bufS);

       converter.swap();
       updateNameA();
       updateNameB();
    }

    public void updateNameA(){
        Currency cur = converter.getA();
        tvA.setText(cur.name);
    }
    public void updateNameB(){
        Currency cur = converter.getB();
        tvB.setText(cur.name);
    }

}
