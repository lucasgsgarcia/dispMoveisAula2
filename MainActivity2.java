package com.example.exemplo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText edDistancia, edConsumo, edPrecoLitro;
    SeekBar sbQtdePessoas;
    double resultado = 0;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edDistancia = (EditText) findViewById(R.id.edDistancia);
        edConsumo = (EditText) findViewById(R.id.edConsumo);
        edPrecoLitro = (EditText) findViewById(R.id.edPrecoLitro);
        sbQtdePessoas = (SeekBar) findViewById(R.id.sbQtdePessoas);
        txtResultado = (TextView) findViewById(R.id.txtResultado);
    }

    public void calcular(View v){
        try
        {
            double distancia = Double.parseDouble(edDistancia.getText().toString());
            double consumo = Double.parseDouble(edConsumo.getText().toString());
            double precoLitro = Double.parseDouble(edPrecoLitro.getText().toString());
            double pessoas = sbQtdePessoas.getProgress();
            resultado = ((distancia / consumo) * precoLitro) / (pessoas * 1.1);
            edDistancia.setText("");
            edConsumo.setText("");
            edPrecoLitro.setText("");
            System.out.println(resultado);
            txtResultado.setText(String.valueOf(resultado));
        }
        catch (NumberFormatException nfe)
        {
            Toast.makeText(this, "Numero informado incorretamente", Toast.LENGTH_LONG).show();
        }
    }
}