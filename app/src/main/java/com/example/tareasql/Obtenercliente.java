package com.example.tareasql;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Obtenercliente extends AppCompatActivity {
    TextView name;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_cliente);

        ClienteDB db = new ClienteDB(getApplicationContext());

        List<ClienteModel> users = db.show_cliente();

        name = findViewById(R.id.cliente);

        for (int i = 0; i < users.size(); i++) {
            name.append("RFC:\t"+ users.get(i).getRfc() + "\nUser:\t" + users.get(i).getName() + "\n\n");
        }
    }
}
