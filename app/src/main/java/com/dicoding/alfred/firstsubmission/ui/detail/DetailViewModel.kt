package com.dicoding.alfred.firstsubmission.ui.detail

import androidx.lifecycle.ViewModel
import com.dicoding.alfred.firstsubmission.model.DataModel
import com.dicoding.alfred.firstsubmission.utils.Dummy

class DetailViewModel : ViewModel() {

    private lateinit var movieId: String
    private lateinit var tvShowId: String

    private fun getListMovie(): ArrayList<DataModel> = Dummy.generateDataMovieDummy() as ArrayList<DataModel>
    private fun getListTvShow(): ArrayList<DataModel> = Dummy.generateDataTvShowDummy() as ArrayList<DataModel>

    fun setMovieId(movieId: String){
        this.movieId = movieId
    }

    fun setTvShowId(tvShowId: String){
        this.tvShowId = tvShowId
    }

    fun getDetailMovieById(): DataModel {
        lateinit var resut: DataModel
        val listMovie = getListMovie()
        for (movie in listMovie){
            if (movie.id == movieId){
                resut = movie
                break
            }
        }
        return resut
    }

    fun getDetailTvShowById(): DataModel {
        lateinit var resut: DataModel
        val listTvShow = getListTvShow()
        for (tvShow in listTvShow){
            if (tvShow.id == tvShowId){
                resut = tvShow
                break
            }
        }
        return resut
    }

}