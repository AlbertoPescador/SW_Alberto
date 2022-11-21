package com.example.sw_alberto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sw_alberto.Datos.RepositorioStarWars
import com.example.sw_alberto.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.btnVerListado.setOnClickListener {
            generarLista(binding.recyclerView)
        }

        binding.btnGuardarListado.setOnClickListener {
            val miDialogo = MiDialogFragment()
            miDialogo.show(supportFragmentManager, "MiDialogo")
        }
    }

    private fun generarLista(query: RecyclerView) {
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<RepositorioStarWars> =
                getRetrofit().create(APIService::class.java).getPersonaje("character?name=$query")
            val personaje = call.body()
            runOnUiThread {
                if (call.isSuccessful) {
                    if (personaje != null) {
                        Glide.with(binding.btnVerListado.context).load(personaje.results)
                    }
                } else
                    Toast.makeText(this@MainActivity, "error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory((GsonConverterFactory.create()))
            .build()
    }
}