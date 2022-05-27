package com.example.test.utils

import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject


class APIUtil {

    private val url = "http://10.0.2.2:3000/"
    private val client = OkHttpClient()
    private val jsonMediaType = "application/json; charset=utf-8".toMediaTypeOrNull()

    fun getRequest(endpoint: String): JSONObject {
        val request = Request.Builder().url(url + endpoint).get().build()
        val response = client.newCall(request).execute()
        return JSONObject(response.body!!.string())
    }

    fun postRequest(endpoint: String, body: JSONObject): JSONObject {
        val requestBody = body.toString().toRequestBody(jsonMediaType)
        val request = Request.Builder().url(url + endpoint).post(requestBody).build()
        val response = client.newCall(request).execute()
        return JSONObject(response.body!!.string())
    }
}
