package com.london.vistasul1.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import coil.load
import coil.transform.CircleCropTransformation
import com.london.vistasul1.databinding.DatailsBinding
import com.london.vistasul1.models.Poker

class PokerAdapter(val c: Context, val datos: ArrayList<Poker>): BaseAdapter() {

    var context: Context
    var data: ArrayList<Poker>

    init {
        context = c
        data = datos
    }

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(p0: Int): Any {
        return data.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder: PokerAdapter.ViewHolder

        if (convertView == null) {
            var itemBinding = DatailsBinding.inflate(
                LayoutInflater.from(parent?.context),
                parent,
                false
            )
            holder = PokerAdapter.ViewHolder(itemBinding)
            holder.view = itemBinding.root
            holder.view.tag = holder

        } else {
            holder = convertView.tag as PokerAdapter.ViewHolder
        }
        val poker = data.get(position)
        holder.binding.txtNmp.text = poker.name
        holder.binding.txtCor.text= poker.tip
        holder.binding.txtCont.text= poker.power
        holder.binding.imgAvatar.load(poker.url){
            transformations(CircleCropTransformation())
        }
        return holder.view

    }
    class ViewHolder(itemBinding: DatailsBinding)  {
        var view :View
        var binding : DatailsBinding

        init {
            view = itemBinding.root
            binding = itemBinding
        }

    }
}