package com.example.t5_a4_conversorunidades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    RadioButton rDec,rBin,rOct,rHex;
    CheckBox cBin,cOct,cHex;
    TextView entrada,sBin,sOct,sHex;
    byte indu;
    int inge;
    GestionSistemas g = new GestionSistemas();

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
        sBin.setEnabled(false);
        sOct = findViewById(R.id.etResOctal);
        sOct.setEnabled(false);
        sHex = findViewById(R.id.etResHExadecimal);
        sHex.setEnabled(false);
    }

    public  void seleccionador(View v){
        if(v.getId()==R.id.cbBinario){
            if(cBin.isChecked())
                indu =1;
        }else if(v.getId()==R.id.cbOctal){
            indu = 2;
            if(cOct.isChecked())
                indu = 1;
        }else{
            if(cHex.isChecked())
                indu = 3;
        }
    }
   public void onClick(View v){
        switch (v.getId()){
            case R.id.rbBinario:
                if(entrada.getText().toString().isEmpty()){
                    sBin.setText("0");
                }else{
                    if(indu==1){
                        sBin.setText(entrada.getText().toString());
                    }else if(indu==2){
                        inge = g.binarioADecimal(Integer.parseInt(entrada.getText().toString()));
                        sOct.setText(g.decimalAOctal(inge));
                    }else{
                        inge=g.binarioADecimal(Integer.parseInt(entrada.getText().toString()));
                        sHex.setText(g.decimalAHexadecimal(inge));
                    }
                }break;
            case R.id.rbDecimal:
                if(entrada.getText().toString().isEmpty()){
                    inge=0;
                    entrada.setText("0");
                    long r = g.decimalABinario(inge);
                    sBin.setText(r+"");
                }else{
                    inge=Integer.parseInt(entrada.getText().toString());
                    if(indu==1){
                        long r =g.decimalABinario(inge);
                        sBin.setText(r+"");
                    }else if(indu==2){
                        sOct.setText(g.decimalAOctal(inge));
                    }else if(indu==3){
                        sHex.setText(g.decimalAHexadecimal(inge));
                    }
                }break;
            case R.id.rbHexadecimal:
                if(entrada.getText().toString().isEmpty()){
                    entrada.setText("0");
                    inge =0;
                }else{
                    inge=Integer.parseInt(entrada.getText().toString());
                    if(indu==1){
                        int b = g.hexadecimalADecimal(entrada.getText().toString());
                        sBin.setText(g.decimalABinario(b)+"");
                    }else if(indu == 2){
                        int o = g.hexadecimalADecimal(entrada.getText().toString());
                        sOct.setText(g.decimalAOctal(o)+"");
                    }else{
                        sHex.setText(entrada.getText().toString());
                    }
                }break;
            case R.id.rbOctal:
                if(entrada.getText().toString().isEmpty()){
                    inge = 0;
                    entrada.setText("0");
                }else{
                    inge = Integer.parseInt(entrada.getText().toString());
                    if(indu==1){
                        int d =g.octalADecimal(inge);
                        long r = g.decimalABinario(d);
                        sBin.setText(r+"");
                    }else if(indu==2){
                        sOct.setText(entrada.getText().toString());
                    }else if(indu==3){
                        int d = g.octalADecimal(inge);
                        sHex.setText(g.decimalAHexadecimal(d));
                    }
                }break;
            default:

        }
   }








}