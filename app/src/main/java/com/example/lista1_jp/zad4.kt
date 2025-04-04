package com.example.lista1_jp

/**
 * @author: Maria Cicirko
 *
 * Zadanie 4
 * Zaimplementuj funkcje, która dla zadanego n obliczy i zwróci liste n pierwszych
 * elementów ciagu Fibonacciego. Zadanie wykonaj w dwóch wariantach, wykorzystujac:
 * a) iteracje (petle),
 * b) rekursje.
 * Obie funkcje powinny sprawdzac warunki poczatkowe i w razie ich niespełnienia rzucac
 * wyjatki.
 *
 * Sources:
 * ChatGPT - analiza kodu dla rekurencyjnego rozwiazania
 * Wikipedia - analiza dzialania ciagu Fibbonacciego
 *
 */


/**
 * Funkcja zwraca n-elementowa tablice ciagu Fibbonacciego dzialajac
 * na petli for
 *
 * @param n [Int] - liczba elementow ciagu Fibbonaciego do
 * wyswietlenia typu calkowitego
 * @return [IntArray] tablica n-elementowa liczb calkowitych ciagu
 * Fibbonaciego
 */
fun loopFibbonacci(n: Int): IntArray{
    val newArray = IntArray(n){0}

    if(n>1) {
        newArray[0] = 0
        newArray[1] = 1
        for (i in 2 until newArray.size) {
            newArray[i] = newArray[i - 1] + newArray[i - 2]
        }
        return newArray
    }else if(n == 1){
        newArray[0] = 0
        return newArray
    }else{
        throw IllegalArgumentException("Liczba elementow nie moze byc ujemna lub rowna 0")
    }
}

/**
 * Funkcja zwraca n-elementowa tablice ciagu Fibbonacciego dzialajac
 * na rekurencji
 *
 * @param n [Int] - liczba elementow ciagu Fibbonaciego do
 * wyswietlenia typu calkowitego
 * @return [IntArray] tablica n-elementowa liczb calkowitych ciagu
 * Fibbonaciego
 */
fun recursionFibbonacci(n: Int): IntArray{
    if(n<=0){
        throw IllegalArgumentException("Ilosc elementow ciagu " +
                "musi byc wieksza od 0!")
    }
    val f0 = 0
    val f1 = 1
    if (n == 1) return intArrayOf(f0)
    if (n == 2) return intArrayOf(f0, f1)

    val poprzednie = recursionFibbonacci(n - 1)
    val kolejne = poprzednie[poprzednie.size - 1] +
            poprzednie[poprzednie.size - 2]
    return poprzednie + kolejne
}


fun main(){
    println(loopFibbonacci(5).joinToString())
    println(recursionFibbonacci(6).joinToString())

}