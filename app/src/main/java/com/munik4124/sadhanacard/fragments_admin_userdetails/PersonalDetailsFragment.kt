@file:JvmName("PersonalDetailsFragmenTKt")

package com.munik4124.sadhanacard.fragments_admin_userdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.viewpager.widget.ViewPager
import com.munik4124.sadhanacard.R

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         var binding =  inflater.inflate(R.layout.fragment_personal_details, container, false)

       val autoCompletetextField : AutoCompleteTextView = binding.findViewById(R.id.autoCompleteTextField)
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

            v.setCurrentItem(v.currentItem + 1,true)


        }

        return binding
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onStop() {
        super.onStop()

    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(activity,"please login to continue   ABCD",Toast.LENGTH_SHORT).show()
    }
}