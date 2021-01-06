package io.github.ugwulo.ussd_codes.ui.network

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.ugwulo.ussd_codes.databinding.DetailsListItemBinding
import java.util.*
import kotlin.collections.HashMap

/**
 * NetworkProvider details adapter class
 */
class NetworkProviderDetailsAdapter(private val context: Context,
                                    private val mainListData: HashMap<String, String>)
    : RecyclerView.Adapter<NetworkProviderDetailsAdapter.NetworkProviderVieHolder>() {

    private val backupData: HashMap<String, String> = HashMap(mainListData)
    lateinit var  binding: DetailsListItemBinding
    private val phoneDialImpl: PhoneDialImpl = context as PhoneDialImpl


    /**
     * Interface for handling code phone dials
     */
    interface PhoneDialImpl{
        fun handlePhoneDial(code: String)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NetworkProviderVieHolder {
        binding = DetailsListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)

        return NetworkProviderVieHolder(binding)
    }

    override fun getItemCount(): Int {
        return mainListData.size
    }

    override fun onBindViewHolder(holder: NetworkProviderVieHolder, position: Int) {
//        retrieve the network provider code at given position and display the sorted items
        var pos = 0
        for ((key, value) in mainListData.toSortedMap()) {
            if (position == pos) {
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
                phoneDialImpl.handlePhoneDial(value)
            }
        }

    }

    /** function for performing code search in recyclerview*/
    fun filter(text: String) {
        var newMap: HashMap<String, String> = HashMap()
        text.toLowerCase(Locale.ROOT)
        mainListData.clear()

        var pos = 0
        for ((key, value) in backupData) {
            if (key.toLowerCase(Locale.ROOT).contains(text)) {
                mainListData[key] = value
            }

            pos++
        }

        notifyDataSetChanged()
    }
}