package io.github.ugwulo.ussd_codes.ui.network

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.ugwulo.ussd_codes.R
import io.github.ugwulo.ussd_codes.data.NetworkProviderCodes
import io.github.ugwulo.ussd_codes.databinding.FragmentNetworkProviderDetailsBinding
import java.lang.IllegalArgumentException


class NetworkProviderDetailsFragment : Fragment() {
    private var networkProviderDetailsAdapter: NetworkProviderDetailsAdapter? = null
    private lateinit var networkProviderName: String
    private lateinit var networkDetailsBinding: FragmentNetworkProviderDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        loadArguments()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.detail_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
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
        retrieveNetworkProviderCodes()
        init()
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(networkDetailsBinding.toolbar)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        networkDetailsBinding.appbarTitle.text = networkProviderName
    }
    /** get arguments from bundle to show a specific network provider's codes **/
    private fun loadArguments() {
        arguments?.getString("NETWORK_PROVIDER_NAME")?.let {
            networkProviderName = it
        }
    }

    private fun init() {
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
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.save -> {
                saveNewNetworkCode()
                true
            }
            R.id.search -> {
                searchNetworkCode()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun searchNetworkCode() {
        Toast.makeText(requireContext(), "Search", Toast.LENGTH_SHORT).show()
    }

    private fun saveNewNetworkCode() {
        Toast.makeText(requireContext(), "Save", Toast.LENGTH_SHORT).show()
    }

    /** bundle $networkProviderName determines the parameter passed to the NetworkProviderDetailsAdapter **/
    private fun retrieveNetworkProviderCodes() {
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
    }

}