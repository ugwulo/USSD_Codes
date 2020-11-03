package io.github.ugwulo.ussd_codes.ui.bank

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import io.github.ugwulo.ussd_codes.R

class BankFragment : Fragment() {

    private lateinit var bankViewModel: BankViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        bankViewModel =
                ViewModelProvider(this).get(BankViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_bank, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        bankViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}