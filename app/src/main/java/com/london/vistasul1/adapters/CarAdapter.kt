package com.london.vistasul1.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import coil.load
import coil.transform.CircleCropTransformation
import com.london.vistasul1.databinding.DatailsBinding
import com.london.vistasul1.models.Car
import com.london.vistasul1.models.Person

class  CarAdapter (val c: Context, val datos: ArrayList<Car>): BaseAdapter(){

    var context: Context
    var data:ArrayList<Car>

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
        var holder: CarAdapter.ViewHolder

        if (convertView == null) {
            var itemBinding = DatailsBinding.inflate(
                LayoutInflater.from(parent?.context),
                parent,
                false
            )
            holder = CarAdapter.ViewHolder(itemBinding)
            holder.view = itemBinding.root
            holder.view.tag = holder

        } else {
            holder = convertView.tag as CarAdapter.ViewHolder
        }
        val car = data.get(position)
        holder.binding.txtNmp.text = car.name
        holder.binding.txtCor.text= car.plaque
        holder.binding.txtCont.text= car.colors
        holder.binding.imgAvatar.load(car.url){
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