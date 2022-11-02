package br.com.alura

fun testaCopia() {
    val banco = BancoDeNomes()
    val nomesSalvo: Collection<String> = banco.nomes

    banco.salva("Alex")
    println(banco.nomes)
    println(BancoDeNomes().nomes)
    println(nomesSalvo)
}

class BancoDeNomes {

    val nomes: Collection<String> get() = dados.toList()

    fun salva(nome: String) {
        dados.add(nome)
    }

    companion object {
        private val dados = mutableListOf<String>()
    }
}

fun testaColecao() {
    val nomes: Collection<String> = listOf(
        "Alex",
        "Fran",
        "Gui",
        "Maria",
        "Ana"
    )

    for (nome in nomes) {
        println(nome)
    }

    println(nomes)
    println("Tem o nome Alex? ${nomes.contains("Alex")}")
    println("Tamanho da coleção: ${nomes.size}")
}