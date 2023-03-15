package com.example.laboratorio_4_rhfm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup botones;
    RadioButton radioButton;
    RadioButton telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botones = findViewById(R.id.radioGroup);
        telefono = findViewById(R.id.radioTelefono1);
        telefono.setChecked(true);
    }

    public void Llamar(View view) {
        int radioId = botones.getCheckedRadioButtonId();
        if(radioId != -1){
            radioButton = findViewById(radioId);
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+radioButton.getText()));
            startActivity(intent);
        }
    }

    public void Pedido(View view) {
        Intent intent = new Intent(this, ActivityPozole.class);
        startActivity(intent);
    }
}