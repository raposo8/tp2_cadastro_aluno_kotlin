package br.unisanta.appcadastroaluno

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtNome = findViewById<EditText>(R.id.edt_aluno_nome)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)
        val fabMostrar = findViewById<FloatingActionButton>(R.id.fab_mostrar)

        var nome = ""

        btnCadastrar.setOnClickListener {
            nome = edtNome.text.toString()

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Sucesso")
            builder.setMessage("Cadastrado! Ok")
            val dialog = builder.create()
            dialog.show()
        }

        fabMostrar.setOnClickListener {
            val intent = Intent(this, AlunoActivity::class.java)
            intent.putExtra("nome", nome)
            startActivity(intent)
        }
    }
}