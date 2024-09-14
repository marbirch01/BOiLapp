package pl.marbirch.boilapp.data.local.database

import android.app.Application
import androidx.room.Room

object ManagerHistoryDatabase {
    private var db: HistoryDatabase? = null

    fun getDb(application: Application): HistoryDatabase{
        return db ?: synchronized(this){
            val tempInstance = db
            if (tempInstance != null){
                return@synchronized tempInstance
            }

            val instance = Room.databaseBuilder(context = application, klass = HistoryDatabase::class.java, name = "history_database").build()

            db = instance
            return@synchronized instance
        }
    }
}