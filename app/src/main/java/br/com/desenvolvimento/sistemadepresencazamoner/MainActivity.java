package br.com.desenvolvimento.sistemadepresencazamoner;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Ajuste de padding para as barras do sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Atualização da data e hora
        TextView tvDateTime = findViewById(R.id.tvDateTime);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        String currentDateAndTime = sdf.format(new Date());
        tvDateTime.setText(currentDateAndTime);

        // Configuração dos botões
        Button btnNome = findViewById(R.id.btnNome);
        Button btnConsultarPontos = findViewById(R.id.btnConsultarPontos);
        Button btnEntregaEPI = findViewById(R.id.btnEntregaEPI);
        Button btnOutrasOpcoes = findViewById(R.id.btnOutrasOpcoes);
        Button btnAdministracao = findViewById(R.id.btnAdministracao);

        btnNome.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, NomeActivity.class)));
        btnConsultarPontos.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ConsultarPontosActivity.class)));
        btnEntregaEPI.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, EntregaEPIActivity.class)));
        btnOutrasOpcoes.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, OutrasOpcoesActivity.class)));
        btnAdministracao.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AdministracaoActivity.class)));
    }
}