package subham.com.rxkotlinapplication.database

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "posts_model")
data class PostsModel(var userId:String,var id:String,var title:String,var body:String)
{
    @PrimaryKey(autoGenerate = true)
    var _id:Int?=null
}
