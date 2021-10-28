package com.example.example_retrofit.ui.main.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.nasa.gov/neo/rest/v1/"
//private var apiParams = "feed?start_date=$startDate&end_date=$endDate&api_key=$apiKey"
private const val apiParams = "feed?start_date=2021-09-01&end_date=2021-09-07&api_key=U9mndCIzdwnqbnnSEtmWHon1SHywWpkaKRBZsjec"


//Use Retrofit Builder with ScalarsConverterFactory and BASE_URL
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

// Implement the NeoWs [Near Earth Object Web Service] Interface with @Get getProperties returning a String.
interface neowsApiService {
    @GET(apiParams) //BASE_URL is appended with apiParams
    fun getProperties():
            Call<String>

}

// Create the NeoWs object using Retrofit to implement the NeoWs Service.
object neowsApi {
    val retrofitService : neowsApiService by lazy {retrofit.create(neowsApiService::class.java)}
}