package models;

/**
 * Created by mtorre4580 on 4/6/16.
 */
public class ReponseAltaProfesor {

    private String status;
    private String error;
    private String msg;

    public ReponseAltaProfesor(String status,String error){
        this.status = status;
        this.error = error;
    }

    public ReponseAltaProfesor(){

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
