package izaro.rubio.helloworld

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import izaro.rubio.helloworld.databinding.ActivityMainBinding
import izaro.rubio.helloworld.databinding.ActivityUsuarioBinding
import izaro.rubio.helloworld.listPackage.ShopItem

class UsuarioActivity : AppCompatActivity() {
    private lateinit var binding:ActivityUsuarioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.main)

        //ActionBar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Ir a UsuarioSaludoActivity cuando se pulsa el boton
        binding.doneButton.setOnClickListener {

            // Obtener el texto ingresado en el EditText(asegurar que es String porque si no no funciona)
            val username = binding.writeNameEditText.text.toString()
            // Verificar si el campo de nombre está vacío
            if (username.isEmpty()) {
                // Mostrar el Toast si el campo está vacío
                Toast.makeText(this, getString(R.string.toast_name_mandatory), Toast.LENGTH_LONG)
                    .show()
            } else {
                // Si el campo no está vacío, crear el Intent para pasar a la otra actividad
                val intent = Intent(this, UsuarioSaludoActivity::class.java)
                intent.putExtra("usernameKey", username) // parámetro1: key única, parámetro2: dato que queremos enviar
                // Empezar la nueva actividad
                startActivity(intent)
            }
        }
    }
}
