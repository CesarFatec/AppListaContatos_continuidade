package ronny.sousa.applistacontato.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import ronny.sousa.applistacontato.R
import ronny.sousa.applistacontato.models.Contato
import java.util.zip.Inflater

class AdapterContatos(var contexto:Context , var listaContatos:List<Contato>) : Adapter<AdapterContatos.MeuViewHolder>() {

    class MeuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeuViewHolder {
        var inflater:LayoutInflater = LayoutInflater.from(contexto)
        var view =inflater.inflate(R.layout.contato_item,parent,false)
        return MeuViewHolder(view)

    }

    override fun onBindViewHolder(holder: MeuViewHolder, position: Int) {
        val contato:Contato = listaContatos.elementAt(position)
        val txtNome:TextView = holder.itemView.findViewById(R.id.txtNome)
        val txtTelefone:TextView = holder.itemView.findViewById(R.id.txtTelefone)
        txtNome.text = contato.nome
        txtTelefone.text = contato.telefone

    }

    override fun getItemCount(): Int {
        return  this.listaContatos.size
    }


}