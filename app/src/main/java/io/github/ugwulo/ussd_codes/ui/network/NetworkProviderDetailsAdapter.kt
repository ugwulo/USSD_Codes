package io.github.ugwulo.ussd_codes.ui.network

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.ugwulo.ussd_codes.databinding.DetailsListItemBinding

class NetworkProviderDetailsAdapter(private val context: Context,
                                    private val hashMap: HashMap<String, String>)
    : RecyclerView.Adapter<NetworkProviderDetailsAdapter.NetworkProviderVieHolder>() {

    lateinit var  binding: DetailsListItemBinding
    private val clickHandler: ClickHandler = context as ClickHandler


    interface ClickHandler{
        fun handleNetworkProviderPhoneDial(code: String)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NetworkProviderVieHolder {
        binding = DetailsListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)

        return NetworkProviderVieHolder(binding)
    }

    override fun getItemCount(): Int {
        return hashMap.size
    }

    override fun onBindViewHolder(holder: NetworkProviderVieHolder, position: Int) {
        /** retrieve the network provider code at given position and display the sorted items**/
        var pos = 0
        for (entry: Map.Entry<String, String> in hashMap.toSortedMap().entries){
            if (position == pos){
                val key = entry.key
                val value = entry.value
                holder.bind(key, value)
            }
            pos++
        }
    }

    inner class NetworkProviderVieHolder(private val listItemBinding: DetailsListItemBinding)
        : RecyclerView.ViewHolder(listItemBinding.root) {

        fun bind(key: String, value: String){
            listItemBinding.tvCodeName.text = key
            listItemBinding.tvCode.text = value

            listItemBinding.icPhoneDial.setOnClickListener{
                clickHandler.handleNetworkProviderPhoneDial(value)
            }
        }

    }
}