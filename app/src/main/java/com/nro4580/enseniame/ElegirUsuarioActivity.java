package com.nro4580.enseniame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ElegirUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_usuario);
    }

    /**
     * Permite iniciar la activity RegistrarProfesor, para registrarlo si es la primera
     * vez o si ya tiene cuenta para modificar los datos del profesor...
     * @param v
     */
    public void onClickProfesorActivityRegistro(View v){
        startActivity(new Intent(this,RegistrarProfesorActivity.class));
    }

    /**
     * Permite iniciar la activity ElegirInstrumentoAlumno, para que el alumno
     * elija el instrumento que desea aprender...
     * @param v
     */
    public void onClickAlumnoActivityElegirInstrumento(View v){
        startActivity(new Intent(this,ElegirInstrumentoAlumnoActivity.class));
    }

}
