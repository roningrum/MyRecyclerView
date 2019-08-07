package com.roniokta.myrecyclerviewkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.util.ArrayList

class CardViewHeroAdapter(private val listHero : ArrayList<Hero>) : RecyclerView.Adapter<CardViewHeroAdapter.CardViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_hero, parent, false)
        return CardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHero.size
   }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val(name, from, photo) = listHero[position]
        Glide.with(holder.itemView.context)
                .load(photo)
                .apply(RequestOptions().override(55,55))
                .into(holder.imgPhoto)
        holder.tvName.text = name
        holder.tvFrom.text = from
        holder.btnFavorite.setOnClickListener { Toast.makeText(holder.itemView.context, "Favorite " + listHero[holder.adapterPosition].name, Toast.LENGTH_SHORT).show() }
        holder.btnShare.setOnClickListener { Toast.makeText(holder.itemView.context, "Share " + listHero[holder.adapterPosition].name, Toast.LENGTH_SHORT).show() }
        holder.itemView.setOnClickListener { Toast.makeText(holder.itemView.context, "Kamu memilih " + listHero[holder.adapterPosition].name, Toast.LENGTH_SHORT).show() }

    }

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvFrom: TextView = itemView.findViewById(R.id.tv_item_from)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var btnFavorite: Button = itemView.findViewById(R.id.btn_set_favorite)
        var btnShare: Button = itemView.findViewById(R.id.btn_set_share)
    }
}