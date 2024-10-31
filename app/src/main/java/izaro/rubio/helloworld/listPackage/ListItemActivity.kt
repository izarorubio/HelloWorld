package izaro.rubio.helloworld.listPackage

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import izaro.rubio.helloworld.R
import izaro.rubio.helloworld.databinding.ActivityListItemBinding

class ListItemActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityListItemBinding.inflate(layoutInflater)
        setContentView(binding.main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Obtener los extras del Intent guardado
        val shopItem = intent.getParcelableExtra<ShopItem>("SHOP_ITEM")
        //Mostrar item
        shopItem?.let{
            binding.elementText.text = "${it.name}: ${it.quantity}"
        }
    }
}