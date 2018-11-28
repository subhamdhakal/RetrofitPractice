package subham.com.rxkotlinapplication.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [PostsModel::class, CommentsModel::class],version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun databaseDao():DatabaseDao
}