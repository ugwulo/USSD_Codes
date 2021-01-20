package nigeria.network.ussd.bank.cod.ui.bank

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import nigeria.network.ussd.bank.cod.R
import nigeria.network.ussd.bank.cod.data.bank.BankModel
import nigeria.network.ussd.bank.cod.databinding.MainListItemBinding

/** adapter class for individual banks **/
class BankAdapter(private val data: ArrayList<BankModel>): RecyclerView.Adapter<BankAdapter.BankHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankHolder {
       return BankHolder(
           MainListItemBinding.inflate(LayoutInflater.from(parent.context),
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

//            passing the bank's name bundle to determine the clicked item in the details fragment
            val bundle = bundleOf("BANK_NAME" to name)
            mainListItemBinding.name.text = name
            mainListItemBinding.logo.setImageResource(logoId)
            mainListItemBinding.cvContainer.setOnClickListener{
                Navigation.findNavController(it).navigate(R.id.action_navigation_bank_to_bankDetailsFragment, bundle)
            }
        }
    }
}