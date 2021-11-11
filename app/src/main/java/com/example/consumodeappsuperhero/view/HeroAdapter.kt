package com.example.consumodeappsuperhero.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.consumodeappsuperhero.databinding.HeroListBinding
import com.example.consumodeappsuperhero.model.SuperHero
import coil.load

class HeroAdapter(val listener: OnItemClickListener): RecyclerView.Adapter<HeroVH>() {

    private var items = mutableListOf<SuperHero>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroVH {
        val binding = HeroListBinding.inflate(LayoutInflater.from(parent.context))
        return HeroVH(binding)
    }

    override fun onBindViewHolder(holder: HeroVH, position: Int) {
        val item = items[position]
        holder.itemView.setOnClickListener {
            listener.onClick(item.id)
        }
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun update(list: List<SuperHero>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }
}

class HeroVH(val binding: HeroListBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: SuperHero) {
        binding.imgHero.load(item.images.md)
        binding.tvName.text = "Name : ".plus(item.name)
        binding.tvSlug.text = "Slug: ".plus(item.slug)
        binding.tvID.text = "ID: ".plus(item.id.toString())
    }
}