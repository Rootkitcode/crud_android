package com.rootkit.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rootkit.crud.db.DbContactos;

public class NuevoActivity extends AppCompatActivity {

    EditText txtNombre, txtTelefono, txtCorreo_Electronico;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtNombre = findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtCorreo_Electronico = findViewById(R.id.txtCorreo_Electronico);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbContactos dbContactos = new DbContactos(NuevoActivity.this);
               long id = dbContactos.insertaContacto(txtNombre.getText().toString(), txtTelefono.getText().toString(),
                       txtCorreo_Electronico.getText().toString());
               if(id > 0){
                   Toast.makeText(NuevoActivity.this, "REGISTRO GUARDADO CORRECTAMENTE", Toast.LENGTH_LONG).show();
                   limpiar();
               } else {
                   Toast.makeText(NuevoActivity.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
               }

            }
        });
    }

    private  void limpiar(){
        txtNombre.setText("");
        txtTelefono.setText("");
        txtCorreo_Electronico.setText("");
    }
}