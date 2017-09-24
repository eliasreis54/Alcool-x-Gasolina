package com.eliasreis.carro.alcoolgasolina;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText alcool;
    private EditText gasolina;
    private Button verificar;
    private TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        alcool = (EditText) findViewById(R.id.alcool);
        gasolina = (EditText) findViewById(R.id.gasolina);
        verificar = (Button) findViewById(R.id.verificar);
        resultado = (TextView) findViewById(R.id.resultado);



        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(alcool.getWindowToken(), 0);

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(gasolina.getWindowToken(), 0);

                float valorAlcool = 0, valorGasolina=0;


                try {
                    valorAlcool = Float.parseFloat(alcool.getText().toString());
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "É necessário preencher algum valor para alcool",
                            Toast.LENGTH_SHORT).show();
                }

                try {
                    valorGasolina = Float.parseFloat(gasolina.getText().toString());
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "É necessário preencher algum valor para gasolina",
                            Toast.LENGTH_SHORT).show();
                }

                float valorResultado = (valorAlcool/valorGasolina);
                if (valorResultado < 0.7){
                    resultado.setText("Melhor abastecer com álcool.");
                }
                else{
                    resultado.setText("Melhor abastecer com gasolina.");
                }
            }
        });
    }
}
