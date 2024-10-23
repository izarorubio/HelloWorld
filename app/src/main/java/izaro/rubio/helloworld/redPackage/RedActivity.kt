package izaro.rubio.helloworld.redPackage

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import izaro.rubio.helloworld.R
import izaro.rubio.helloworld.databinding.ActivityAddShopItemBinding
import izaro.rubio.helloworld.databinding.ActivityRedBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityRedBinding.inflate(layoutInflater)
        setContentView(binding.main)

        // Configuración del RecyclerView
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Llamada a la API para obtener los posts
        val call = ApiClient.apiService.getPosts()

        call.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    val posts = response.body()
                    if (posts != null) {
                        // Configura el adapter con la lista de posts
                        recyclerView.adapter = PostAdapter(posts)
                    }
                } else {
                    Log.e("RedActivity", "Error en la respuesta: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.e("RedActivity", "Error en la llamada: ${t.message}")
            }
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
