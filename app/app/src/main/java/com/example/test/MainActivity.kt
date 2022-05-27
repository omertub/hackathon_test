package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.test.utils.APIUtil
import org.json.JSONObject
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private val apiUtil = APIUtil()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.test_request_button).setOnClickListener {
            val context = this
            thread {
                val response = apiUtil.getRequest("users")
                context.runOnUiThread {
                    Toast.makeText(context, response.toString(), Toast.LENGTH_LONG).show()
                }
            }
        }

        findViewById<Button>(R.id.test_post_request_botton).setOnClickListener {
            val context = this
            thread {
                // TODO: use JSON parser classes?
                val response = apiUtil.postRequest("signup",
                    JSONObject()
                    .put("username", "yehonatan")
                    .put("password", "123456")
                )
                context.runOnUiThread {
                    Toast.makeText(context, response.toString(), Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}