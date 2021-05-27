package com.example.t5_a4_conversorunidades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    RadioButton rDec,rBin,rOct,rHex;
    CheckBox cBin,cOct,cHex;
    EditText entrada,sBin,sOct,sHex;
    int rb = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rDec = findViewById(R.id.rbDecimal);
        rBin = findViewById(R.id.rbBinario);
        rOct = findViewById(R.id.rbOctal);
        rHex = findViewById(R.id.rbHexadecimal);

        cBin = findViewById(R.id.cbBinario);
        cOct = findViewById(R.id.cbOctal);
        cHex = findViewById(R.id.cbHexadeciaml);

        entrada = findViewById(R.id.etEntrada);
        sBin = findViewById(R.id.etResBinario);
        sOct = findViewById(R.id.etResOctal);
        sHex = findViewById(R.id.etResHExadecimal);

    }
    public void rbDecimalChecado(View v){
        rb = 1;
    }
    public void rbBinarioChecado(View v){
        rb = 2;
    }
    public void rbOctalChecado(View v){
        rb = 3;
    }
    public void rbHexadecimalChecado(View v){
        rb = 4;
    }




}