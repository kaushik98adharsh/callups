package com.example.callups.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.apollographql.apollo3.ApolloClient
import com.example.callups.databinding.FragmentDashboardBinding
import com.example.callups.models.Contact
import com.example.callups.services.Network
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val apolloClient: ApolloClient = ApolloClient.Builder().serverUrl("http://192.168.0.199:8080/v1/graphql").build()

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this)[DashboardViewModel::class.java]

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val graphButton: Button = binding.button
        graphButton.setOnClickListener{
            var response: Contact
            GlobalScope.launch{
                response = Network(apolloClient).addContact(phone= "8257095590",name= "Mr.Kit bull")
                Log.d("Mutation","response: $response")

            }


            //Log.d("Mutation", "response UI: ${response.data}")

        }



        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}