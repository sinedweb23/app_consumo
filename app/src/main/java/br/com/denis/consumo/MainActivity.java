package br.com.denis.consumo;

import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Switch switchArCondicionado, switchIluminacao, switchSistemaSom;
    private TextView textViewConsumo, textViewEquipamentos;

    private int consumoTotal = 0;
    private final int CONSUMO_POR_EQUIPAMENTO = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referências dos componentes
        switchArCondicionado = findViewById(R.id.switchArCondicionado);
        switchIluminacao = findViewById(R.id.switchIluminacao);
        switchSistemaSom = findViewById(R.id.switchSistemaSom);
        textViewConsumo = findViewById(R.id.textViewConsumo);
        textViewEquipamentos = findViewById(R.id.textViewEquipamentos);

        // Adicionando listeners para os switches
        switchArCondicionado.setOnCheckedChangeListener((buttonView, isChecked) -> atualizarConsumo());
        switchIluminacao.setOnCheckedChangeListener((buttonView, isChecked) -> atualizarConsumo());
        switchSistemaSom.setOnCheckedChangeListener((buttonView, isChecked) -> atualizarConsumo());
    }

    private void atualizarConsumo() {
        StringBuilder equipamentosLigados = new StringBuilder("Equipamentos Ligados:\n");
        consumoTotal = 0;

        // Verificando se os equipamentos estão ligados e atualizando o consumo
        if (switchArCondicionado.isChecked()) {
            consumoTotal += CONSUMO_POR_EQUIPAMENTO;
            equipamentosLigados.append("Ar Condicionado\n");
        }

        if (switchIluminacao.isChecked()) {
            consumoTotal += CONSUMO_POR_EQUIPAMENTO;
            equipamentosLigados.append("Iluminação\n");
        }

        if (switchSistemaSom.isChecked()) {
            consumoTotal += CONSUMO_POR_EQUIPAMENTO;
            equipamentosLigados.append("Sistema de Som\n");
        }

        // Atualizando o texto com a lista de equipamentos e consumo total
        textViewEquipamentos.setText(equipamentosLigados.toString());
        textViewConsumo.setText("Consumo Total: " + consumoTotal + " kWh");
    }
}
