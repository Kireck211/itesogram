package iteso.mx.itesogram.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import iteso.mx.itesogram.R
import iteso.mx.itesogram.utils.SESSION_ID_KEY
import iteso.mx.itesogram.utils.SHARED_PREFERENCES



class ActivitySplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
        val sessionId = sharedPreferences.getString(SESSION_ID_KEY, "")

        val intent = if (sessionId == "") {
            Intent(this, ActivityLogin::class.java)
        } else {
            Intent(this, ActivityMain::class.java)
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intent)
    }

}
