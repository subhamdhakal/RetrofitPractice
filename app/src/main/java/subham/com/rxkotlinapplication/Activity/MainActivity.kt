package subham.com.rxkotlinapplication.Activity

import android.arch.persistence.room.Room
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.facebook.stetho.Stetho
import kotlinx.android.synthetic.main.activity_main.*
import subham.com.rxkotlinapplication.R
import subham.com.rxkotlinapplication.database.AppDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Stetho.initializeWithDefaults(this)
        val database= Room.databaseBuilder(applicationContext,AppDatabase::class.java,"json-database")
                .build()

    }

    fun buttonPressed(v: View) {
        when (v.id) {
            button_wiki_api.id -> startActivity(Intent(this, WikipediaApiService::class.java))
            button_marvel_api.id -> startActivity(Intent(this@MainActivity, Marvel::class.java))
            button_json_place_holder_api.id -> startActivity(Intent(this@MainActivity, JsonPlaceHolder::class.java))
        }
    }
}