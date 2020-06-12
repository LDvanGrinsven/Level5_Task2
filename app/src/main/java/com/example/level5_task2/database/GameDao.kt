package com.example.level5_task2.database

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface GameDao {

    @Insert
    suspend fun insertNote(game: Game)

    @Query("SELECT * FROM game ORDER BY date")
    fun getGames(): LiveData<List<Game>>

    @Update
    suspend fun updateGame(game: Game)

    @Insert
    suspend fun insertGame(game: Game)

    @Delete
    suspend fun deleteGame(game: Game)

    @Query("DELETE  FROM game WHERE 1")
    suspend fun deleteAllGames()
}
