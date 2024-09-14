package pl.marbirch.boilapp.data.repository

import android.app.Application
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import pl.marbirch.boilapp.data.local.database.ManagerHistoryDatabase
import pl.marbirch.boilapp.data.model.domain.QuizHistory
import pl.marbirch.boilapp.data.model.dto.DtoQuizHistory

class QuizHistoryRepository(app: Application) {
    private val manager = ManagerHistoryDatabase
    private val database = manager.getDb(app)
    private val dao = database.daoHistory()

    fun getAllHistory(): Flow<List<QuizHistory>>{
        return dao.getAllHistory().map { it.convertToModel() }
    }

    suspend fun insertQuizHistory(dtoQuizHistory: DtoQuizHistory) = withContext(Dispatchers.IO){
        dao.insert(dtoQuizHistory)
    }

    private fun List<DtoQuizHistory>.convertToModel(): List<QuizHistory>{
        return map { it.convertToModel() }
    }
}