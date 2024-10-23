package izaro.rubio.helloworld.listPackage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import izaro.rubio.helloworld.databinding.RowItemBinding

class CustomAdapter(private val dataSet: MutableList<ShopItem>, private val listener: ItemListener) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: RowItemBinding):RecyclerView.ViewHolder(binding.root){
        //private var currentItem: String?=null ESTO ERA ANTES DE TENER LOS SHOPITEM(funcionabamos con strings)
        private var currentItem: ShopItem?=null
        init {
            binding.root.setOnClickListener {
                currentItem?.let{
                    listener.itemClicked(it)
                }
            }
        }
        fun bind(item: ShopItem){
            currentItem= item
            binding.rowItemText.text= "${item.name} - ${item.quantity}"
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        //viewHolder.binding.rowItemText.text = dataSet [position]
        val item = dataSet [position]
        viewHolder.bind(item)
    }

    override fun getItemCount()= dataSet.size

    fun updateData(newDataSet: MutableList<ShopItem>) {
        dataSet.clear()
        dataSet.addAll(newDataSet)
        notifyDataSetChanged()
    }
}

interface ItemListener{
    fun itemClicked(item: ShopItem)
}
