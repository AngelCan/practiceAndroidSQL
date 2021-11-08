package com.example.tareasql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editRFC, editName, editPhone, editEmail;
    Button addbutton, showbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editRFC = (EditText) findViewById(R.id.editRFC);
        editName = (EditText) findViewById(R.id.editName);
        editPhone = (EditText) findViewById(R.id.editPhone);
        editEmail = (EditText) findViewById(R.id.editEmail);
        addbutton = (Button) findViewById(R.id.addbutton);
        showbutton = (Button) findViewById(R.id.showbutton);

        final ClienteDB clienteDB=new ClienteDB(getApplicationContext());

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clienteDB.addCliente(editRFC.getText().toString(), editName.getText().toString(), editPhone.getText().toString(), editEmail.getText().toString());
                Toast.makeText(getApplicationContext(), "Cliente agregado correctamente", Toast.LENGTH_SHORT).show();
            }
        });

        showbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showCliente = new Intent(getApplicationContext(), Obtenercliente.class);
                startActivity(showCliente);
            }
        });
    }
}