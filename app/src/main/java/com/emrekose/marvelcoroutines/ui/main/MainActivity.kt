package com.emrekose.marvelcoroutines.ui.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import com.emrekose.marvelcoroutines.R
import com.emrekose.marvelcoroutines.model.characters.CharacterResults
import com.emrekose.marvelcoroutines.ui.detail.DetailActivity
import com.emrekose.marvelcoroutines.util.gone
import com.emrekose.marvelcoroutines.util.launchActivity
import com.emrekose.marvelcoroutines.util.visible
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val viewModel: CharacterViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = CharacterAdapter(this::onCharacterClick)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter

        viewModel.getCharacters()
        viewModel.characterListLiveData.observe(this, Observer {
            adapter.submitList(it?.data?.results)
        })

        viewModel.progressLiveData.observe(this, Observer { if (it!!) progressBar.visible() else progressBar.gone() })

        viewModel.errorLiveData.observe(this, Observer { error ->
            error?.let { Toast.makeText(this, error, Toast.LENGTH_SHORT).show() }
        })
    }

    private fun onCharacterClick(results: CharacterResults) {
        launchActivity<DetailActivity> {
            putExtra(CHARACTER_EXTRA, results)
        }
    }

    companion object {
        const val CHARACTER_EXTRA = "character_extra"
    }
}
