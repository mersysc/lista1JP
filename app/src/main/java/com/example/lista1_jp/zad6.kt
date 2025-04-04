package com.example.lista1_jp

/**
 * @author Maria Cicirko
 *
 * Zadanie 6
 * Transkrypcja jest poczatkowym etapem ekspresji genu, podczas
 * którego na bazie czasteczki DNA syntezowana jest czasteczka RNA.
 * Czasteczka DNA składa sie z dwoch nici: kodujacej (nici sensownej),
 * biegnacej w kierunku 5’ do 3’, oraz komplementarnej do niej nici
 * matrycowej (antysensownej), biegnacej w kierunku przeciwnym.
 * Podczas transkrypcji białko zwane polimeraza RNA odczytuje
 * sekwencje nici niekodujacej (biegnacej w kierunku 3’ do 5’) i na
 * jej podstawie syntezuje nowa czasteczke RNA (w kierunku 5’ do 3’).
 * Zatem kolejnosc zasad w nowo powstajacym łancuchu jest odwrócona
 * wzgledem kolejnosci w czasteczce stanowiacej matryce i taka sama
 * jak w nici kodujacej.
 * Zaimplementuj nastepujace funkcje:
 *
 * a) komplement, która dla sekwencji nici kodujacej DNA znajduje
 * i zwraca sekwencje nici matrycowej,
 * b) transkrybuj, która dla sekwencji nici matrycowej DNA znajduje
 * i zwraca sekwencje RNA.
 *
 * Kolejnym etapem ekspresji genu jest translacja, czyli synteza
 * białka na podstawie sekwencji RNA, a konkretniej — mRNA. Kazdy
 * aminokwas w sekwencji białka kodowany jest przez trzy nukleotydy.
 * Takie nienakładajace sie trójki nukleotydów nazywamy kodonami. Jak
 * łatwo zauwazyc, istnieje 64 mozliwych kodonów, podczas gdy
 * wiekszosc białek składa sie z 20 rodzajów aminokwasów. Dzieki tym
 * nadmiarowym kodonom zmiana pojedynczego nukleotydu nie zawsze
 * skutkuje mutacja w białku. Oprócz kodonów przypisanych do
 * konkretnych aminokwasów istnieja tez kodony Stop, które
 * sygnalizuja koniec translacji, oraz kodon AUG, pełniacy podwójna
 * role: kodonu rozpoczynajacego transkrypcje oraz kodujacego
 * aminokwas metionine.
 *
 * Dodatkowo dla chetnych – zaimplementuj funkcje:
 * c) transluj, która dla sekwencji mRNA znajduje i zwraca sekwencje
 * kodowanego przez nie białka. Sekwencje białka zapisz uzywajac
 * 1- albo 3-literowych identyfikatorów aminokwasów.
 *
 * Rozwiazanie zad. 6 powinno zawierac zestaw dwóch lub trzech
 * funkcji rozwiazujacych poszczególne problemy: dla zadanej
 * sekwencji wejsciowej funkcje powinny zwracac oczekiwane sekwencje
 * wynikowe. Nalezy zwrócic uwage na poprawnosc zarówno danych
 * wejsciowych, jak i wyjsciowych. Funkcje nalezy oczywiscie opatrzyc
 * komentarzami dokumentujacymi. Nalezy napisac funkcje testujace,
 * które zademonstruja poprawne rozwiazanie problemów.
 *
 * Sources:
 * ChatGPT - funkcja odwracajaca reversed()
 */


/**
 * Funkcja tworzy nic komplementarna matrycowa dla nici kodujacej DNA
 * wedlug zasad komplementarnosci zasady lacza sie wzajemnie w pary:
 * adenina (A) z tymia (T) oraz guanina (G) z cytozyna (C)
 *
 * @param nicKodujaca [String] - ciag znakow skladajacy sie z liter A, C,
 * T, G, ktore kolejno reprezentuja zasady: adenina, cytozyna,
 * tymina i guanina
 * @return nicMatrycowa [String] - ciag znakow komplementarny do nici
 * kodujacej
 * @throws IllegalArgumentException jesli nic kodujaca jest pustym ciagiem
 * znakow lub zawiera niepoprawne znaki
 */
fun komplement(nicKodujaca: String): String {
    val nic = nicKodujaca.uppercase()
    var nicMatrycowa = ""

    if (nic.isNotEmpty()) {
        for (char in nic) {
            when (char) {
                'A' -> nicMatrycowa += "T"
                'T' -> nicMatrycowa += "A"
                'G' -> nicMatrycowa += "C"
                'C' -> nicMatrycowa += "G"
                else -> throw IllegalArgumentException("STOP -> twoja nic " +
                        "kodujaca moze zawierac tylko znaki: A, G, C, T.")
            }
        }
        return nicMatrycowa
    } else {
        throw IllegalArgumentException("Nic kodujaca nie moze byc pusta!")
    }
}


/**
 * Funkcja wykonuje transkrypcje nici matrycowej do sekwencji RNA,
 * odwraca nic matrycowa do odczytu od 3' do 5', a nastepnie przepisuje
 * na rna wedlug zasad laczenia zasad: adenina (A) z uracylem (U),
 * tymina (T) z adenina (A), guanina (G) z cytozyna (C) oraz
 * cytozyna (C) z guanina (G)
 *
 * @param nicmatrycowa [String] - ciag znakow reprezentujacy nic matrycowa
 * @return [String] sekwencja RNA gotowa do odczytu
 * @throws IllegalArgumentException jesli nic matrycowa jest pustym ciagiem
 * znakow lub zawiera niepoprawne znaki
 */
fun transkrybuj(nicmatrycowa: String): String{
    // przyjmujemy ze nicmatrycowa podawana jest od 3' do 5'
    val nicM = nicmatrycowa.reversed().uppercase()
    var rna = ""

    if (nicM.isNotEmpty()){
        for(char in nicM){

                when (char) {
                    'A' -> rna += "U"
                    'T' -> rna += "A"
                    'G' -> rna += "C"
                    'C' -> rna += "G"
                    else ->  throw IllegalArgumentException("STOP -> twoja" +
                            " nic matrycowa zawiera niepoprawne znaki")
            }
        }
        return rna
    }else {
        throw IllegalArgumentException("Nic matrycowa nie moze byc pusta!")
    }
}



fun main(){
    val nicMatrycowa = komplement("AGGGCT")
    val nicRNA = transkrybuj(nicMatrycowa)
    println("Dla nici matrycowej: $nicMatrycowa, transkrypcja " +
            "zwrocila nic RNA zakodowana: $nicRNA.")

    println(komplement("AGGGCT"))
    println(komplement("AgAtAcc"))
    println(komplement("ag1gcta"))
    println(komplement(""))

}