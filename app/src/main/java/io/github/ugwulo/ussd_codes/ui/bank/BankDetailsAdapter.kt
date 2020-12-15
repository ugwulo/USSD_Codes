package io.github.ugwulo.ussd_codes.ui.bank

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.ugwulo.ussd_codes.databinding.DetailsListItemBinding
import java.util.*
import kotlin.collections.HashMap


/** adapter class for individual banks details **/
class BankDetailsAdapter(
    private val context: Context,
    private val mainListData: HashMap<String, String>
):
    RecyclerView.Adapter<BankDetailsAdapter.BankViewHolder>() {



    private val TAG: String = " Bank Search"
    lateinit var  binding: DetailsListItemBinding
    private val phoneDialImpl: PhoneDialImpl = context as PhoneDialImpl
    private var backupData:  HashMap<String, String> = HashMap(mainListData)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankViewHolder {
        binding = DetailsListItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        return BankViewHolder(binding)
    }

    override fun getItemCount(): Int {
      return mainListData.size
    }

    override fun onBindViewHolder(holder: BankViewHolder, position: Int) {
        // retrieve the bank code at given position and display the sorted items
        var pos = 0
        for ((key, value) in mainListData.toSortedMap()){
            if (position == pos) {
                holder.bind(key, value)
            }
            pos++
        }


    }

    /**
     * Interface for handling code phone dials
     */
    interface PhoneDialImpl{
        fun handleBankPhoneDial(code: String)
    }

    inner class BankViewHolder(private val listItemBinding: DetailsListItemBinding)
        : RecyclerView.ViewHolder(listItemBinding.root){

        fun bind(key: String, value: String){
            listItemBinding.tvCodeName.text = key
            listItemBinding.tvCode.text = value

            listItemBinding.icPhoneDial.setOnClickListener{
                phoneDialImpl.handleBankPhoneDial(value)
            }
        }

    }

/** function for performing code search in recyclerview*/
    fun filter(text: String) {
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
