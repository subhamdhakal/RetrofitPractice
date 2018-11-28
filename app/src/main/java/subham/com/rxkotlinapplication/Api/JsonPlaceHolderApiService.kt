package subham.com.rxkotlinapplication.Api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import subham.com.rxkotlinapplication.database.CommentsModel
import subham.com.rxkotlinapplication.database.PostsModel

//https://jsonplaceholder.typicode.com/posts?userId=1

//https://jsonplaceholder.typicode.com/comments?postId=1

interface JsonPlaceHolderApiService {

    @GET("/posts")
    fun callPostsApi(@Query("userId")userId:Int

    ):io.reactivex.Observable<List<PostsModel>>


    @GET("/comments")
    fun callCommentsApi(@Query("postId")postId:Int

    ):
            io.reactivex.Observable<List<CommentsModel>>



    companion object {
        fun create():JsonPlaceHolderApiService{
            val retrofit=Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build()
            return retrofit.create(JsonPlaceHolderApiService::class.java)
        }

    }
}