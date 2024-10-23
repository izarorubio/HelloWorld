package izaro.rubio.helloworld

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import izaro.rubio.helloworld.databinding.ActivityListBinding
import izaro.rubio.helloworld.listPackage.AddShopItemActivity
import izaro.rubio.helloworld.listPackage.CustomAdapter
import izaro.rubio.helloworld.listPackage.ItemListener
import izaro.rubio.helloworld.listPackage.ListItemActivity
import izaro.rubio.helloworld.listPackage.ShopItem

class ListActivity : AppCompatActivity(), ItemListener {
    private lateinit var binding: ActivityListBinding

    //No entiendo pq hay q ponerlo aquí
    private var dataset=mutableListOf(
        ShopItem("patatas", 5),
        ShopItem("huevos", 12)
    )

    // Registro del lanzador para obtener el resultado de AddShopItemActivity
    private val addShopItemResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val newShopItem: ShopItem? = data?.getParcelableExtra("SHOP_ITEM_KEY")
            newShopItem?.let {
                dataset.add(it)
                binding.myRecyclerView.adapter?.notifyDataSetChanged()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.myRecyclerView.setHasFixedSize(true)

        val layoutManager=LinearLayoutManager(this)
        binding.myRecyclerView.layoutManager=layoutManager

        binding.myRecyclerView.adapter = CustomAdapter(dataset, this)

        // Usar el método estático getCallingIntent para llamar a la Actitvity
        binding.addShopItemFab.setOnClickListener {
            this.addShopItemResultLauncher.launch(AddShopItemActivity.getCallingIntent(this))
        }
    }

    override fun itemClicked(item: ShopItem) {
        //Toast.makeText(this,getString(R.string.  )+item, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, ListItemActivity::class.java)
        intent.putExtra("SHOP_ITEM", item)
        startActivity(intent)
    }

}

