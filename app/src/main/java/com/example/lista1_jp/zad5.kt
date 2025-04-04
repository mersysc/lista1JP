package com.example.lista1_jp
import androidx.collection.MutableIntList
import androidx.collection.MutableIntSet

/**
 * @author: Maria Cicirko
 *
 *
 * Zadanie 5
 * Napisz funkcje collatz, która dla zadanego parametru c0 obliczy
 * i zwróci wszystkie kolejne elementy ciagu przed wpadnieciem
 * w cykl:
 * - c(n+1) = 1/2 * c(n) -> gdy c(n) jest parzyste,
 * - c(n+1) = 3 * c(n) + 1 -> gdy c(n) jest nieparzyste,
 * gdzie n nalezy do {0, 1, 2, . . .}, a c0 jest dowolna liczba
 * naturalna. Ciag ten jest zwiazany z problemem Collatza: Czy
 * niezaleznie od wybranej wartosci c0, ciag wpadnie ostatecznie
 * w cykl (4, 2, 1)? Pytanie to pozostaje jak dotad bez odpowiedzi...
 * Wykonaj testy i zanotuj maksymalna wartosc elementu ciagu oraz
 * maksymalna długosc ciagu — przed wpadnieciem ciagu w cykl, a takze
 * odpowiadajace im wartosci c0.
 *
 *
 */

/**
 * Funkcja dla dowolnego parametru c0 wykonuje operacje
 * ciagu colatza
 *
 * @param c0 [Int] - dodatnia liczba calkowita lub mniejsza od zera
 * @return [MutableList<Int>] lista elementow ciagu przed wpadnieciem
 * w cykl (4,2,1)
 */
fun collatz(c0: Int): MutableList<Int>{
    if(c0<1){
        throw IllegalArgumentException("Element c0 musi byc wiekszy" +
                "od 1")
    }
    val tab : MutableList<Int> = mutableListOf(c0)
    var cn = c0
    while(cn != 1) {
        if (cn % 2 == 0) {
            cn /= 2
            tab.add(cn)
        } else if (cn % 2 != 0) {
            cn = 3 * cn + 1
            tab.add(cn)
        }
    }
    return tab

}

fun main(){
    var c0 = 20
    val result = collatz(c0)
    val dlugosc = result.size - 3 // nie wliczamy 3 ostatnich bo to cykl
    val max = result.max()
    println(result.joinToString())
    println("Dlugosc przed wpadnieciem w cykl: $dlugosc")
    println("Najwieksza wartosc dla c0 = $c0 to: $max")
}