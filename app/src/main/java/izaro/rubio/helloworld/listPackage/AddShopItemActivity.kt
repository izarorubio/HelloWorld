package izaro.rubio.helloworld.listPackage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import izaro.rubio.helloworld.ListActivity
import izaro.rubio.helloworld.R
import izaro.rubio.helloworld.databinding.ActivityAddShopItemBinding
import izaro.rubio.helloworld.databinding.ActivityListItemBinding

class AddShopItemActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddShopItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityAddShopItemBinding.inflate(layoutInflater)
        setContentView(binding.main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configura un listener para guardar los datos
        binding.saveButton.setOnClickListener {
            val name = binding.itemNameEditText.text.toString()
            val quantity = binding.itemQuantityEditText.text.toString().toIntOrNull() ?: 0

            val shopItem = ShopItem(name, quantity)

            // Crear un intent con el resultado (para devolverlo)
            val resultIntent = Intent() // Crear un intent
            resultIntent.putExtra("SHOP_ITEM_KEY", shopItem) //Guarda como extra el resultado
            setResult(RESULT_OK, resultIntent) //Indicamos que ha ido bien
            finish() // Finalizar Activity
        }
    }

    companion object {
        fun getCallingIntent(context: Context): Intent {
            return Intent(context, AddShopItemActivity::class.java)
        }
    }

}