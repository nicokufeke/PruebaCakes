package cl.eme.pruebasencetd.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.eme.pruebasencetd.databinding.ItemListCakesBinding
import cl.eme.pruebasencetd.model.Cakes
import coil.load


class CakesAdapter: RecyclerView.Adapter<CakesVH>() {

    private val selected = MutableLiveData<Cakes>()

    fun selected() : LiveData<Cakes> = selected

    private val cakesList = mutableListOf<Cakes>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CakesVH {
        val binding = ItemListCakesBinding.inflate(LayoutInflater.from(parent.context))

        return CakesVH(binding)
    }

    override fun onBindViewHolder(holder: CakesVH, position: Int) {
        val cakes = cakesList[position]

        holder.bind(cakes)
        holder.itemView.setOnClickListener {
            selected.value = cakes
        }
    }

    override fun getItemCount() = cakesList.size

    fun update(newCakesList: List<Cakes>) {
        cakesList.clear()
        cakesList.addAll(newCakesList)
        notifyDataSetChanged()
    }
}

class CakesVH(private val binding: ItemListCakesBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(cakes: Cakes) {
    binding.tvImageCake.load(cakes.image)
    binding.tvTitleCake.text = cakes.title
    binding.tvPdCake.text = cakes.previewDescription
    binding.tvSizeCake.text = cakes.size
    binding.tvPriceCake.text = cakes.price
    }
}