package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView Nombre,Direccion,Telefono,Correo;
    private RadioButton Granja,Apartamnto,Casa;
    private CheckBox Psolar, Aegen, Otros;
    private Button Enviar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Nombre = (TextView) findViewById(R.id.txtNombre);
        Direccion = (TextView) findViewById(R.id.txtDireccion);
        Telefono = (TextView) findViewById(R.id.txtTelefono);
        Correo = (TextView) findViewById(R.id.txtCorreoE);
        Granja = (RadioButton) findViewById(R.id.rbGranja);
        Apartamnto = (RadioButton) findViewById(R.id.rbApartamento);
        Casa = (RadioButton) findViewById(R.id.rbCasa);
        Psolar = (CheckBox) findViewById(R.id.chPsolar);
        Aegen = (CheckBox) findViewById(R.id.chAegen);
        Otros = (CheckBox) findViewById(R.id.chOtros);
        Enviar = (Button) findViewById(R.id.btnEnviar);

        Enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Nombre.getText().toString().isEmpty() || Direccion.getText().toString().isEmpty()
                || Telefono.getText().toString().isEmpty() || Correo.getText().toString().isEmpty()){
                    Comprobar();
                } else{
                    Ingreso();
                }
            }
        });

        Casa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Sleccionaste Casa", Toast.LENGTH_SHORT).show();
            }
        });

        Granja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Sleccionaste Granja", Toast.LENGTH_SHORT).show();
            }
        });

        Apartamnto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Sleccionaste Apartamento", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void Comprobar(){
        AlertDialog.Builder OjoManito = new AlertDialog.Builder(MainActivity.this);
        OjoManito.setMessage("Debes llenar los campos!!!").setCancelable(false)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog titulo = OjoManito.create();
        titulo.setTitle("Ojo con eso manito");
        titulo.show();
    }

    public void Ingreso(){
        AlertDialog.Builder OjoManito = new AlertDialog.Builder(MainActivity.this);
        OjoManito.setMessage("Nombre: " + Nombre.getText().toString()
                +"\nDireccion: " + Direccion.getText().toString() + "\nTelefono: " + Telefono.getText().toString()
                + "\nCorreo: " + Correo.getText().toString()).setCancelable(false)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog titulo = OjoManito.create();
        titulo.setTitle("Has ingresado:");
        titulo.show();

        if(Psolar.isChecked() && Aegen.isChecked() && Otros.isChecked()){
            Toast.makeText(MainActivity.this, "Sleccionaste: " + Psolar.getText() + " y "
                    + Aegen.getText() + " y " + Otros.getText(), Toast.LENGTH_SHORT).show();
        }else if(Psolar.isChecked() && Otros.isChecked()){
            Toast.makeText(MainActivity.this, "Sleccionaste: " + Psolar.getText() + " y "
                    + Otros.getText(), Toast.LENGTH_SHORT).show();
        }else if(Aegen.isChecked() && Otros.isChecked()){
            Toast.makeText(MainActivity.this, "Sleccionaste: " + Aegen.getText() + " y "
                    + Otros.getText(),Toast.LENGTH_SHORT).show();
        }else if(Psolar.isChecked() && Aegen.isChecked()){
            Toast.makeText(MainActivity.this, "Sleccionaste: " + Psolar.getText() + " y "
                    + Aegen.getText(),Toast.LENGTH_SHORT).show();
        }else if(Psolar.isChecked()){
            Toast.makeText(MainActivity.this, "Sleccionaste: " + Psolar.getText(),
                    Toast.LENGTH_SHORT).show();
        }else if(Aegen.isChecked()){
            Toast.makeText(MainActivity.this, "Sleccionaste: " + Aegen.getText(),
                    Toast.LENGTH_SHORT).show();
        }else if(Otros.isChecked()){
            Toast.makeText(MainActivity.this, "Sleccionaste: " + Otros.getText(),
                    Toast.LENGTH_SHORT).show();
        }
    }
}