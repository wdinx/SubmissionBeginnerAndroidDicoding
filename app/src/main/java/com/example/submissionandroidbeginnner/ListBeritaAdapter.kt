package com.example.submissionandroidbeginnner

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.submissionandroidbeginnner.databinding.RowNewsActivityBinding

class ListBeritaAdapter(private val listNews: ArrayList<Berita>) :
    RecyclerView.Adapter<ListBeritaAdapter.MyViewHolder>() {
    class MyViewHolder(var binding: RowNewsActivityBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RowNewsActivityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = listNews.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var (title, writer, date, description, image,) = listNews[position]
        holder.binding.tvNewsTitle.text = title
        holder.binding.tvNewsWriter.text = writer
        holder.binding.tvNewsDate.text = date
        holder.binding.tvNewsDescription.text = description
        holder.binding.imgNews.setImageResource(image)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailNewsActivity::class.java)
            intent.putExtra(DetailNewsActivity.KEY_EXTRA, listNews[position])
            holder.itemView.context.startActivity(intent)
        }
    }
}