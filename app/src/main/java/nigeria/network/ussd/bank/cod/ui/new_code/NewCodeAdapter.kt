package nigeria.network.ussd.bank.cod.ui.new_code

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nigeria.network.ussd.bank.cod.data.new_code.NewCode
import nigeria.network.ussd.bank.cod.databinding.DetailsListItemBinding

class NewCodeAdapter (private val context: Context):
    RecyclerView.Adapter<NewCodeAdapter.NewCodeVH>() {


    private var codes: List<NewCode> = ArrayList()
    private val phoneDialImpl: PhoneDialImpl =  context as PhoneDialImpl
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

    /**
     * [PhoneDialImpl] Interface for handling code phone dials
     */
    interface PhoneDialImpl{
        fun handlePhoneDial(code: String)
    }

    inner class NewCodeVH(private val listItemBinding: DetailsListItemBinding)
        : RecyclerView.ViewHolder(listItemBinding.root) {

        fun bind(codeName: String, code: String){
            listItemBinding.tvCode.text = code
            listItemBinding.tvCodeName.text = codeName
            listItemBinding.icPhoneDial.setOnClickListener{
                phoneDialImpl.handlePhoneDial(code)
            }
        }

    }

    /**
     * [setCode] function for updating saved codes in UI
     */
    fun setCode(code: List<NewCode>) {
        this.codes = code
        notifyDataSetChanged()
    }
}