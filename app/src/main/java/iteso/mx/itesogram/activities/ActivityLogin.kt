package iteso.mx.itesogram.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import iteso.mx.itesogram.R
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import com.parse.ParseUser
import android.content.Context
import android.widget.EditText
import android.widget.Toast
import iteso.mx.itesogram.utils.SESSION_ID_KEY
import iteso.mx.itesogram.utils.SHARED_PREFERENCES


class ActivityLogin : AppCompatActivity() {
    private lateinit var mLogin: Button
    private lateinit var mUserName: EditText
    private lateinit var mPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mLogin = find(R.id.activity_login_btn_login)
        mUserName = find(R.id.activity_login_tiet_username)
        mPassword = find(R.id.activity_login_tiet_password)


        mLogin.setOnClickListener {

            ParseUser
                .logInInBackground(
                    mUserName.text.toString(),
                    mPassword.text.toString()
                ) { parseUser, error ->
                    if (error == null) {
                        saveSessionToken(parseUser.sessionToken)
                        startActivity<ActivityMain>()
                    } else {
                        Toast.makeText(this, "Login error", Toast.LENGTH_LONG).show()
                    }
                }
        }

        find<TextView>(R.id.activity_login_tv_forgot_action).setOnClickListener {
            startActivity<ActivityRestorePassword>()
        }
    }

    private fun saveSessionToken(sessionToken: String) {
        val sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(SESSION_ID_KEY, sessionToken)
        editor.apply()
    }
}
