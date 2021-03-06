package com.munik4124.sadhanacard.fragments_admin_userdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.textfield.TextInputLayout
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
class SpiritualDetailsFragment : Fragment() {
   
private lateinit var devotee_or_not : EditText
private lateinit var do_you_chant : EditText
private lateinit var initiated_or_not : EditText
private lateinit var autoCompletetextField_devotee_or_not : AutoCompleteTextView
private lateinit var autoCompletetextField_do_you_chant : AutoCompleteTextView
private lateinit var autoCompletetextField_initiated_or_not : AutoCompleteTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding = inflater.inflate(R.layout.fragment_spiritual_details, container, false)

      autoCompletetextField_devotee_or_not = binding.findViewById(R.id.devotee_or_not)
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

         autoCompletetextField_do_you_chant  = binding.findViewById(R.id.do_you_chant)

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

         autoCompletetextField_initiated_or_not = binding.findViewById(R.id.initiated_or_not)

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

        devotee_or_not = binding.findViewById(R.id.devotee_or_not_edit_text)
        do_you_chant = binding.findViewById(R.id.do_you_chant_edit_text)
        initiated_or_not = binding.findViewById(R.id.initiated_or_not_edit_text)


        val next : Button = binding.findViewById(R.id.button_next_AdditionalDetails)
        val v : ViewPager = activity!!.findViewById(R.id.viewPager)

        next.setOnClickListener {
            if(checkForValidation()) {
                val p = SpiritualDetails(autoCompletetextField_devotee_or_not.text.toString(), devotee_or_not.text.toString(), autoCompletetextField_do_you_chant.text.toString(), Integer.parseInt(do_you_chant.text.toString()), autoCompletetextField_initiated_or_not.text.toString(), initiated_or_not.text.toString())
                val c = FirebaseClass(AdminUser("a", "a", "a", "a"), activity!!, Personaldetails("a", "a", "a", 1, "A", "b"), p, AdditionalDetails("a", "A", "A", "A", "A"))
                c.registerUserDetailsSpiritual()
                v.setCurrentItem(v.currentItem + 1, true)
            }
        }
        return binding
    }
    private fun checkForValidation() : Boolean {
        if(autoCompletetextField_devotee_or_not.text.toString().isEmpty()) {
            autoCompletetextField_devotee_or_not.error = "please select an option"
            autoCompletetextField_devotee_or_not.requestFocus()
            return false
        }
        if(autoCompletetextField_devotee_or_not.text.toString().equals("Yes")) {
            if (devotee_or_not.text.toString().isEmpty()) {
                devotee_or_not.error = "please fill for how many years"
                devotee_or_not.requestFocus()
                return false
            }
        }
        else{
            devotee_or_not.setText("null")
        }
        if(autoCompletetextField_do_you_chant.text.toString().isEmpty()) {
            autoCompletetextField_do_you_chant.error = "please select an option"
            autoCompletetextField_do_you_chant.requestFocus()
            return false
        }
        if(autoCompletetextField_do_you_chant.text.toString().equals("Yes")) {
            if (do_you_chant.text.toString().isEmpty()) {
                do_you_chant.error = "please enter the no of rounds"
                do_you_chant.requestFocus()
                return false
            }
        }
        else{
            do_you_chant.setText("0")
        }
        if(autoCompletetextField_initiated_or_not.text.toString().isEmpty()) {
            autoCompletetextField_initiated_or_not.error = "please select an option"
            autoCompletetextField_initiated_or_not.requestFocus()
            return false
        }
        if(autoCompletetextField_initiated_or_not.text.toString().equals("Yes")) {
            if (initiated_or_not.text.toString().isEmpty()) {
                initiated_or_not.error = "please enter the maharajs name"
                initiated_or_not.requestFocus()
                return false
            }
        }
        else{
            initiated_or_not.setText("null")
        }
        return true
    }
}