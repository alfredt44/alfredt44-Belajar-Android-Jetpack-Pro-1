package com.dicoding.alfred.firstsubmission.ui.home.content

import com.dicoding.alfred.firstsubmission.model.DataModel

interface DataCallback  {
    fun onItemClicked(data: DataModel)
}