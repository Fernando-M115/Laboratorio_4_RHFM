package com.example.laboratorio_4_rhfm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ActivityPozole extends AppCompatActivity {

    RadioGroup tamanio;
    RadioGroup pozole;
    RadioButton repollo;
    RadioButton cebolla;
    RadioButton maiz;
    RadioButton limon;
    RadioButton tostadas;
    RadioButton oregano;
    RadioButton rabanos;

    RadioButton tamanoPozole;
    RadioButton pozoleTipo;
    EditText ordenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pozole);
        tamanio = findViewById(R.id.radioGroupTamaño);
        pozole = findViewById(R.id.radioGroupPozole);
        repollo = findViewById(R.id.radioRepollo);
        cebolla = findViewById(R.id.radioCebolla);
        maiz = findViewById(R.id.radioMaiz);
        limon = findViewById(R.id.radioLimon);
        tostadas = findViewById(R.id.radioTostadas);
        oregano = findViewById(R.id.radioOregano);
        rabanos = findViewById(R.id.radioRabano);
        ordenes = findViewById(R.id.numeroOrdenes);
    }

    public void OrdenarPedido(View view) {
        tamanoPozole = findViewById(tamanio.getCheckedRadioButtonId());
        pozoleTipo = findViewById(pozole.getCheckedRadioButtonId());

        String tamanioPozole = String.valueOf(tamanoPozole.getText());
        String seleccion = String.valueOf(pozoleTipo.getText());
        String orden = String.valueOf(ordenes.getText());

        String mensajePredefinido= "Orden: "+orden+" "+seleccion+" "+tamanioPozole;
        String extras = "\n\nINGREDIENTES EXTRAS:\n";

        if(repollo.isChecked()){
            extras = extras+"REPOLLO\n";
        }
        if(cebolla.isChecked()){
            extras = extras+"CEBOLLA\n";
        }
        if(maiz.isChecked()){
            extras = extras+"MAIZ\n";
        }
        if(limon.isChecked()){
            extras = extras+"LIMON\n";
        }
        if(tostadas.isChecked()){
            extras = extras+"TOSTADAS\n";
        }
        if(oregano.isChecked()){
            extras = extras+"OREGANO\n";
        }
        if(rabanos.isChecked()){
            extras = extras+"RABANOS\n";
        }


        String mensajeFinal = mensajePredefinido + extras;

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, mensajeFinal);
        intent.setType("text/plain");
        intent.setPackage("com.whatsapp");
        startActivity(intent);
    }
}