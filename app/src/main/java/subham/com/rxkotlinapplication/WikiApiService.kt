package subham.com.rxkotlinapplication

import android.graphics.ColorSpace
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query




//https://en.wikipedia.org/w/api.php?action=query&format=json&list=search&srsearch=Trump,
//https://www.simplifiedcoding.net/demos/marvel/


interface WikiApiService {
    @GET("api.php")
    fun hitCountSearch(
        @Query("action") action: String,
        @Query("format") format: String,
        @Query("list") list: String,
        @Query("srsearch") srsearch: String
    ):
            Observable<Model.Result>


    companion object {
        fun create():WikiApiService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://en.wikipedia.org/w/")
                .build()
            return retrofit.create(WikiApiService::class.java)
        }


    }
}



