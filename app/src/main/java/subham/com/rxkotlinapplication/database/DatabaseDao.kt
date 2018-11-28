package subham.com.rxkotlinapplication.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert

@Dao
interface DatabaseDao {
    @Insert
    fun insertPosts(postsModel: PostsModel)

    @Insert
    fun insertComments(commentsModel: CommentsModel)

}