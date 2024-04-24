package com.example.callups.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.callups.R
import com.example.callups.databinding.FragmentHomeBinding
import com.example.callups.helpers.RecyclerAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val contacts:Array<String> = arrayOf("Kaushik","Adharsh","Bavishya","Maneesh", "Nikhil","Sundar","Sam")
        val recyclerView : RecyclerView = root.findViewById(R.id.recycler_home)
        val rAdapter = RecyclerAdapter(contacts)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = rAdapter
        return root
    }

    override fun onDestroyView() {        super.onDestroyView()
        _binding = null
    }
}