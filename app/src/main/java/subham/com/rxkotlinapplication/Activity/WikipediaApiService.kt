package subham.com.rxkotlinapplication.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_wikipedia_api_service.*
import subham.com.rxkotlinapplication.Api.WikiApiService
import subham.com.rxkotlinapplication.R

class WikipediaApiService : AppCompatActivity() {

    var disposable: Disposable?=null

    val wikiApiService by lazy{
        WikiApiService.create()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wikipedia_api_service)
        btn_search.setOnClickListener {

            beginSearch(edit_search.text.toString())
        }

    }
    private fun beginSearch(srsearch: String) {

        disposable =     wikiApiService.hitCountSearch("query","json","search",srsearch)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> txt_search_result.text = result.query.searchinfo.totalhits.toString()

                },
                { error -> Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show() }
            )
    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }
}
