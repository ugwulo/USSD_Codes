package nigeria.network.ussd.bank.cod.ui.onboarding

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import nigeria.network.ussd.bank.cod.R


class Fragment3 : Fragment() {

    private lateinit var showDoneTextImpl: ShowDoneTextImpl
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_3, container, false)
    }

    override fun onResume() {
        super.onResume()
        showDoneTextImpl.showText()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        showDoneTextImpl = context as ShowDoneTextImpl

    }

    override fun onPause() {
        super.onPause()
        showDoneTextImpl.disableText()
    }


    companion object{
        fun newInstance() = Fragment3()
    }

    interface ShowDoneTextImpl{
        fun showText()
        fun disableText()
    }
}