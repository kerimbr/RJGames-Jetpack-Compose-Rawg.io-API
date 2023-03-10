package com.example.rjgames.data.local.converters

import androidx.room.TypeConverter
import com.example.rjgames.data.remote.dto.game_details.*
import com.google.gson.Gson


class Converter {

    @TypeConverter
    fun fromRatingList(ratingList: List<GameDetailRating?>): String {
        return Gson().toJson(ratingList)
    }

    @TypeConverter
    fun toRatingList(ratingList: String?): List<GameDetailRating?> {
        return Gson().fromJson(ratingList, Array<GameDetailRating?>::class.java).toList()
    }

    @TypeConverter
    fun fromGenresList(genreList: List<GameDetailGenre?>): String {
        return Gson().toJson(genreList)
    }

    @TypeConverter
    fun toGenresList(genreList: String?): List<GameDetailGenre?> {
        return Gson().fromJson(genreList, Array<GameDetailGenre?>::class.java).toList()
    }

    @TypeConverter
    fun fromDeveloperList(developerList: List<GameDetailDeveloper?>): String {
        return Gson().toJson(developerList)
    }

    @TypeConverter
    fun toDeveloperList(developerList: String?): List<GameDetailDeveloper?> {
        return Gson().fromJson(developerList, Array<GameDetailDeveloper?>::class.java).toList()
    }

    @TypeConverter
    fun fromTagList(tagList: List<GameDetailTag?>): String {
        return Gson().toJson(tagList)
    }

    @TypeConverter
    fun toTagList(tagList: String?): List<GameDetailTag?> {
        return Gson().fromJson(tagList, Array<GameDetailTag?>::class.java).toList()
    }


    @TypeConverter
    fun fromStoreList(storeList: List<GameDetailStoreX?>): String {
        return Gson().toJson(storeList)
    }

    @TypeConverter
    fun toStoreList(storeList: String?): List<GameDetailStoreX?> {
        return Gson().fromJson(storeList, Array<GameDetailStoreX?>::class.java).toList()
    }

    @TypeConverter
    fun fromPublisherList(publisherList: List<GameDetailPublisher?>): String {
        return Gson().toJson(publisherList)
    }

    @TypeConverter
    fun toPublisherList(publisherList: String?): List<GameDetailPublisher?> {
        return Gson().fromJson(publisherList, Array<GameDetailPublisher?>::class.java).toList()
    }

    @TypeConverter
    fun fromStringList(stringList: List<String?>): String {
        return Gson().toJson(stringList)
    }

    @TypeConverter
    fun toStringList(stringList: String?): List<String?> {
        return Gson().fromJson(stringList, Array<String?>::class.java).toList()
    }

}