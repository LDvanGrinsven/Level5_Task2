package com.example.level5_task2.database

import android.content.Context
import androidx.lifecycle.LiveData


class GameRepository(context: Context) {

    private val gameDao: GameDao

    init {
        val database = GameRoomDatabase.getDatabase(context)
        gameDao = database!!.gameDao()
    }

    fun getGames(): LiveData<List<Game>> {
        return gameDao.getGames()
    }

    suspend fun updateGame(game: Game) {
        gameDao.updateGame(game)
    }
    suspend fun insertGame(game: Game) {
        gameDao.insertGame(game)
    }
    suspend fun deleteGame(game: Game) {
        gameDao.deleteGame(game)
    }

    suspend fun deleteAllGames(){
        gameDao.deleteAllGames()
    }

}
