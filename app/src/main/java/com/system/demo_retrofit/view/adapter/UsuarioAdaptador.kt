package com.system.demo_retrofit.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.system.demo_retrofit.R
import com.system.demo_retrofit.databinding.ItemPostBinding
import com.system.demo_retrofit.entidades.entidades.Usuario

class UsuarioAdaptador(private var lista:List<Usuario>):RecyclerView.Adapter<UsuarioAdaptador.UsuarioViewHolder>(){

    private lateinit var context: Context

    inner class UsuarioViewHolder(view: View):RecyclerView.ViewHolder(view){
        val binding = ItemPostBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.item_post,parent,false)

        return UsuarioViewHolder(view)

    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val users = lista.get(position)
        with(holder){
            Glide.with(context).load("https://picsum.photos/200/300").into(binding.ivUser)
            binding.tvId.text = users.id.toString()
            binding.tvUserId.text = users.userId.toString()
            binding.tvTitle.text = users.title
            binding.tvBody.text = users.body
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }

}