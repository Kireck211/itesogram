package iteso.mx.itesogram.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import iteso.mx.itesogram.R
import iteso.mx.itesogram.fragments.FragmentAddPhoto
import iteso.mx.itesogram.fragments.FragmentHome
import iteso.mx.itesogram.fragments.FragmentLikes
import iteso.mx.itesogram.fragments.FragmentProfile
import org.jetbrains.anko.find

class ActivityMain : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottom = find<BottomNavigationView>(R.id.bottom_navigation)
        bottom.setOnNavigationItemSelectedListener(this)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_content, FragmentHome())
            .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_home -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content, FragmentHome())
                    .commit()
            }
            R.id.action_add -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content, FragmentAddPhoto())
                    .commit()
            }
            R.id.action_likes -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content, FragmentLikes())
                    .commit()
            }
            R.id.action_profile -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content, FragmentProfile())
                    .commit()
            }
        }
        return true
    }
}
