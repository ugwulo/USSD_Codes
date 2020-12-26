package io.github.ugwulo.ussd_codes.ui.network

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import io.github.ugwulo.ussd_codes.R
import io.github.ugwulo.ussd_codes.data.network_provider.NetworkProviderModel
import io.github.ugwulo.ussd_codes.databinding.MainListItemBinding

class NetworkProviderAdapter(private val data: ArrayList<NetworkProviderModel>, private val context: Context):
    RecyclerView.Adapter<NetworkProviderAdapter.NetworkHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NetworkHolder {
        return NetworkHolder(
            MainListItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: NetworkHolder, position: Int) {
        val data: NetworkProviderModel = data[position]
        holder.bind(data.networkName, data.logoId)

    }

    inner class NetworkHolder(private val mainListItemBinding: MainListItemBinding): RecyclerView.ViewHolder(mainListItemBinding.root){
        fun bind(name: String, logoId: Int){

//    passing the network provider's name bundle to determine the clicked item in the details fragment
            val bundle = bundleOf("NETWORK_PROVIDER_NAME" to name)
            mainListItemBinding.name.text = name
            mainListItemBinding.logo.setImageResource(logoId)

            mainListItemBinding.cvContainer.setOnClickListener{

//                navigate to CheckNetwork fragment when name matches
                if (name == context.getString(R.string.check_network)) {
                    Navigation.findNavController(it).navigate(R.id.action_navigation_network_provider_to_checkNetworkFragment)
                } else Navigation.findNavController(it).navigate(R.id.action_navigation_network_provider_to_networkProviderDetailsFragment, bundle)
            }
        }
    }
}