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


/**
 * Funkcja dla zadanych bokow trojkata a, b, c
 * zwraca pole S wykorzystujac wzor Herona
 *
 * @param a [Double] - dlugosc pierwszego boku trojkata
 * @param b [Double] - dlugosc drugiego boku trojkata
 * @param c [Double] - dlugosc trzeciego boku trojkata
 *
 * @return [Double] pole trojkata z wzoru herona
 * @throws IllegalArgumentException jesli z podanej
 * dlugosci bokow nie mozna stworzyc trojkata lub
 * ich wartosci sa mniejsze lub rowne 0.
 */
@SuppressLint("SuspiciousIndentation")
fun heron(a: Double, b: Double, c: Double): Double {
    var S = 0.0

    if ((a <= 0) || (b <= 0) || (c <= 0)) {
        throw IllegalArgumentException(
            "Bok nie moze byc mniejszy od 0")
    } else if (a + b < c || a + c < b || b + c < a) {
        throw IllegalArgumentException(
            "Suma dlugosci dwoch krotszych bokow musi byc" +
                    " wieksza od dlugosci trzeciego boku ")
    } else {
        val p = 0.5 * (a + b + c)
        S = sqrt(p * (p - a) * (p - b) * (p - c))
        return S
    }
}



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
