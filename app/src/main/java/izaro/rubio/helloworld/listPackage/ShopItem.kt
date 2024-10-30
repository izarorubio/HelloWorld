package izaro.rubio.helloworld.listPackage

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShopItem (val name: String, val quantity: Int? = null) : Parcelable{
    private fun getShopItems(): Array<ShopItem>{
        val dataset=arrayOf(ShopItem("patatas",5), ShopItem("huevos",12))
        return dataset
    }
}

