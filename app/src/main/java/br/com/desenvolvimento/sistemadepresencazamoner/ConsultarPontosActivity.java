package br.com.desenvolvimento.sistemadepresencazamoner;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class ConsultarPontosActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "PresencaPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_pontos);

        // Atualização da data e hora
        TextView tvDateTime = findViewById(R.id.tvDateTime);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        String currentDateAndTime = sdf.format(new Date());
        tvDateTime.setText(currentDateAndTime);

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        // Exibir registros de presença
        TableLayout tableLayout = findViewById(R.id.tableLayout);
        Map<String, ?> allEntries = sharedPreferences.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            TableRow tableRow = new TableRow(this);

            TextView tvNome = new TextView(this);
            tvNome.setText(entry.getKey().split("_")[0]);
            tvNome.setPadding(10, 10, 10, 10);
            tvNome.setTextColor(getResources().getColor(android.R.color.white));

            TextView tvDataHora = new TextView(this);
            tvDataHora.setText(entry.getValue().toString());
            tvDataHora.setPadding(10, 10, 10, 10);
            tvDataHora.setTextColor(getResources().getColor(android.R.color.white));

            TextView tvStatus = new TextView(this);
            tvStatus.setText(entry.getKey().contains("entrada") ? "Entrada" : "Saída");
            tvStatus.setPadding(10, 10, 10, 10);
            tvStatus.setTextColor(getResources().getColor(android.R.color.white));

            tableRow.addView(tvNome);
            tableRow.addView(tvDataHora);
            tableRow.addView(tvStatus);

            tableLayout.addView(tableRow);
        }

        // Configuração dos botões
        Button btnExportar = findViewById(R.id.btnExportar);
        Button btnLimpar = findViewById(R.id.btnLimpar);

        btnExportar.setOnClickListener(v -> exportarDados());
        btnLimpar.setOnClickListener(v -> limparDados());
    }

    private void exportarDados() {
        Map<String, ?> allEntries = sharedPreferences.getAll();
        StringBuilder dados = new StringBuilder();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            dados.append(entry.getKey()).append(": ").append(entry.getValue().toString()).append("\n");
        }

        try {
            File file = new File(Environment.getExternalStorageDirectory(), "registros_presenca.txt");
            FileWriter writer = new FileWriter(file);
            writer.append(dados.toString());
            writer.flush();
            writer.close();
            Toast.makeText(this, "Dados exportados para registros_presenca.txt", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "Erro ao exportar dados", Toast.LENGTH_SHORT).show();
        }
    }

    private void limparDados() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        recreate(); // Recarregar a atividade para atualizar a tabela
        Toast.makeText(this, "Dados de presença limpos", Toast.LENGTH_SHORT).show();
    }
}