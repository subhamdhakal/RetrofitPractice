package subham.com.rxkotlinapplication.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_json_place_holder.*
import subham.com.rxkotlinapplication.Api.JsonPlaceHolderApiService
import subham.com.rxkotlinapplication.R
import subham.com.rxkotlinapplication.adapter.CommentsAdapter
import subham.com.rxkotlinapplication.adapter.PostsAdapter

class JsonPlaceHolder : AppCompatActivity() {
    var disposeable: Disposable? = null
    var fetchType: String = ""
    val TAG = "JsonPlaceHolder"
    val jsonPlaceHolderApiService by lazy {
        JsonPlaceHolderApiService.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json_place_holder)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.radio_posts)
                fetchType = "posts"
            else if (checkedId == R.id.radio_comments)
                fetchType = "comments"
        }

        button_fetch.setOnClickListener {
            var id = editText.text.toString()
            commonFetchItBaby(id.toInt())
        }
    }

    fun commonFetchItBaby(id: Int) {
        if (fetchType == "posts") {
            disposeable = jsonPlaceHolderApiService.callPostsApi(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { result ->
                    Log.e(TAG, "  " + result.toString())
                    var postsAdapter=PostsAdapter(this,result)
                    recycler_view_posts_comments.adapter=postsAdapter
                    recycler_view_posts_comments.layoutManager=LinearLayoutManager(this)
                }
        } else if (fetchType == "comments") {
            disposeable = jsonPlaceHolderApiService.callCommentsApi(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { result ->
                    Log.e(TAG, "  " + result.toString())
                    var commentsAdapter=CommentsAdapter(this,result)
                    recycler_view_posts_comments.adapter=commentsAdapter
                    recycler_view_posts_comments.layoutManager=LinearLayoutManager(this)
                }
        }
    }
}
