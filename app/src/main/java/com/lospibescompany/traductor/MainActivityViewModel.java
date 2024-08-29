package com.lospibescompany.traductor;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.HashMap;

public class MainActivityViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<String> resultado;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.context=application.getApplicationContext();
    }

    public LiveData<String> getResultado(){
        if (resultado == null){
            this.resultado = new MutableLiveData<>();
        }
        return resultado;
    }

    public void traducir(String palabra){
        HashMap<String, String> palabras = new HashMap<>();
        palabras.put("negro", "black");
        palabras.put("rojo", "red");
        palabras.put("amarillo", "yellow");
        palabras.put("violeta", "violet");
        palabras.put("rosa", "pink");
        palabras.put("blanco", "white");
        palabras.put("azul", "blue");


        if(palabras.get(palabra) != null){
            resultado.setValue(palabras.get(palabra));
        }
        else{
            resultado.setValue("No se encontro su palabra");
        }


    }
}
