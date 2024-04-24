package com.example.callups.helpers

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.callups.R

class RecyclerAdapter (private val dataSet: Array<String>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){

        val firstName: TextView
        val contactNumber: TextView
        val displayImage: ImageView
        init{
            firstName = view.findViewById(R.id.contact_name)
            contactNumber = view.findViewById(R.id.contact_number)
            displayImage = view.findViewById(R.id.contact_image)
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row_item,parent,false)
       // Log.d("Recycler adapter", "$viewType")
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.firstName.text = dataSet[position]
        holder.contactNumber.text = "+91 25673487555"
        holder.displayImage.setImageURI(Uri.parse("https://t3.ftcdn.net/jpg/02/66/08/38/360_F_266083810_zGmRdMbOVoIa9kRoe9ivR3KETGxJNg6C.jpg"))

    }

    override fun getItemCount(): Int {
     //   Log.d("Recycler adapter", "${dataSet.size}")
        return dataSet.size
    }

}