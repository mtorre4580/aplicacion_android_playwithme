package com.nro4580.enseniame;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import models.Profesor;
import models.ReponseAltaProfesor;
import models.Ubicacion;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import services.ProfesorService;

public class CrearProfesorActivity extends AppCompatActivity{

    private static final String URL_SERVICE = "http://192.168.43.50:3000/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_profesor);
    }

    public void onClickRegistrarse(View v){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_SERVICE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProfesorService profesorService = retrofit.create(ProfesorService.class);

        Call<ReponseAltaProfesor> call = profesorService.registrarProfesor(crearProfesor());

        call.enqueue(new Callback<ReponseAltaProfesor>() {

            @Override
            public void onResponse(Call<ReponseAltaProfesor> call, Response<ReponseAltaProfesor> response) {
                ReponseAltaProfesor responseAltaProfesor = response.body();
                if(responseAltaProfesor.getError().isEmpty()){
                    Toast.makeText(getApplicationContext(), responseAltaProfesor.getMsg(), Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), responseAltaProfesor.getError(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ReponseAltaProfesor> call, Throwable t) {

            }

        });

    }

    private void obtenerProfesoresCercanos(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_SERVICE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProfesorService profesorService = retrofit.create(ProfesorService.class);

        Call<List<Profesor>> call = profesorService.obtenerProfesoresCercanos("-34","-57");

        call.enqueue(new Callback<List<Profesor>>() {
            @Override
            public void onResponse(Call<List<Profesor>> call, Response<List<Profesor>> response) {
                List<Profesor> profesoresCercanos = response.body();
            }

            @Override
            public void onFailure(Call<List<Profesor>> call, Throwable t) {

            }
        });

    }

    /**
     * Permite crear el profesor para enviarlo al servicio ...
     * @return
     */
    private Profesor crearProfesor(){
        EditText editTextNombre = (EditText)findViewById(R.id.editTextNombre);
        EditText editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        EditText editTextCelular = (EditText)findViewById(R.id.editTextCelular);
        Spinner mySpinner=(Spinner) findViewById(R.id.spinnerSeleccionInstrumentos);
        Profesor profesor = new Profesor();
        profesor.setCel(editTextCelular.getText().toString());
        profesor.setEmail(editTextEmail.getText().toString());
        profesor.setNombre(editTextNombre.getText().toString());
        profesor.setInstrumento(mySpinner.getSelectedItem().toString());
        profesor.setUbicacion(new float[]{20,30});
        return profesor;
    }

}
