package iteso.mx.itesogram.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import iteso.mx.itesogram.R

class ActivityRestorePassword : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restore_password)
        title = "Ayuda para iniciar sesión"

        val email = savedInstanceState?.get("email") ?: ""
    }
}
