package com.example.assignmentcits

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.concurrent.TimeUnit

class showDataAdapter(var context: Context,var name: MutableList<String>,var countryName: MutableList<String>,var websiteLink: MutableList<String>): RecyclerView.Adapter<showDataAdapter.MyViewHolder>() {
    val map = mapOf<Int,String>(41 to "United Arab Emirates", 40 to "South Africa", 43 to "West Indies", 10 to "India", 1 to "Pakistan", 36 to "Australia", 45 to "United Arab Emirates")
    val mapImage = mapOf<Int,String>(3 to "https://cdn.sportmonks.com/images/cricket/leagues/3/3.png", 5 to "https://cdn.sportmonks.com/images/cricket/leagues/5/5.png", 10 to "https://cdn.sportmonks.com/images/cricket/leagues/10/10.png")
    interface OnItemLongClickListener {
        fun onItemLongClick(position: Int)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): showDataAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_adapter_vew, parent, false)
        return MyViewHolder(view)
    }
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name:TextView = itemView.findViewById(R.id.collegeName)
        var cName:TextView = itemView.findViewById(R.id.countryName)
        var websiteLink:TextView = itemView.findViewById(R.id.websiteLink)

        fun bind(teamName: String,teamName2: String,finalVerdict: String) {
            name.text = teamName
            cName.text = teamName2
            websiteLink.text = finalVerdict
        }
    }


    override fun onBindViewHolder(holder: showDataAdapter.MyViewHolder, position: Int) {
        var collegeName = name[position]
        var countryName = countryName[position]
        var websiteLinks = websiteLink[position]
        holder.bind(collegeName,countryName,websiteLinks)
        holder.websiteLink.setOnClickListener {
            var intent = Intent(context,WebViewActivity::class.java)
            intent.putExtra("URL", websiteLink[position])
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return name.size
    }
}
