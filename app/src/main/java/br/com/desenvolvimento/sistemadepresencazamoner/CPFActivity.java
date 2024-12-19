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

public class CPFActivity extends AppCompatActivity {

    private boolean isPresent = false;
    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "PresencaPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpf);

        // Atualização da data e hora
        TextView tvDateTime = findViewById(R.id.tvDateTime);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        String currentDateAndTime = sdf.format(new Date());
        tvDateTime.setText(currentDateAndTime);

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        EditText etCPF = findViewById(R.id.etCPF);
        Button btnMarcarPresenca = findViewById(R.id.btnMarcarPresenca);

        btnMarcarPresenca.setOnClickListener(v -> {
            String cpf = etCPF.getText().toString();
            if (cpf.isEmpty()) {
                Toast.makeText(CPFActivity.this, "Por favor, digite o CPF", Toast.LENGTH_SHORT).show();
            } else {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                if (!isPresent) {
                    String registro = "Entrada: " + currentDateAndTime;
                    editor.putString(cpf + "_entrada", registro);
                    Toast.makeText(CPFActivity.this, "Presença marcada para o CPF: " + cpf, Toast.LENGTH_SHORT).show();
                    btnMarcarPresenca.setText("Desmarcar Presença");
                    isPresent = true;
                } else {
                    String registro = "Saída: " + currentDateAndTime;
                    editor.putString(cpf + "_saida", registro);
                    Toast.makeText(CPFActivity.this, "Presença desmarcada para o CPF: " + cpf, Toast.LENGTH_SHORT).show();
                    btnMarcarPresenca.setText("Marcar Presença");
                    isPresent = false;
                }
                editor.apply();
            }
        });
    }
}