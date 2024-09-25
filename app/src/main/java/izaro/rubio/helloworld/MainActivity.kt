package izaro.rubio.helloworld

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.d("HelloWorld", "IZARO onCreate" )


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