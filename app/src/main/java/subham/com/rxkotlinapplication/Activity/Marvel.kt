package subham.com.rxkotlinapplication.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_marvel.*
import kotlinx.android.synthetic.main.activity_wikipedia_api_service.*
import subham.com.rxkotlinapplication.Api.MarvelApiService
import subham.com.rxkotlinapplication.R
import subham.com.rxkotlinapplication.adapter.MarvelRecyclerViewAdapter

class Marvel : AppCompatActivity() {
    val TAG="Marvel"
    var adapter:MarvelRecyclerViewAdapter?=null



    val marvelApiService by lazy {
        MarvelApiService.create()
    }
    var disposeable:Disposable?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marvel)

        disposeable=marvelApiService.callApi()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { result-> Log.e(TAG,""+result)
                adapter=MarvelRecyclerViewAdapter(result)

                recycler_view_marvel.layoutManager=LinearLayoutManager(this)
                recycler_view_marvel.adapter=adapter

            }
    }
}
