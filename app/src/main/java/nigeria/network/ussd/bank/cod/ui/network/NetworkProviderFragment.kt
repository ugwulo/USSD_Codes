package nigeria.network.ussd.bank.cod.ui.network

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import nigeria.network.ussd.bank.cod.R
import nigeria.network.ussd.bank.cod.data.network_provider.NetworkProviderModel
import nigeria.network.ussd.bank.cod.databinding.FragmentNetworkProviderBinding

class NetworkProviderFragment : Fragment() {

    lateinit var navController: NavController
    lateinit var networkBinding: FragmentNetworkProviderBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        networkBinding = FragmentNetworkProviderBinding.inflate(layoutInflater, container, false)
        return networkBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        init()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(networkBinding.toolbar)
    }
    private fun init() {
        /** create list of Network Providers with their names and logo **/
        val listData: ArrayList<NetworkProviderModel> = ArrayList()
        listData.apply {
            add(
                NetworkProviderModel(
                    getString(R.string.mtn),
                    R.mipmap.mtn_logo_round
                )
            )
            add(
                NetworkProviderModel(
                    getString(R.string._9mobile),
                    R.mipmap.nine_mobile_round
                )
            )
            add(
                NetworkProviderModel(
                    getString(R.string.airtel),
                    R.mipmap.airtel_round
                )
            )
            add(
                NetworkProviderModel(
                    getString(R.string.glo),
                    R.mipmap.glo_round
                )
            )
            add(
                NetworkProviderModel(
                    getString(R.string.check_network),
                    R.mipmap.simcard_round
                )
            )
        }

        val gridLayoutManager = GridLayoutManager(this.context, 2)
        val networkProviderAdapter = NetworkProviderAdapter(listData, requireContext())
        networkBinding.rvNetworkProvider.apply {
            layoutManager = gridLayoutManager
            adapter = networkProviderAdapter
        }
    }

}