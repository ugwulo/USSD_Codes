package nigeria.network.ussd.cod.ui.network

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import nigeria.network.ussd.cod.R
import nigeria.network.ussd.cod.data.network_provider.NetworkProviderCodes
import nigeria.network.ussd.cod.databinding.FragmentNetworkProviderDetailsBinding
import nigeria.network.ussd.cod.util.Utils
import java.lang.IllegalArgumentException


class NetworkProviderDetailsFragment : Fragment() {
    val hideSoftKeyboard: Utils = Utils()
    private lateinit var searchItem: MenuItem
    private var networkProviderDetailsAdapter: NetworkProviderDetailsAdapter? = null
    private lateinit var networkProviderName: String
    private lateinit var networkDetailsBinding: FragmentNetworkProviderDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        loadArguments()
    }

    override fun onDetach() {
        super.onDetach()
        hideSoftKeyboard.hideSoftKeyboard(requireActivity())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.detail_menu, menu)
        searchItem = menu.findItem(R.id.search)
        val searchManager = activity?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = searchItem.actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(activity?.componentName))
        searchView.setIconifiedByDefault(true)
        searchView.requestFocus()
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                return true
            }

            override fun onQueryTextChange(searchText: String): Boolean {

                if (TextUtils.isEmpty(searchText)) {
                    networkProviderDetailsAdapter?.filter("")
                } else {
                    networkProviderDetailsAdapter?.filter(searchText)
                }
                return true
            }
        })
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
                view?.let { Navigation.findNavController(it).navigate(R.id.action_networkProviderDetailsFragment_to_newCodeFragment) }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    /** bundle [networkProviderName] determines the parameter passed to the NetworkProviderDetailsAdapter **/
    private fun retrieveNetworkProviderCodes() {
        when(networkProviderName){
            getString(R.string.mtn) -> {
                networkProviderDetailsAdapter = NetworkProviderDetailsAdapter(requireContext(),
                    NetworkProviderCodes.getMTNCodes()
                )
            }
            getString(R.string.airtel) -> {
                networkProviderDetailsAdapter = NetworkProviderDetailsAdapter(
                    requireContext(),
                    NetworkProviderCodes.getAirtelCodes()
                )
            }
            getString(R.string.glo) -> {
                networkProviderDetailsAdapter = NetworkProviderDetailsAdapter(requireContext(),
                    NetworkProviderCodes.getGloCodes()
                )
            }

            getString(R.string._9mobile) -> {
                networkProviderDetailsAdapter = NetworkProviderDetailsAdapter(requireContext(),
                    NetworkProviderCodes.get9MobileCodes()
                )
            }
        }
    }

}