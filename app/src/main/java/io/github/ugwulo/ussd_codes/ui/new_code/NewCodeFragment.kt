package io.github.ugwulo.ussd_codes.ui.new_code

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.ugwulo.ussd_codes.R
import io.github.ugwulo.ussd_codes.data.new_code.NewCode
import io.github.ugwulo.ussd_codes.databinding.FragmentSavedCodesBinding
import io.github.ugwulo.ussd_codes.databinding.SaveCodeDialogBinding

/**
 * Fragment class for New Codes
 */
class NewCodeFragment: Fragment() {

    private lateinit var newCode: List<NewCode>
    private lateinit var newCodeViewModel: NewCodeViewModel
    private lateinit var savedCodesAdapter: NewCodeAdapter
    private lateinit var savedCodesBinding: FragmentSavedCodesBinding
    private lateinit var bottomNavigationImpl: BottomNavigationImpl

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        bottomNavigationImpl = requireActivity() as BottomNavigationImpl
    }

    override fun onDetach() {
        super.onDetach()
        bottomNavigationImpl.enableBottomNavigation()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(savedCodesBinding.toolbar)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        savedCodesBinding.appbarTitle.text = getString(R.string.saved_codes)
        bottomNavigationImpl.disableBottomNavigation()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        savedCodesBinding = FragmentSavedCodesBinding.inflate(layoutInflater,
            container,
        false)
        return savedCodesBinding.root
    }

    private fun init() {
        newCodeViewModel = ViewModelProvider(this@NewCodeFragment).get(NewCodeViewModel::class.java)
        newCodeViewModel.getSavedCodes().observe(viewLifecycleOwner, Observer {
            newCode = it
        })
        savedCodesAdapter = NewCodeAdapter(requireContext(), newCode)

        val linearLayoutManager = LinearLayoutManager(this.activity)
        savedCodesBinding.rvSavedCodes.apply {
            adapter = savedCodesAdapter
            layoutManager = linearLayoutManager
        }

//        add new code using floating action button
        savedCodesBinding.fab.setOnClickListener{
            val alertDialogBuilder = AlertDialog.Builder(requireContext())
            alertDialogBuilder.setTitle("Title")

            val dialogSaveCodeDialogBinding = SaveCodeDialogBinding.inflate(layoutInflater)
            alertDialogBuilder.setView(dialogSaveCodeDialogBinding.root)

            val newCodeViewModel =
                NewCodeViewModel(
                    requireActivity().application
                )
//            alertDialogBuilder.setPositiveButton(7, )
            alertDialogBuilder.show()
        }
    }

    private fun saveNewCode() {
//        newCodeViewModel.insertNewCode()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        //        clear Main Activity's menu and replace with NewCodeFragment's menu
        menu.clear()
        super.onCreateOptionsMenu(menu, inflater)
    }

/** interface to control bottom navigation from Main Activity Class */
    interface BottomNavigationImpl{
        fun disableBottomNavigation()
        fun enableBottomNavigation()
    }
}