package com.london.vistasul1.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import coil.load
import coil.transform.CircleCropTransformation
import com.london.vistasul1.databinding.DatailsBinding
import com.london.vistasul1.models.Person


class PersonAdapter (val c: Context, val datos: ArrayList<Person>): BaseAdapter() {

    var context: Context
    var data: ArrayList<Person>

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
        var holder: ViewHolder

        if (convertView == null) {
            var itemBinding = DatailsBinding.inflate(
                LayoutInflater.from(parent?.context),
                parent,
                false
            )
            holder = ViewHolder(itemBinding)
            holder.view = itemBinding.root
            holder.view.tag = holder

        } else {
            holder = convertView.tag as ViewHolder
        }
        val person = data.get(position)
        holder.binding.txtNmp.text = person.name
        holder.binding.txtCor.text= person.email
        holder.binding.txtCont.text=person.password
        holder.binding.imgAvatar.load(person.url){
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