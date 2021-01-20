package nigeria.network.ussd.bank.cod.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import nigeria.network.ussd.bank.cod.R


class Fragment0 : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_0, container, false)

        return root
    }

    companion object{
        fun newInstance() = Fragment0()
    }
    override fun onClick(view : View?){

    }
}