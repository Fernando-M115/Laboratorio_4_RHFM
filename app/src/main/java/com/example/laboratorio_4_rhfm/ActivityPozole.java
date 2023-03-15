package com.example.laboratorio_4_rhfm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class ActivityPozole extends AppCompatActivity {

    RadioGroup tamanio;
    RadioGroup pozole;
    CheckBox repollo;
    CheckBox cebolla;
    CheckBox maiz;
    CheckBox limon;
    CheckBox tostadas;
    CheckBox oregano;
    CheckBox rabanos;
    RadioButton tamanoPozole;
    RadioButton pozoleTipo;
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pozole);
        tamanio = findViewById(R.id.radioGroupTamaño);
        pozole = findViewById(R.id.radioGroupPozole);
        repollo = findViewById(R.id.checkBoxRepollo);
        cebolla = findViewById(R.id.checkBoxCebolla);
        maiz = findViewById(R.id.checkBoxMaiz);
        limon = findViewById(R.id.checkBoxLimon);
        tostadas = findViewById(R.id.checkBoxTostadas);
        oregano = findViewById(R.id.checkBoxOregano);
        rabanos = findViewById(R.id.checkBoxRabano);
        spinner = findViewById(R.id.spinnerOrden);
        adapter  = ArrayAdapter.createFromResource(this, R.array.numeros_Orden, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void OrdenarPedido(View view) {
        tamanoPozole = findViewById(tamanio.getCheckedRadioButtonId());
        pozoleTipo = findViewById(pozole.getCheckedRadioButtonId());

        String tamanioPozole = String.valueOf(tamanoPozole.getText());
        String seleccion = String.valueOf(pozoleTipo.getText());
        String orden = (String)spinner.getSelectedItem();

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


        String whats = "whatsapp://send?phone=14494538180";
        String mensajeFinal = mensajePredefinido + extras;
        Uri uri = Uri.parse(whats+"&text="+mensajeFinal);
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.whatsapp");
        startActivity(intent);
    }
}