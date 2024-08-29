package com.lospibescompany.traductor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mv;

    private Button btTraducir;

    private EditText palabra;

    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Creo el viewModel
        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        //Accedo a los componentes de la vista
        this.palabra= findViewById(R.id.palabra);
        this.btTraducir= findViewById(R.id.btTraducir);
        this.resultado= findViewById(R.id.resultado);

        //Coloco el observer al mutable del viewModel
        mv.getResultado().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String palabra) {
                resultado.setText(palabra);
            }
        });

        //Listener del boton
        this.btTraducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mv.traducir(palabra.getText().toString());
            }
        });

    }
}