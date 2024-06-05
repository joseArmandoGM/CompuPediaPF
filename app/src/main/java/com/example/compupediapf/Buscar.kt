package com.example.compupediapf

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.compupediapf.model.CartasComponentes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CartasAdapter
    private lateinit var searchEditText: EditText

    private var cartasComponentesList = mutableListOf<CartasComponentes>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar la lista de cartasComponentes (sustituye esto con tus datos)
        // cartasComponentesList = obtenerCartasComponentes()

        // Configurar RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CartasAdapter(cartasComponentesList)
        recyclerView.adapter = adapter

        // Configurar EditText de búsqueda
        searchEditText = findViewById(R.id.searchEditText)
        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                filter(s.toString())
            }
        })
    }

    private fun filter(text: String) {
        val filteredList = mutableListOf<CartasComponentes>()

        for (item in cartasComponentesList) {
            if (item.cartaTitulo.contains(text, true)) {
                filteredList.add(item)
            }
        }

        adapter.filterList(filteredList)
    }

    // Función para obtener la lista de CartasComponentes (sustituye esto con tus datos)
    /*
    private fun obtenerCartasComponentes(): MutableList<CartasComponentes> {
        // Implementa lógica para obtener la lista de cartasComponentes de tu fuente de datos
    }
    */
}

// Clase de ejemplo CartasComponentes (sustituye esto con tu propia implementación)
data class CartasComponentes(val cartaTitulo: String)

// Adaptador para RecyclerView
class CartasAdapter(private var cartasComponentesList: MutableList<CartasComponentes>) :
    RecyclerView.Adapter<CartasAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_carta, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cartaComponente = cartasComponentesList[position]
        holder.bind(cartaComponente)
    }

    override fun getItemCount(): Int {
        return cartasComponentesList.size
    }

    fun filterList(filteredList: MutableList<CartasComponentes>) {
        cartasComponentesList = filteredList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(cartasComponentes: CartasComponentes) {
            // Implementa la lógica para mostrar los datos de la carta en el ViewHolder
        }
    }
}



@Preview(showBackground = true)
@Composable
fun BuscarPreview() {
    Buscar(
        navController = NavHostController(LocalContext.current),
        favoritosViewModel = FavoritosViewModel()
    )
}
