package ronny.sousa.applistacontato.models

import kotlinx.serialization.Serializable

@Serializable
data class Contato(
    var nome: String,
    var email: String,
    var telefone: String,
    var endereco: String,
    var foto : String
):java.io.Serializable
