package com.example.moneyup.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.moneyup.R
import com.example.moneyup.ui.WrapperActivity


class AccountsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View =  inflater.inflate(R.layout.fragment_accounts, container, false)



        val wrapperActivity: WrapperActivity = activity as WrapperActivity

        wrapperActivity.bottomNav.menu.getItem(0).isChecked = true


        return rootView
    }
}