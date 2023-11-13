package ronny.sousa.applistacontato

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import ronny.sousa.applistacontato.models.Contato

class EditarContatoActivity : AppCompatActivity() {
    lateinit var contato:Contato
    lateinit var btSalvar:Button
    lateinit var txtNome:EditText
    lateinit var txtEmail:EditText
    lateinit var txtTelefone:EditText
    lateinit var txtEndereco:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_contato)

        btSalvar = findViewById(R.id.btSalvar)

        txtNome = findViewById(R.id.txtNome)
        txtEmail = findViewById(R.id.txtEmail)
        txtTelefone = findViewById(R.id.txtTelefone)
        txtEndereco = findViewById(R.id.txtEndereco)


        btSalvar.setOnClickListener {
            salvarContato()
        }

    }

    private fun salvarContato() {
        if(!txtNome.text.toString().isNullOrEmpty())
        {
            contato = Contato(
                nome = txtNome.text.toString(),
                email = txtEmail.text.toString(),
                telefone = txtTelefone.text.toString(),
                endereco = txtEndereco.text.toString(),
                foto = ""
            )
            this.intent.putExtra("contato",  contato)

            this.setResult(1,this.intent)
            this.finish()

        }

    }
}