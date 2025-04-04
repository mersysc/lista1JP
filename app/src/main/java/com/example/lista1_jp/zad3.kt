package com.example.lista1_jp

/**
 * @author Maria Cicirko
 *
 * Zadanie 3
 * Napisz funkcje podzbiory, która dla zadanego zbioru x zwróci
 * liste wszystkich podzbiorów, np. dla x = {a, b, c, d}, funkcja
 * powinna zwrócic {a, b, c, d}, {a, b, c}, {a, b, d}, {a, c, d},
 * {b, c, d}, {a, b}, {a, c}, {a, d}, {b, c}, {b, d}, {c, d}, {a},
 * {b}, {c}, {d}, {}, w dowolnej kolejnosci. Funkcja powinna
 * sprawdzac poprawnosc argumentu.
 *
 * Sources:
 * ChatGPT - addAll() vs add()
 *
 */


/**
 * Funkcja tworzy liste wszystkich mozliwych podzbiorow dla podanego
 * zbioru
 *
 * @param zbior [List<String>] - zbior lancuchow znakow w postaci
 * listy
 * @return [MutableList<List<String>>] - lista podzbiorow
 * reprezentowanych przez listy lancuchow znakow
 */
fun podzbiory(zbior: List<String>): MutableList<List<String>> {
    val listaPodzbiorow: MutableList<List<String>> = mutableListOf()

    listaPodzbiorow.add(emptyList()) // podzbior pusty

    // petla dla kazdego elementu ze zbioru
    for (i in zbior) {
        val nastepny: MutableList<List<String>> = mutableListOf()
        // dla
        for (j in listaPodzbiorow) {
            val nowy = j + i
            nastepny.add(nowy)
        }
        listaPodzbiorow.addAll(nastepny)
    }

    return listaPodzbiorow
}

fun main(){
    val zbior = listOf("a", "b", "c")
    println(podzbiory(zbior))

}
// wykonac wszystkie mozlliwe podzbiory z pierwszym elementem
