package br.unisanta.appcadastroaluno

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.random.Random

class AlunoActivity : AppCompatActivity(R.layout.activity_aluno) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txvNome = findViewById<TextView>(R.id.txv_aluno_nome)
        val txvRA = findViewById<TextView>(R.id.txv_aluno_ra)
        val btnGerarRa = findViewById<Button>(R.id.btn_gerar_ra)
        val fabVoltar = findViewById<FloatingActionButton>(R.id.fab_voltar)

        val nome = intent.getStringExtra("nome")
        txvNome.text = "Nome do aluno: $nome"

        btnGerarRa.setOnClickListener {
            val ra = Random.nextInt(100000, 999999).toString()
            txvRA.text = "RA do aluno: $ra"
        }

        fabVoltar.setOnClickListener {
            finish()
        }
    }
}