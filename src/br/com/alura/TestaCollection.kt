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

fun testaSet() {
    val assistiramCursoAndroid: Set<String> = setOf("Alex", "Fran", "Gui", "Maria")
    val assistiramCursoKotlin: Set<String> = setOf("Alex", "Paulo", "Maria")
    val assistiramAmbos = mutableSetOf<String>()

    assistiramAmbos.addAll(assistiramCursoAndroid)
    assistiramAmbos.addAll(assistiramCursoKotlin)
    assistiramAmbos.add("Ana")
    assistiramAmbos.add("Ana")

    println(assistiramAmbos)

    println(assistiramCursoKotlin + assistiramCursoAndroid)
    println(assistiramCursoKotlin union assistiramCursoAndroid)

    println(assistiramCursoKotlin - assistiramCursoAndroid)
    println(assistiramCursoKotlin subtract assistiramCursoAndroid)

    println(assistiramCursoKotlin intersect assistiramCursoAndroid)

    val assistiramList = assistiramAmbos.toMutableList()
    assistiramList.add("Alex")

    println(assistiramList)
    println(assistiramList.toSet())
}

fun testaComportamentoMap() {
    val pedidos: MutableMap<Int, Double> = mutableMapOf(
        Pair(1, 20.0),
        Pair(2, 34.0),
        3 to 80.0,
        4 to 100.0,
        5 to 100.0,
        6 to 80.0
    )
//    val valorPedido = pedidos.getValue(1)
//    println(valorPedido)

    val mensagem = pedidos.getOrElse(1) { 0.0 }
    println(mensagem)

    println(pedidos.getOrDefault(1, -1.0))
    println(pedidos.getOrDefault(0, -1.0))

    println(pedidos.keys)

    for (p in pedidos.keys) {
        println("número pedido: $p")
    }

    println(pedidos.values)

    for (v in pedidos.values) {
        println("valor pedido: $v")
    }

    val pedidosFiltrados = pedidos.filter { (n, v) ->
        n % 2 == 0 && v > 70
    }
    println(pedidosFiltrados)

    val pedidosAcima = pedidos.filterValues { v ->
        v > 70.0
    }
    println(pedidosAcima)

    val pedidosPares = pedidos.filterKeys { k ->
        k % 2 == 0
    }
    println(pedidosPares)

    println(pedidos + mapOf(7 to 90.0, 8 to 20.0))
    println(pedidos)

    println(pedidos - listOf(6, 5))
    println(pedidos)

    pedidos.keys.remove(1)
    println(pedidos)

    pedidos.values.remove(100.0)
    println(pedidos)

    pedidos -= 6
    println(pedidos)
}

fun testaMap(pedidos: MutableMap<Int, Double>) {
    val pedido = pedidos[0]
    pedido?.let { println("pedido $it") }

    for (p: Map.Entry<Int, Double> in pedidos) {
        println("número pedido: ${p.key}")
        println("valor pedido: ${p.value}")
    }

    pedidos[4] = 70.0
    println(pedidos)

    pedidos.put(5, 80.0)
    println(pedidos)

    pedidos[1] = 100.0
    println(pedidos)

    pedidos.putIfAbsent(6, 200.0)
    println(pedidos)

    pedidos.putIfAbsent(6, 300.0)
    println(pedidos)

    pedidos.remove(6)
    println(pedidos)

    pedidos.remove(3, 50.0)
    println(pedidos)
}