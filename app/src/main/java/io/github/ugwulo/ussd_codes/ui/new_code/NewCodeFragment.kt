package io.github.ugwulo.ussd_codes.ui.new_code

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.ugwulo.ussd_codes.R
import io.github.ugwulo.ussd_codes.data.new_code.NewCode
import io.github.ugwulo.ussd_codes.databinding.FragmentNewCodeBinding
import io.github.ugwulo.ussd_codes.databinding.SaveCodeDialogBinding

/**
 * [NewCodeFragment] class for New Codes
 */
class NewCodeFragment : Fragment() {
    private val TAG = "NewCodeFragment"
    private lateinit var newCodeViewModel: NewCodeViewModel
    private lateinit var savedCodesAdapter: NewCodeAdapter
    private lateinit var newCodeBinding: FragmentNewCodeBinding
    private lateinit var bottomNavigationImpl: BottomNavigationImpl


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
        (activity as AppCompatActivity).setSupportActionBar(newCodeBinding.toolbar)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        newCodeBinding.appbarTitle.text = getString(R.string.saved_codes)
        bottomNavigationImpl.disableBottomNavigation()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        newCodeBinding = FragmentNewCodeBinding.inflate(layoutInflater,
            container,
            false)
        init()
        return newCodeBinding.root
    }

    private fun init() {
        Log.d(TAG, "init: CALLED")
        newCodeViewModel = ViewModelProvider(this).get(NewCodeViewModel::class.java)
        val linearLayoutManager = LinearLayoutManager(this.activity)
        savedCodesAdapter = NewCodeAdapter(requireContext())
        newCodeBinding.rvSavedCodes.apply {
            adapter = savedCodesAdapter
            layoutManager = linearLayoutManager
        }
        newCodeViewModel.getSavedCodes().observe(viewLifecycleOwner, Observer {
            savedCodesAdapter.setCode(it)
        })

//        remove default text when a new code is saved
        newCodeViewModel.getDataCount().observe(viewLifecycleOwner, Observer {
            if (it > 0) {
                newCodeBinding.defaultText.visibility = View.GONE
            } else newCodeBinding.defaultText.visibility = View.VISIBLE
        })

//        add new code using floating action button and Alert Dialog
        newCodeBinding.fab.setOnClickListener{
            val newCodeDialog = AlertDialog.Builder(requireContext())
            newCodeDialog.setTitle(getString(R.string.save_code))

            val saveCodeDialogBinding = SaveCodeDialogBinding.inflate(layoutInflater)
            newCodeDialog.setView(saveCodeDialogBinding.root)
            newCodeDialog.setCancelable(false)
            newCodeDialog.setPositiveButton("Save") {dialog, i ->
                val codeName = saveCodeDialogBinding.tvCodeName.text.toString()
                val code = saveCodeDialogBinding.tvCode.text.toString()
                if (code.isBlank() || codeName.isBlank()) {
                    Toast.makeText(requireContext(), "Fields must not be empty", Toast.LENGTH_SHORT).show()
                } else {
                    val newCode = NewCode(codeName, code)
                    saveNewCode(newCode)
                }
            }

            newCodeDialog.setNegativeButton("Cancel") {dialog, i ->
                newCodeDialog.setCancelable(true)
            }
            newCodeDialog.show()
        }
    }

    private fun saveNewCode(code: NewCode) {
        newCodeViewModel.insertNewCode(code)
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