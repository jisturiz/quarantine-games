package com.isturiz.quarantine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.isturiz.quarantine.views.GamesListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container,
                    GamesListFragment()
                )
                .commitNow()
        }
    }

}

fun FragmentActivity.addFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(R.id.container, fragment)
        .addToBackStack(fragment.tag)
        .commit()
}
