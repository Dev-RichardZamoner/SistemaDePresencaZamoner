package br.com.desenvolvimento.sistemadepresencazamoner;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NomeActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "PresencaPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nome);

        // Atualização da data e hora
        TextView tvDateTime = findViewById(R.id.tvDateTime);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        String currentDateAndTime = sdf.format(new Date());
        tvDateTime.setText(currentDateAndTime);

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        EditText etNome = findViewById(R.id.etNome);
        Button btnMarcarPresenca = findViewById(R.id.btnMarcarPresenca);
        Button btnDesmarcarPresenca = findViewById(R.id.btnDesmarcarPresenca);

        btnMarcarPresenca.setOnClickListener(v -> {
            String nome = etNome.getText().toString();
            if (nome.isEmpty()) {
                Toast.makeText(NomeActivity.this, "Por favor, digite o nome", Toast.LENGTH_SHORT).show();
            } else {
                String registro = "Entrada: " + currentDateAndTime;
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(nome + "_entrada", registro);
                editor.apply();
                Toast.makeText(NomeActivity.this, "Presença marcada para: " + nome, Toast.LENGTH_SHORT).show();
            }
        });

        btnDesmarcarPresenca.setOnClickListener(v -> {
            String nome = etNome.getText().toString();
            if (nome.isEmpty()) {
                Toast.makeText(NomeActivity.this, "Por favor, digite o nome", Toast.LENGTH_SHORT).show();
            } else {
                String registro = "Saída: " + currentDateAndTime;
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(nome + "_saida", registro);
                editor.apply();
                Toast.makeText(NomeActivity.this, "Presença desmarcada para: " + nome, Toast.LENGTH_SHORT).show();
            }
        });
    }
}