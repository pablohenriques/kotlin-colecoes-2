package br.com.alura

fun main() {

    val pedidos: MutableMap<Int, Double> = mutableMapOf(
        Pair(1, 20.0),
        Pair(2, 34.0),
        3 to 80.0,
        4 to 100.0,
        5 to 150.0,
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
