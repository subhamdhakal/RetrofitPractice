package subham.com.rxkotlinapplication

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApiService {

    //https://www.simplifiedcoding.net/demos/marvel/


    @GET("marvel")
    fun callApi():
            Observable<List<Model.Marvel>>

    companion object {
        fun create():MarvelApiService{
            val retrofit=Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://www.simplifiedcoding.net/demos/")
                .build()
            return retrofit.create(MarvelApiService::class.java)
        }
    }

}