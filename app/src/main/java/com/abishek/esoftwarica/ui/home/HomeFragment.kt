package com.abishek.esoftwarica.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abishek.esoftwarica.R
import com.abishek.esoftwarica.adapter.Studentadapter
import com.abishek.esoftwarica.lstStudents
import com.abishek.esoftwarica.model.Studentmodel

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var recycler : RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?


    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        recycler = root.findViewById(R.id.recycler)
        val adapter = Studentadapter(context, lstStudents)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(context)
        return root

    }
}