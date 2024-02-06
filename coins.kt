import kotlin.collections.listOf

var amount = 11
var result: ArrayList<CoinsAndQuantity> = ArrayList()
fun main() {
    println(minCoins())
}
    

fun minCoins() {
    val coins = listOf(1,2,5).sorted()
    val suma = coins.sum();
    if(suma == amount) {
        println(suma);
        return;
    }
    calculation(coins.size, coins)
    println(result)
    println(sumItems())
    if(sumItems() != amount) println(-1)
    else println(result)
}

private fun sumItems(): Int {
    var data = 0
    result.forEach { item -> 
        data += item.coin * item.quantity
    }
    return data
}

private fun calculation(index: Int, coins: List<Int>) {
    if(index > 0) {
        val divisor = (amount / coins[index-1]).toInt()
        val restante = (amount % coins[index-1]).toInt()
        amount = restante
        divisor.takeIf { it > 0 }?.also {
            result.add(CoinsAndQuantity(coins[index-1], divisor))
        }
        calculation(index - 1, coins)
    }
}

data class CoinsAndQuantity (
    var coin: Int = 0,
    var quantity: Int = 0
)
