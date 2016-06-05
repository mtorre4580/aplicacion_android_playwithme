package services;

/**
 * Created by mtorre4580 on 4/6/16.
 */

import java.util.List;

import models.Profesor;
import models.ReponseAltaProfesor;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ProfesorService {

    @GET("obtener-profesores/{lat}/{long}")
    Call<List<Profesor>> obtenerProfesoresCercanos(@Path("lat") String latitud,@Path("long") String longitud);

    @POST("alta-profesor")
    Call<ReponseAltaProfesor> registrarProfesor(@Body Profesor profesor);

}
