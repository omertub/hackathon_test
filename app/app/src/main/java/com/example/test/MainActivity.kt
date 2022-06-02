package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.test.utils.APIUtil
import org.json.JSONObject
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.test_request_button).setOnClickListener {
            // send a get request for /users and run the callback
            // you can pass get parameter if you want like this: user?param1=value1&param2:value2
            APIUtil.getRequest("user?userId=1") {
                // the object 'it' is the JSONObject that contains the backend response
                // this callback is running on a separate thread, so if we want
                // to update the UI we need to run it on a UI thread
                runOnUiThread {
                    val status = it.get("status") as String
                    if (status != "OK") {
                        Toast.makeText(this, "Error! $status", Toast.LENGTH_LONG).show()
                    }
                    else {
                        val user = it.get("user") as JSONObject
                        val userId = user.get("id") as Int
                        val username = user.get("username") as String
                        Toast.makeText(this, "Welcome $username! (userId: $userId)", Toast.LENGTH_LONG).show()
                    }

                }
            }
        }

        findViewById<Button>(R.id.test_post_request_botton).setOnClickListener {
            // in this example, we are sending a POST request with a JSON body
            APIUtil.postRequest("signup", JSONObject()
                .put("username", "yehonatan")
                .put("password", "123456")) {
                runOnUiThread {
                    it.get("staus")
                    Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
                }
            }
        }

        // subscribe to an event via the WebSocket:
        APIUtil.on("server2client") {
            runOnUiThread {
                val msg = it.get("hello") as String
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
            }
        }
    }
}