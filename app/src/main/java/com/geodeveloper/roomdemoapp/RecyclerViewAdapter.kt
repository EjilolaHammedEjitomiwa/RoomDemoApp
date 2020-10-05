package com.geodeveloper.roomdemoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.geodeveloper.roomdemoapp.database.Subscriber
import com.geodeveloper.roomdemoapp.databinding.ListItemBinding
import kotlinx.android.synthetic.main.activity_main.view.*

class RecyclerViewAdapter(private val subscriber: List<Subscriber>):RecyclerView.Adapter<MyViewHolder> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding :ListItemBinding= DataBindingUtil.inflate(layoutInflater,R.layout.list_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return subscriber.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.bind(subscriber[position])
    }

}

class MyViewHolder(val binding:ListItemBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(subscriber: Subscriber){
        binding.nameTextView.text = subscriber.name
        binding.emailTextView.text = subscriber.email

    }
}