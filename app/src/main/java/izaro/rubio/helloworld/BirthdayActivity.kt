package izaro.rubio.helloworld

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import izaro.rubio.helloworld.databinding.ActivityBirthdayBinding
import izaro.rubio.helloworld.databinding.ActivityMainBinding

class BirthdayActivity : AppCompatActivity() {

    private lateinit var binding:ActivityBirthdayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        binding = ActivityBirthdayBinding.inflate(layoutInflater)
        setContentView(binding.main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.titleTextView.text= "IT'S YOUR BIRTHDAY"
        binding.yearsTextView.text= "42 YEARS?!"
    }
}
