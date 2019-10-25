package iteso.mx.itesogram.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import iteso.mx.itesogram.R
import iteso.mx.itesogram.activities.ActivityLogin
import iteso.mx.itesogram.activities.LogoutListener
import iteso.mx.itesogram.utils.SESSION_ID_KEY
import iteso.mx.itesogram.utils.SHARED_PREFERENCES

class FragmentProfile : Fragment(), View.OnClickListener {
    private lateinit var listener: LogoutListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as LogoutListener
        } catch (error: ClassCastException) {
            Log.e("FragmentProfile", "The activity must implement LogoutListener, $error")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        view.findViewById<Button>(R.id.fragment_profile_btn_logout).setOnClickListener(this)

        return view
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.fragment_profile_btn_logout -> {
                listener.logout()
            }
        }
    }
}
