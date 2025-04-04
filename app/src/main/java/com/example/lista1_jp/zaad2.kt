package com.example.lista1_jp

import androidx.collection.IntList
import androidx.collection.intListOf
import kotlin.collections.MutableList


/**
 * @author: Maria Cicirko
 *
 * Zadanie 2
 * Napisz funkcje wspolne, która dla dwóch multizbiorów x i y zwróci ich czesc
 * wspólna. Funkcja powinna sprawdzac poprawnosc argumentów.
 *
 * Sources:
 * https://pl.wikipedia.org/wiki/Multizbi%C3%B3r - definicja multizbioru
 */


/**
 * Funkcja wyznacza czesc wspolna dwoch multizbiorow
 *
 * @param x [IntList] - multizbior typu listy liczb calkowitych
 * @param y [IntList] - multizbior typu listy liczb calkowitych
 * @return [MutableList<Int>] czesc wspolna multizbiorow
 */
fun wspolne(x: IntList, y: IntList): MutableList<Int> {
    val newList : MutableList<Int> = mutableListOf()
    val yToRemove : MutableList<Int> = mutableListOf()
    if(x.isNotEmpty() && y.isNotEmpty()) {
        for (i in 0 until y.size) {
            yToRemove.add(y[i]) // kopia y do usuwania wystapien
        }
        for (i in x.indices) {
            if (yToRemove.contains(x[i])) {
                newList.add(x[i])
                yToRemove.remove(x[i])
            }
        }
    }else{
        throw IllegalArgumentException("Podane listy sa puste," +
                " nie ma czesci wspolnej")
    }
    return newList
}


/**
 * Funkcja testujaca funkcje wspolne
 *
 * @return ilosc niepoprawnych przejsc testow
 */
fun testWspolne(): Int{
    var counter = 0
    try {
        val x = intListOf()
        val y = intListOf()
        val sumXY = wspolne(x, y)
        println("Czesc wspolna multizbioru $x i multizbioru $y" +
                " wynosi $sumXY")
        counter++
    }catch(e: IllegalArgumentException){
        println("Test rzuca wyjatek - poprawne")
    }
    try {
        val x = intListOf(2, 4, 8 ,5, 5, 2)
        val y = intListOf(1, 3, 4, -3, 5, 7, 2, 2)
        val sumXY = wspolne(x, y)
        assert(sumXY == intListOf(2, 4, 5, 2)) {
            counter++
        }
    }catch (e:AssertionError){
        println("Test rzuca wyjatek - niepoprawne")
    }
    return counter
}
// brakuje weryfikacji czy to multizbior czyli czy jakis element sie powtarza

fun main(){
    val count = testWspolne()
    println("Ilosc niepoprawnych testow: $count")
}