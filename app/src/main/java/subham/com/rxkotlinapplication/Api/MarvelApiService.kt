package subham.com.rxkotlinapplication.Api

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import subham.com.rxkotlinapplication.Model.MarvelModel
import subham.com.rxkotlinapplication.Model.Model

interface MarvelApiService {

    //https://www.simplifiedcoding.net/demos/marvel/


    @GET("marvel")
fun callApi():
        Observable<List<MarvelModel>>

companion object {
    fun create(): MarvelApiService {
        val retrofit=Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://www.simplifiedcoding.net/demos/")
            .build()
        return retrofit.create(MarvelApiService::class.java)
    }
}

}