package models;

import com.google.gson.Gson;

/**
 * Created by mtorre4580 on 4/6/16.
 */
public class Profesor {

    private String nombre;
    private String email;
    private String cel;
    private float[] ubicacion;
    private String instrumento;

    public Profesor(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public float[] getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(float[] ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

}
