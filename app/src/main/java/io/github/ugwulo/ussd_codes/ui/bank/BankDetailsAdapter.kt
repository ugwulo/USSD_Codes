package io.github.ugwulo.ussd_codes.ui.bank

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.ugwulo.ussd_codes.databinding.DetailsListItemBinding


/** adapter class for individual banks details **/
class BankDetailsAdapter(
    private val context: Context,
    private val hashMap: HashMap<String, String>
):
    RecyclerView.Adapter<BankDetailsAdapter.BankViewHolder>() {

    lateinit var  binding: DetailsListItemBinding
    private val clickHandler: ClickHandler = context as ClickHandler

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankViewHolder {
        binding = DetailsListItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)

        return BankViewHolder(binding)
    }

    override fun getItemCount(): Int {
      return hashMap.size
    }

    override fun onBindViewHolder(holder: BankViewHolder, position: Int) {
        /** retrieve the bank code at given position and display the sorted items**/
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

    interface ClickHandler{
        fun handleBankPhoneDial(code: String)
    }

    inner class BankViewHolder(private val listItemBinding: DetailsListItemBinding)
        : RecyclerView.ViewHolder(listItemBinding.root){
        fun bind(key: String, value: String){
            listItemBinding.tvCodeName.text = key
            listItemBinding.tvCode.text = value

            listItemBinding.icPhoneDial.setOnClickListener{
                clickHandler.handleBankPhoneDial(value)
            }
        }


    }
}