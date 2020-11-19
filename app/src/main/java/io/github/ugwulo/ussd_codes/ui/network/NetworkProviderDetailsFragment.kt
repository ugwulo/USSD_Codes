package io.github.ugwulo.ussd_codes.ui.network

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.ugwulo.ussd_codes.R
import io.github.ugwulo.ussd_codes.data.BankCodes
import io.github.ugwulo.ussd_codes.data.NetworkProviderCodes
import io.github.ugwulo.ussd_codes.databinding.FragmentBankDetailsBinding
import io.github.ugwulo.ussd_codes.databinding.FragmentNetworkProviderDetailsBinding
import io.github.ugwulo.ussd_codes.ui.bank.BankDetailsAdapter
import java.lang.IllegalArgumentException


class NetworkProviderDetailsFragment : Fragment() {
    private var networkProviderDetailsAdapter: NetworkProviderDetailsAdapter? = null
    private lateinit var networkProviderName: String
    lateinit var networkDetailsBinding: FragmentNetworkProviderDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadArguments()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        networkDetailsBinding = FragmentNetworkProviderDetailsBinding.inflate(layoutInflater,
            container,
            false)
        return networkDetailsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    /** get arguments from bundle to show a specific network provider's codes **/
    private fun loadArguments() {
        arguments?.getString("NETWORK_PROVIDER_NAME")?.let {
            networkProviderName = it
        }
    }

    private fun init() {

        /** bundle $networkProviderName determines the parameter passed to the NetworkProviderDetailsAdapter **/
        when(networkProviderName){
            getString(R.string.mtn) -> {
                networkProviderDetailsAdapter = NetworkProviderDetailsAdapter(requireContext(),
                    NetworkProviderCodes.getMTNCodes()
                )
            }
            getString(R.string._9_mobile) -> {
                networkProviderDetailsAdapter = NetworkProviderDetailsAdapter(
                    requireContext(),
                    NetworkProviderCodes.getMTNCodes()
                )
            }

        }

        val linearLayoutManager = LinearLayoutManager(this.activity)
        networkDetailsBinding.rvNetworkProviderDetails.apply {
            try {
                adapter = networkProviderDetailsAdapter!!
            } catch (e: IllegalArgumentException){
                Toast.makeText(requireContext(), "No USSD for this Provider", Toast.LENGTH_SHORT).show()
            }
            layoutManager = linearLayoutManager
        }
    }
}