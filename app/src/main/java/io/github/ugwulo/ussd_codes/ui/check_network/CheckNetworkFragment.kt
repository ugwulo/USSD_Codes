package io.github.ugwulo.ussd_codes.ui.check_network

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import io.github.ugwulo.ussd_codes.R
import io.github.ugwulo.ussd_codes.data.CheckNetwork
import io.github.ugwulo.ussd_codes.databinding.FragmentCheckNetworkBinding
import io.github.ugwulo.ussd_codes.ui.new_code.NewCodeFragment

/**
 * [CheckNetworkFragment] class for verifying network provider prefixes
 */
class CheckNetworkFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private lateinit var checkNetworkBinding: FragmentCheckNetworkBinding
    private lateinit var bottomNavigationImpl: NewCodeFragment.BottomNavigationImpl

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true)
         checkNetworkBinding = FragmentCheckNetworkBinding.inflate(layoutInflater, container, false)
        populateSpinner()
        return checkNetworkBinding.root
    }

    override fun onAttach(context: Context) {
        bottomNavigationImpl = context as NewCodeFragment.BottomNavigationImpl
        super.onAttach(context)
    }

    override fun onDetach() {
        bottomNavigationImpl.enableBottomNavigation()
        super.onDetach()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(checkNetworkBinding.toolbar)
        checkNetworkBinding.toolbar.title = getString(R.string.check_provider)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        bottomNavigationImpl.disableBottomNavigation()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        //        clear Main Activity's menu and replace with CheckNetworkFragment's menu
        menu.clear()
        super.onCreateOptionsMenu(menu, inflater)
    }

    /** interface to control bottom navigation from Main Activity Class */
    interface BottomNavigationImpl{
        fun disableBottomNavigation()
        fun enableBottomNavigation()
    }

    private fun populateSpinner(){
        val arrayAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, CheckNetwork.getAdapterArray().sorted())
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        checkNetworkBinding.spinner.onItemSelectedListener = this
        checkNetworkBinding.spinner.adapter = arrayAdapter
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        Toast.makeText(requireContext(), "No selection made!", Toast.LENGTH_SHORT).show()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        checkNetworkBinding.buttonVerify.text = CheckNetwork.getNetworkPrefixes()[parent?.getItemAtPosition(pos)]
    }
}