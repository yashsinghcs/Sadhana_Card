@file:JvmName("PersonalDetailsFragmenTKt")

package com.munik4124.sadhanacard.fragments_admin_userdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.viewpager.widget.ViewPager
import com.munik4124.sadhanacard.AdminUser
import com.munik4124.sadhanacard.FirebaseClass
import com.munik4124.sadhanacard.R
import com.munik4124.sadhanacard.userExtraDetails_Admin.AdditionalDetails
import com.munik4124.sadhanacard.userExtraDetails_Admin.Personaldetails
import com.munik4124.sadhanacard.userExtraDetails_Admin.SpiritualDetails

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PersonalDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PersonalDetailsFragment : Fragment() {

    private lateinit var first_name : EditText
    private lateinit var last_name : EditText
    private lateinit var age : EditText
    private lateinit var address : EditText
    private lateinit var phoneNo : EditText
    private lateinit var autoCompletetextField : AutoCompleteTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         var binding =  inflater.inflate(R.layout.fragment_personal_details, container, false)

        autoCompletetextField  = binding.findViewById(R.id.autoCompleteTextField)
        val next : Button = binding.findViewById(R.id.button_next_personalDetails)

        val languages = resources.getStringArray(R.array.blood_group)
        val arrayAdapter = ArrayAdapter(requireContext(),R.layout.blood_group,languages)
        autoCompletetextField.setAdapter(arrayAdapter)  //PersonalDetailsFragment

        first_name = binding.findViewById(R.id.first_name)
        last_name = binding.findViewById(R.id.last_name)
        age = binding.findViewById(R.id.age)
        address = binding.findViewById(R.id.address)
        phoneNo = binding.findViewById(R.id.phone_no)

         val v : ViewPager = activity!!.findViewById(R.id.viewPager)
        next.setOnClickListener {
            if(checkForValidation()) {
                val p = Personaldetails(first_name.text.toString(), last_name.text.toString(), autoCompletetextField.text.toString(), Integer.parseInt(age.text.toString()), address.text.toString(), phoneNo.text.toString())
                val c = FirebaseClass(AdminUser("a", "a", "a", "a"), activity!!, p, SpiritualDetails("a", "a", "a", 1, "a", "A"), AdditionalDetails("a", "A", "A", "A", "A"))
                c.registerUserDetails()
                v.setCurrentItem(v.currentItem + 1, true)
            }

        }

        return binding
    }
    private fun checkForValidation() : Boolean {
        if(first_name.text.toString().isEmpty()) {
            first_name.error = "please enter your firstname"
            first_name.requestFocus()
            return false
        }
        if(last_name.text.toString().isEmpty()) {
            last_name.error = "please enter the lastname"
            last_name.requestFocus()
            return false
        }
        if(autoCompletetextField.text.toString().isEmpty()) {
            autoCompletetextField.error = "please select a blood group"
            autoCompletetextField.requestFocus()
            return false
        }
        if(age.text.toString().isEmpty()) {
            age.error = "please enter the age"
            age.requestFocus()
            return false
        }
        if(address.text.toString().isEmpty()) {
            address.error = "please enter the address"
            address.requestFocus()
            return false
        }
        if(phoneNo.text.toString().isEmpty()) {
            phoneNo.error = "please enter the phone-no"
            phoneNo.requestFocus()
            return false
        }
        return true
    }
}