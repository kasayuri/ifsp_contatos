package com.example.contatos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.contatos.dao.ContatoDAO;
import com.example.contatos.model.Contato;

public class NovoContatoActivity extends AppCompatActivity {

    private EditText etNomeContato;
    private Button btnAdicionar;
    private Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_contato);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNomeContato = findViewById(R.id.etNomeContato);
        btnAdicionar = findViewById(R.id.btnCadastrarContato);
        btnCancelar = findViewById(R.id.btnCancelar);

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contato novoContato = new Contato(0, etNomeContato.getText().toString());
                AddContato(novoContato);
                finish();

            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void AddContato(Contato contato){
        ContatoDAO dao = new ContatoDAO(this);
        dao.inserirContato(contato);
    }
}