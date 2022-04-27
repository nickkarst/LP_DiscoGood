package com.example.lp_disco.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lp_disco.data.database.LPDiscoRepository

class ViewModelFactory(private val context: Context) :
    ViewModelProvider.NewInstanceFactory()
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass
            .getConstructor(LPDiscoRepository::class.java, Context::class.java)
            .newInstance(LPDiscoRepository.getInstance(context), context)
    }

    fun getViewModelClass() = DiscoViewModel::class.java
}