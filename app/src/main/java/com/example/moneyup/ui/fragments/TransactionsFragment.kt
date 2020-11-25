package com.example.moneyup.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.moneyup.R
import com.example.moneyup.ui.WrapperActivity

class TransactionsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View =  inflater.inflate(R.layout.fragment_transactions, container, false)

        val wrapperActivity: WrapperActivity = activity as WrapperActivity

        wrapperActivity.bottomNav.menu.getItem(2).isChecked = true

        //bottom_nav.menu.getItem(2).isChecked = true


        return rootView
    }
}