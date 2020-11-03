package io.github.ugwulo.ussd_codes.ui.network

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import io.github.ugwulo.ussd_codes.R

class NetworkProviderFragment : Fragment() {

    private lateinit var networkProviderViewModel: NetworkProviderViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        networkProviderViewModel =
                ViewModelProvider(this).get(NetworkProviderViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_network_provider, container, false)
        val textView: TextView = root.findViewById(R.id.text_network)
        networkProviderViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}