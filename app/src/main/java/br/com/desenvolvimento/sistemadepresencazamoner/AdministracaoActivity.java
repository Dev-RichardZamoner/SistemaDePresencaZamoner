package br.com.desenvolvimento.sistemadepresencazamoner;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AdministracaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administracao);

        // Atualização da data e hora
        TextView tvDateTime = findViewById(R.id.tvDateTime);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        String currentDateAndTime = sdf.format(new Date());
        tvDateTime.setText(currentDateAndTime);
    }
}