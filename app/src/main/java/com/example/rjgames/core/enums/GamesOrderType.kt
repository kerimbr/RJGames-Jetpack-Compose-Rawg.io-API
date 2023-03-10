package com.example.rjgames.core.enums

enum class GamesOrderType(val value: String) {

    NAME("name"),
    RELEASE_DATE("released"),
    RATING("rating"),
    ADDED("added"),
    UPDATED("updated"),
    CREATED("created"),
    METACRITIC("metacritic");

    fun reverse(): String{
        return "-${value}"
    }
}

