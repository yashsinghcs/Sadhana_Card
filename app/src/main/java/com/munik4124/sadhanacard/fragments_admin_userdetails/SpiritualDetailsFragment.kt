package com.munik4124.sadhanacard.fragments_admin_userdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.textfield.TextInputLayout
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
class SpiritualDetailsFragment : Fragment() {
   

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding = inflater.inflate(R.layout.fragment_spiritual_details, container, false)

        val autoCompletetextField_devotee_or_not : AutoCompleteTextView = binding.findViewById(R.id.devotee_or_not)
        val forHowManyYears : TextInputLayout = binding.findViewById(R.id.for_how_many_years)
        val doYouChant : TextInputLayout = binding.findViewById(R.id.doYouChant)
        val initiatedOrNot : TextInputLayout = binding.findViewById(R.id.initiatedOrNot)

        val languages1 = resources.getStringArray(R.array.choise)
        val arrayAdapter1 = ArrayAdapter(requireContext(), R.layout.blood_group, languages1)
        autoCompletetextField_devotee_or_not.setAdapter(arrayAdapter1)

        autoCompletetextField_devotee_or_not.setOnItemClickListener(OnItemClickListener { parent, arg1, pos, id ->
            if(arrayAdapter1.getItem(pos).equals("Yes")) {
                forHowManyYears.setEnabled(true);
            }
            else{
                forHowManyYears.setEnabled(false);
            }
            Toast.makeText(
                activity,
                " selected" + arrayAdapter1.getItem(pos),
                Toast.LENGTH_LONG
            ).show()
        })

        val autoCompletetextField_do_you_chant : AutoCompleteTextView = binding.findViewById(R.id.do_you_chant)

        val languages2 = resources.getStringArray(R.array.choise)
        val arrayAdapter2 = ArrayAdapter(requireContext(), R.layout.blood_group, languages2)
        autoCompletetextField_do_you_chant.setAdapter(arrayAdapter2)

        autoCompletetextField_do_you_chant.setOnItemClickListener(OnItemClickListener { parent, arg1, pos, id ->
            if(arrayAdapter1.getItem(pos).equals("Yes")) {
                doYouChant.setEnabled(true);
            }
            else{
                doYouChant.setEnabled(false);
            }
            Toast.makeText(
                activity,
                " selected" + arrayAdapter2.getItem(pos),
                Toast.LENGTH_LONG
            ).show()
        })

        val autoCompletetextField_initiated_or_not : AutoCompleteTextView = binding.findViewById(R.id.initiated_or_not)

        val languages3 = resources.getStringArray(R.array.choise)
        val arrayAdapter3 = ArrayAdapter(requireContext(), R.layout.blood_group, languages3)
        autoCompletetextField_initiated_or_not.setAdapter(arrayAdapter3)

        autoCompletetextField_initiated_or_not.setOnItemClickListener(OnItemClickListener { parent, arg1, pos, id ->
            if(arrayAdapter1.getItem(pos).equals("Yes")) {
                initiatedOrNot .setEnabled(true);
            }
            else{
                initiatedOrNot .setEnabled(false);
            }
            Toast.makeText(
                activity,
                " selected" + arrayAdapter3.getItem(pos),
                Toast.LENGTH_LONG
            ).show()
        })

        val next : Button = binding.findViewById(R.id.button_next_AdditionalDetails)
        val v : ViewPager = activity!!.findViewById(R.id.viewPager)

        next.setOnClickListener {

            v.setCurrentItem(v.currentItem + 1, true)


        }
        return binding
    }

}