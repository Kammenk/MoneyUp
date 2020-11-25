package com.example.moneyup.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.moneyup.ui.fragments.OverviewFragment
import com.example.moneyup.R
import com.example.moneyup.ui.fragments.AccountsFragment
import com.example.moneyup.ui.fragments.TransactionsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class WrapperActivity : AppCompatActivity() {

    val bottomNav: BottomNavigationView by lazy { findViewById<BottomNavigationView>(
        R.id.bottom_nav
    ) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wrapper)

        bottomNav.setOnNavigationItemSelectedListener(navListener)

        setOverviewFragment()

    }

    //Sets the home fragment as active
    private fun setOverviewFragment() {
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            OverviewFragment()
        ).commit()
    }

    //Switch between fragments depending on the icon/item clicked
    private val navListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem: MenuItem ->
            var selectedFragment: Fragment? = null
            when (menuItem.itemId) {
                R.id.nav_accounts -> selectedFragment =
                    AccountsFragment()
                R.id.nav_overview -> selectedFragment =
                    OverviewFragment()
                R.id.nav_transactions -> selectedFragment =
                    TransactionsFragment()
            }
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                selectedFragment!!
            ).addToBackStack(selectedFragment.tag).commit()
            true
        }
}
