package com.example.projet_tdm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projet_tdm.database.arret.Arret

class ArretAdapter(private val values: List<Arret>, recyclerViewInterface: RecyclerViewInterface) :
    RecyclerView.Adapter<ArretAdapter.ArretViewHolder>() {


    inner class ArretViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvArretId = itemView.findViewById<TextView>(R.id.tvArretId)
        val tvArretRoom = itemView.findViewById<TextView>(R.id.tvArretRoom)
        val tvArretDate = itemView.findViewById<TextView>(R.id.tvArretDate)
        val ivFavroite = itemView.findViewById<ImageView>(R.id.ivFavroite)
    }

    override fun getItemCount(): Int = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArretViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.arret_item, parent, false)

        return ArretViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ArretViewHolder, position: Int) {

        val item = values[position]

        holder.tvArretId.text = "القرار رقم ${item.numAr.toString()}"
        holder.tvArretRoom.text = item.chambreAR
        holder.tvArretDate.text = item.dateAr
        holder.ivFavroite.setImageResource(if (item.favorite) R.drawable.baseline_star_24 else R.drawable.baseline_star_outline_24)

        holder.ivFavroite.setOnClickListener {
            item.favorite = !item.favorite
            holder.ivFavroite.setImageResource(if (item.favorite) R.drawable.baseline_star_24 else R.drawable.baseline_star_outline_24)
        }
    }
}