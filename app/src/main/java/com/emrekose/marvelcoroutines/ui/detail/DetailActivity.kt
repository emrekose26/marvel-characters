package com.emrekose.marvelcoroutines.ui.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.emrekose.marvelcoroutines.R
import com.emrekose.marvelcoroutines.model.characters.CharacterResults
import com.emrekose.marvelcoroutines.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private var results: CharacterResults? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayShowHomeEnabled(true)

        intent.extras.let {
            results = it.getParcelable<CharacterResults>(MainActivity.CHARACTER_EXTRA)
        }

        title = results?.name

        Glide.with(this)
            .load(results?.thumbnail?.path + "/portrait_incredible." + results?.thumbnail?.extension)
            .into(detail_thumnail)

        detail_title.text = results?.name
        detail_description.text = results?.description
    }
}
