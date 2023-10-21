package com.marcelo.preferenciascompartidas;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenciaManager {

    Context context;

    PreferenciaManager (Context contextRecibido){
        this.context = contextRecibido;

    }
    public void salvarLoginDetalles(String email, String password){
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDatos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email", email);
        editor.putString("password", password);
        editor.commit();
    }
    public String getEmail(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDatos", Context.MODE_PRIVATE);
        return sharedPreferences.getString("email", "");
    }
    public boolean isUsuarioLogedOut(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDatos", Context.MODE_PRIVATE);
        boolean isEmailVacio = sharedPreferences.getString("Email", "").isEmpty();
        boolean isPasswordVacio = sharedPreferences.getString("Password", "").isEmpty();

        return isEmailVacio || isPasswordVacio;

    }

}
