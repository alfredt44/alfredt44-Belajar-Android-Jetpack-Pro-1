package com.dicoding.alfred.firstsubmission.ui.home

import androidx.lifecycle.ViewModel
import com.dicoding.alfred.firstsubmission.model.DataModel
import com.dicoding.alfred.firstsubmission.utils.Dummy

class HomeViewModel : ViewModel() {

    fun getListMovie(): List<DataModel> = Dummy.generateDataMovieDummy()

    fun getListTvShow(): List<DataModel> = Dummy.generateDataTvShowDummy()

}