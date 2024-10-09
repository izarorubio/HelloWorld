package izaro.rubio.helloworld

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import izaro.rubio.helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //NAVEGAR CON BOTONES
        binding.helloWorldButton.setOnClickListener {
            val intent = Intent(this, UsuarioActivity::class.java)
            startActivity(intent)
        }
        binding.birthdayButton.setOnClickListener {
            val intent = Intent(this, BirthdayActivity::class.java)
            startActivity(intent)
        }

        //Log.d("HelloWorld", "IZARO onCreate" )

    }

    override fun onResume() {
        super.onResume()
        Log.d("HelloWorld", "IZARO onResume" )
    }

    override fun onStart() {
        super.onStart()
        Log.d("HelloWorld", "IZARO onStart" )
    }

    override fun onPause() {
        super.onPause()
        Log.d("HelloWorld", "IZARO onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("HelloWorld", "IZARO onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("HelloWorld", "IZARO onDestroy")
    }
}