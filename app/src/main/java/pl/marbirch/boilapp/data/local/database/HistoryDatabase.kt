package pl.marbirch.boilapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.marbirch.boilapp.data.model.dto.DtoQuizHistory

@Database(entities = [DtoQuizHistory::class], version = 1)
abstract class HistoryDatabase: RoomDatabase() {
    abstract fun daoHistory(): DaoQuizHistory
}