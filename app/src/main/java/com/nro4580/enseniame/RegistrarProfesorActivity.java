package com.nro4580.enseniame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import models.Ubicacion;

public class RegistrarProfesorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_profesor);
    }

    public void onClickCrearProfesorActivity(View v){
        startActivity(new Intent(this,CrearProfesorActivity.class));
    }

    public void onClickModificarProfesorActivity(View v){
        startActivity(new Intent(this,ModificarProfesorActivity.class));
    }

    public void onClickEliminarProfesorActivity(View v){
        startActivity(new Intent(this,EliminarProfesorActivity.class));
    }


}
