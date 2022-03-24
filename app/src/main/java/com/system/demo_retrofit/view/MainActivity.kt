package com.system.demo_retrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.system.demo_retrofit.APIService
import com.system.demo_retrofit.R
import com.system.demo_retrofit.databinding.ActivityMainBinding
import com.system.demo_retrofit.entidades.entidades.Usuario
import com.system.demo_retrofit.view.adapter.UsuarioAdaptador
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UsuarioAdaptador
    private var userPost = emptyList<Usuario>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buscarPost()

    }

    private fun initRecyclerView() {
        adapter = UsuarioAdaptador(userPost)
        binding.rcUsuario.layoutManager = LinearLayoutManager(this)
        binding.rcUsuario.adapter = adapter

    }

    private fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()) //delpaquete gson para converitr la url
            .build()
    }

    /*corrutina*/
    private fun buscarPost(){
        CoroutineScope(Dispatchers.IO).launch {
            val llamada = getRetrofit().create(APIService::class.java).getUsuarioPost()
            val usuarios = llamada.body()

            runOnUiThread {

                if(llamada.isSuccessful){ //si la llamada es satisfactoria

                    userPost = usuarios ?: emptyList()
                    initRecyclerView()


                }else{

                    showError()

                }


            }

        }


    }

    private fun showError() {
        Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
    }


}