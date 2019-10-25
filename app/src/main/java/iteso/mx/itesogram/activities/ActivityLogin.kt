package iteso.mx.itesogram.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import iteso.mx.itesogram.R
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class ActivityLogin : AppCompatActivity() {
    private lateinit var mLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mLogin = find(R.id.activity_login_btn_login)
        mLogin.setOnClickListener {
            startActivity<ActivityMain>()
        }

        find<TextView>(R.id.activity_login_tv_forgot_action).setOnClickListener {
            startActivity<ActivityRestorePassword>()
        }
    }
}
