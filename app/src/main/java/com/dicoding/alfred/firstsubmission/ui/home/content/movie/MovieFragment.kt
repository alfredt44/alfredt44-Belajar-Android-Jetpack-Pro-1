package com.dicoding.alfred.firstsubmission.ui.home.content.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.alfred.firstsubmission.R
import com.dicoding.alfred.firstsubmission.model.DataModel
import com.dicoding.alfred.firstsubmission.ui.detail.DetailActivity
import com.dicoding.alfred.firstsubmission.ui.home.HomeViewModel
import com.dicoding.alfred.firstsubmission.ui.home.content.DataAdapter
import com.dicoding.alfred.firstsubmission.ui.home.content.DataCallback
import com.dicoding.alfred.firstsubmission.utils.Helper.TYPE_MOVIE
import kotlinx.android.synthetic.main.fragment_movie.*


class MovieFragment : Fragment(), DataCallback {

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            viewModel = ViewModelProvider(
                it,
                ViewModelProvider.NewInstanceFactory()
            )[HomeViewModel::class.java]
        }

        val listMovie = viewModel.getListMovie()
        setupRecyclerView(listMovie)
    }

    private fun setupRecyclerView(data: List<DataModel>) {
        rv_movie.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = DataAdapter(this@MovieFragment)
        }.also {
            it.adapter.let { adapter ->
                when (adapter) {
                    is DataAdapter -> {
                        adapter.setData(data)
                    }
                }
            }
        }
    }

    override fun onItemClicked(data: DataModel) {
        startActivity(
            Intent(
                context,
                DetailActivity::class.java
            )
                .putExtra(DetailActivity.EXTRA_DATA, data.id)
                .putExtra(DetailActivity.EXTRA_TYPE, TYPE_MOVIE)
        )
    }

}
