package izaro.rubio.helloworld

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import izaro.rubio.helloworld.databinding.ActivityBirthdayBinding
import izaro.rubio.helloworld.databinding.ActivityMainBinding
import izaro.rubio.helloworld.databinding.ActivityUsuarioSaludoBinding

class UsuarioSaludoActivity : AppCompatActivity() {

    private lateinit var binding:ActivityUsuarioSaludoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityUsuarioSaludoBinding.inflate(layoutInflater)
        setContentView(binding.main)
        //ActionBar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Obtener los extras del Intent guardado
        val username = intent.extras!!.getString("usernameKey")
        // Obtener el saludo formateado desde strings.xml
        val saludo = getString(R.string.saludo_text, username)
        //Mostrar saludo
        binding.saludoText.text = saludo
    }
}