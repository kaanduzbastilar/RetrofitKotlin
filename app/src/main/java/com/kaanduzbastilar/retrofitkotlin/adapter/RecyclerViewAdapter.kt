package com.kaanduzbastilar.retrofitkotlin.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kaanduzbastilar.retrofitkotlin.databinding.RecyclerRowBinding
import com.kaanduzbastilar.retrofitkotlin.model.CryptoModel

class RecyclerViewAdapter(
    private val cryptoList: ArrayList<CryptoModel>,
    private val listener: Listener
) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {

    private val colors: Array<String> = arrayOf("#42f548", "#4251f5", "#b942f5", "#ed7e24", "#ed2434", "#00ff00", "#07f2b4", "#cbf207")

    interface Listener {
        fun onItemClick(cryptoModel: CryptoModel)
    }

    inner class RowHolder(private val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cryptoModel: CryptoModel, colors: Array<String>, position: Int) {
            binding.textName.text = cryptoModel.currency
            binding.textPrice.text = cryptoModel.price
            binding.root.setBackgroundColor(Color.parseColor(colors[position % colors.size]))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RowHolder(binding)
    }

    override fun getItemCount(): Int {
        return cryptoList.size
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(cryptoList[position], colors, position)
        holder.itemView.setOnClickListener {
            listener.onItemClick(cryptoList[position])
        }
    }
}
