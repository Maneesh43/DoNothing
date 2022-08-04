package com.maneesh.donothing.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maneesh.donothing.network.dataClasses.APIService
import com.maneesh.donothing.network.dataClasses.ZenResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.util.Log

class quotesViewModel:ViewModel() {

    private val _quote = MutableLiveData("")
    val quote:LiveData<String>
                get() = _quote

    init {

    }

    fun getSingleQuote(){
        val service=APIService.getInstance()
        service.getQuote("123").also {
            run {
                it.enqueue(object : Callback<ZenResponse> {
                    override fun onResponse(
                        call: Call<ZenResponse>?,
                        response: Response<ZenResponse>?
                    ) {
                        TODO("Not yet implemented")
                    }

                    override fun onFailure(call: Call<ZenResponse>?, t: Throwable?) {
                        TODO("Not yet implemented")
                    }

                })
            }
        }
    }

}