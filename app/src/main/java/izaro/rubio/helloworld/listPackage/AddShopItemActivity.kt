package izaro.rubio.helloworld.listPackage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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

        //Textos:
        binding.saveButton.text = getString(R.string.save_button_text)
        binding.itemNameEditText.hint = getString(R.string.product_name_hint)
        binding.itemQuantityEditText.hint = getString(R.string.product_quantity_hint)



        // Configura un listener para guardar los datos
        binding.saveButton.setOnClickListener {
            val name = binding.itemNameEditText.text.toString()
            val quantity = binding.itemQuantityEditText.text.toString().toIntOrNull()

            // Verificación del campo name para evitar elementos sin nombre
            if (name.isBlank()) {
                Toast.makeText(
                    this,
                    getString(R.string.error_name_required),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                // Si el nombre no está vacío, se continúa con el guardado
                val shopItem = ShopItem(name, quantity) // Usa -1 para indicar que quantity no fue provisto
                val resultIntent = Intent() // Crear un intent
                resultIntent.putExtra("SHOP_ITEM_KEY", shopItem) //Guarda como extra el resultado
                setResult(RESULT_OK, resultIntent) //Indicamos que ha ido bien
                finish() // Finalizar Activity
            }
        }
    }
    companion object {
        fun getCallingIntent(context: Context): Intent {
            return Intent(context, AddShopItemActivity::class.java)
        }
    }

}