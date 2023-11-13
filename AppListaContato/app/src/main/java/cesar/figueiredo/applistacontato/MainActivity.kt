package ronny.sousa.applistacontato

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ronny.sousa.applistacontato.adapters.AdapterContatos
import ronny.sousa.applistacontato.api.RetrofitClient
import ronny.sousa.applistacontato.dao.DaoContatos
import ronny.sousa.applistacontato.models.Contato
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var recyclerContatos:RecyclerView
    lateinit var daoContatos: DaoContatos;
    lateinit var btnCadastrar: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerContatos = findViewById(R.id.recyclerContatos)

        btnCadastrar = findViewById(R.id.fabCadastrar)



        recyclerContatos.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)


        var retrofitCli:RetrofitClient = RetrofitClient()
        retrofitCli.contatoService.getAllContatos().enqueue(
            object: Callback<List<Contato>>{
                override fun onResponse(
                    call: Call<List<Contato>>,
                    response: Response<List<Contato>>
                ) {
                    if(response.body()!=null) {

                        var adapter: AdapterContatos =
                            AdapterContatos(this@MainActivity, response.body()!!)
                        recyclerContatos.adapter = adapter
                    }

                }

                override fun onFailure(call: Call<List<Contato>>, t: Throwable) {
                    Log.e("API", "Falha ao carregar contatos", t )
                }

            }
        )

        btnCadastrar.setOnClickListener { abrirCadastro() }

    }

    private fun abrirCadastro() {
        var intent:Intent = Intent(this,EditarContatoActivity::class.java)
        startActivityForResult(intent,1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==1 && resultCode==1)
        {

        }


    }


}