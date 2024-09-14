package pl.marbirch.boilapp.data.local.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pl.marbirch.boilapp.data.model.dto.DtoQuizHistory

@Dao
interface DaoQuizHistory {

    @Query("SELECT * FROM quiz_history")
    fun getAllHistory(): Flow<List<DtoQuizHistory>>

    @Insert
    fun insert(dtoQuizHistory: DtoQuizHistory)
}