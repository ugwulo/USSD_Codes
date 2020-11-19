package io.github.ugwulo.ussd_codes.ui.bank

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import io.github.ugwulo.ussd_codes.R
import io.github.ugwulo.ussd_codes.data.BankModel
import io.github.ugwulo.ussd_codes.databinding.MainListItemBinding

/** adapter class for individual banks **/
class BankAdapter(private val data: ArrayList<BankModel>): RecyclerView.Adapter<BankAdapter.BankHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankHolder {
       return BankHolder(MainListItemBinding.inflate(LayoutInflater.from(parent.context),
           parent,
           false))
    }

    override fun getItemCount(): Int {
       return data.size
    }

    override fun onBindViewHolder(holder: BankHolder, position: Int) {
        val model: BankModel = data[position]
        holder.bind(model.bankName, model.bankLogo)
    }

    class BankHolder(private val mainListItemBinding: MainListItemBinding): RecyclerView.ViewHolder(mainListItemBinding.root){
        fun bind(name: String, logoId: Int){
            val bundle = bundleOf("BANK_NAME" to name)
            mainListItemBinding.name.text = name
            mainListItemBinding.logo.setImageResource(logoId)
            mainListItemBinding.cvContainer.setOnClickListener{
                Navigation.findNavController(it).navigate(R.id.action_navigation_bank_to_bankDetailsFragment, bundle)
            }
        }
    }
}