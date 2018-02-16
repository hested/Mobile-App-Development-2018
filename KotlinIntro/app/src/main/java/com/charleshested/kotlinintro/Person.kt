package com.charleshested.kotlinintro

/**
 * Project:  KotlinIntro
 * Package:  com.charleshested.kotlinintro
 * Date:     15-02-2018
 * Time:     23:50
 * Author:   Johnni Hested
 */
data class Person(val name: String, val age: Int, val mother: String)

fun getPersons(): List<Person> {

    val eve = Person("eve", 100, "eve's mother")

    val kate = Person("kate", 100, "eve")
    val britt = Person("britt", 100, "eve")

    val parker = Person("parker", 100, "kate")
    val alex = Person("alex", 100, "kate")
    val jones = Person("jones", 100, "kate")
    val emma = Person("emma", 100, "britt")
    val isabella = Person("isabella", 100, "britt")
    val paul = Person("paul", 100, "britt")

    val persons = listOf(eve, kate, britt, parker, alex, jones, emma, isabella, paul)

    return persons
}



fun descendantsOfEva(persons: List<Person>): List<Person> {
    return persons.filter { it.mother == "eve"}
}


fun notDescendantsOfEva(persons: List<Person>): List<Person> {
    return persons.filter { it.mother != "eve"}
}

fun Person.isChildOfEve(): Boolean = mother=="eve"




