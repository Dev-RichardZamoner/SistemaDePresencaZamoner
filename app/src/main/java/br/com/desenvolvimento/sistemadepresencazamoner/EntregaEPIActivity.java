package br.com.desenvolvimento.sistemadepresencazamoner;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EntregaEPIActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "EpiPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrega_epi);

        // Atualização da data e hora
        TextView tvDateTime = findViewById(R.id.tvDateTime);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        String currentDateAndTime = sdf.format(new Date());
        tvDateTime.setText(currentDateAndTime);

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        // Configuração dos CheckBoxes e EditTexts
        configureEPI("Clesio", "Capacete", R.id.checkboxClesioCapacete, R.id.etDataClesioCapacete);
        configureEPI("Clesio", "Luvas", R.id.checkboxClesioLuvas, R.id.etDataClesioLuvas);
        configureEPI("Angelica", "Capacete", R.id.checkboxAngelicaCapacete, R.id.etDataAngelicaCapacete);
        configureEPI("Angelica", "Luvas", R.id.checkboxAngelicaLuvas, R.id.etDataAngelicaLuvas);
        configureEPI("Richard", "Capacete", R.id.checkboxRichardCapacete, R.id.etDataRichardCapacete);
        configureEPI("Richard", "Luvas", R.id.checkboxRichardLuvas, R.id.etDataRichardLuvas);
        configureEPI("Adriano", "Capacete", R.id.checkboxAdrianoCapacete, R.id.etDataAdrianoCapacete);
        configureEPI("Adriano", "Luvas", R.id.checkboxAdrianoLuvas, R.id.etDataAdrianoLuvas);
    }

    private void configureEPI(String nome, String epi, int checkboxId, int editTextId) {
        CheckBox checkBox = findViewById(checkboxId);
        EditText editText = findViewById(editTextId);

        // Carregar estado dos CheckBoxes e EditTexts
        checkBox.setChecked(sharedPreferences.getBoolean(nome + "_" + epi, false));
        editText.setText(sharedPreferences.getString(nome + "_" + epi + "_data", ""));

        // Salvar estado dos CheckBoxes e EditTexts
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(nome + "_" + epi, isChecked);
            editor.apply();
        });

        editText.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(nome + "_" + epi + "_data", editText.getText().toString());
                editor.apply();
            }
        });
    }
}