package ronny.sousa.applistacontato.dao

import ronny.sousa.applistacontato.models.Contato

public  class DaoContatos {
    var listaContatos:ArrayList<Contato> = ArrayList();

    public fun getLista():ArrayList<Contato> {
        return listaContatos
    }

    init {

        var contato1:Contato = Contato("Fulano","fulano@tanto.faz","11 1234-1234","Rua do fulano","")
        var contato2:Contato = Contato("Beltrano","fulano@tanto.faz","11 1234-1234","Rua do fulano","")
        var contato3:Contato = Contato("Deltrano","fulano@tanto.faz","11 1234-1234","Rua do fulano","")
        listaContatos.add(contato1)
        listaContatos.add(contato2)
        listaContatos.add(contato3)

    }

    public fun CadastraContato(contato:Contato){
        listaContatos.add(contato)
    }

    public fun AtualizaContato(contato:Contato,posicao:Int){
        listaContatos.set(posicao,contato)
    }

    public fun RemoveContato(posicao: Int){
        listaContatos.removeAt(posicao)
    }



}