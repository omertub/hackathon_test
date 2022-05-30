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
            // send a get request for /users and run the callback:
            APIUtil.getRequest("users") {
                // the object 'it' is the JSONObject that contains the backend response

                // this callback is running on a separate thread, so if we want
                // to update the UI we need to run it on a UI thread
                runOnUiThread {
                    Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
                }
            }
        }

        findViewById<Button>(R.id.test_post_request_botton).setOnClickListener {
            // in this example, we are sending a POST request with a JSON body
            APIUtil.postRequest("signup", JSONObject()
                .put("username", "yehonatan")
                .put("password", "123456")) {
                runOnUiThread {
                    Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
                }
            }
        }

        // subscribe to an event with via the WebSocket:
        APIUtil.on("server2client") {
            runOnUiThread {
                val msg = it.get("hello") as String
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
            }
        }
    }
}