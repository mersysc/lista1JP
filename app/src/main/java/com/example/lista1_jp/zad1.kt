package com.example.lista1_jp
import android.annotation.SuppressLint
import kotlin.math.sqrt

/**
 * @author Maria Cicirko
 *
 * Zadanie 1
 * Napisz funkcje heron, która dla zadanych boków a, b i c oblicza
 * i zwraca pole trójkata S wykorzystujac wzór Herona. Funkcja
 * powinna sprawdzac warunki poczatkowe (tutaj: poprawnosc
 * argumentów) oraz rzucic wyjatek, jesli nie sa spełnione
 * lub trójkat o zadanych bokach nie istnieje.
 *
 * Sources:
 * https://pl.wikipedia.org/wiki/Wz%C3%B3r_Herona -> wzór Herona
 *
 */

fun main(){

    // kiedy suma krotszych bokow jest mniejsza od trzeciego
    var wynik = heron(1.0, 12.0, 9.0)
    println("Pole trojkata: $wynik \n")

    // kiedy wszystko dziala prawidlowo
    wynik = heron(10.0, 10.0, 10.0)
    println("Pole trojkata: $wynik \n")

    // kiedy jeden z bokow jest ujemny
    wynik = heron(9.0, -10.0, 10.0)
    println("Pole trojkata: $wynik \n")

    // kiedy jeden z bokow wynosi 0
    wynik = heron(10.0, 10.0, 0.0)
    println("Pole trojkata: $wynik \n")
}


/**
 * Funkcja dla zadanych bokow trojkata a, b, c
 * zwraca pole S wykorzystujac wzor Herona
 *
 * @param a dlugosc pierwszego boku trojkata [Double]
 * @param b dlugosc drugiego boku trojkata  [Double]
 * @param c dlugosc trzeciego boku trojkata  [Double]
 *
 * @return S
 */
@SuppressLint("SuspiciousIndentation")
fun heron(a: Double, b: Double, c: Double): Double {
    var S = 0.0

        if ((a <= 0) || (b <= 0) || (c <= 0)) {
            println("Bok nie moze byc mniejszy od 0")
            return S
        } else if (a + b < c || a + c < b || b + c < a) {
            println(
                "Suma dlugosci dwoch krotszych bokow musi byc" +
                        " wieksza od dlugosci trzeciego boku ")
            return S
        } else {
            val p = 0.5 * (a + b + c)
            S = sqrt(p * (p - a) * (p - b) * (p - c))
            return S
        }
}
