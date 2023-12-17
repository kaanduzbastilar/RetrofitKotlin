package com.kaanduzbastilar.retrofitkotlin.service

import com.kaanduzbastilar.retrofitkotlin.model.CryptoModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableSource
import retrofit2.Call
import retrofit2.http.GET

interface CryptoAPI {

    //GET, POST, UPDATE, DELETE

    //https://raw.githubusercontent.com/atilsamancioglu/K21-JSONDataSet/master/crypto.json


    //https://min-api.cryptocompare.com/data/pricemulti?fsyms=ETH,DASH&tsyms=BTC,USD,EUR&api_key=

    //5c261ed9f6393151613f913b425a42a9ff2c750d7f0e5b6da218eda039b2ac41

    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    fun getData() : io.reactivex.rxjava3.core.Observable<List<CryptoModel>>

    //fun getData() : Call<List<CryptoModel>>

}