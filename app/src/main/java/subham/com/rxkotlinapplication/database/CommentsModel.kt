package subham.com.rxkotlinapplication.database

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "comments_model")
data class CommentsModel(var postId: String, var id: String, var name: String, var email: String, var body: String)
{
    @PrimaryKey(autoGenerate = true)
    var _id:Int?=null
}