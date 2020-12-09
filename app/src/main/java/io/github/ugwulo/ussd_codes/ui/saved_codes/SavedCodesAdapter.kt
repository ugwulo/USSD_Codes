package io.github.ugwulo.ussd_codes.ui.saved_codes

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.ugwulo.ussd_codes.data.NewCodeListItem
import io.github.ugwulo.ussd_codes.databinding.DetailsListItemBinding
import kotlinx.android.synthetic.main.details_list_item.view.*

class SavedCodesAdapter(private val context: Context, val codes: MutableList<NewCodeListItem>): RecyclerView.Adapter<SavedCodesAdapter.NewCodeVH>() {

//    private val phoneDialImpl: PhoneDialImpl = context as PhoneDialImpl
    lateinit var  binding: DetailsListItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewCodeVH {
        binding = DetailsListItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)

        return NewCodeVH(binding)
    }

    override fun getItemCount(): Int {
        return codes.size
    }

    override fun onBindViewHolder(holder: NewCodeVH, position: Int) {
        holder.bind(codes[position].codeName, codes[position].code)
    }

    interface PhoneDialImpl{
        fun handleBankPhoneDial(code: String)
    }
    inner class NewCodeVH(itemView: DetailsListItemBinding) : RecyclerView.ViewHolder(itemView.root) {

        fun bind(codeName: String, code: String){
            itemView.tv_code_name.text = codeName
            itemView.tv_code.text = code
            itemView.ic_phone_dial.setOnClickListener{
//                phoneDialImpl.handleBankPhoneDial(code)
            }
        }

    }
}