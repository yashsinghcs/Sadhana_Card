package com.munik4124.sadhanacard.fragments_admin_userdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
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
 * Use the [AdditionalDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AdditionalDetailsFragment : Fragment() {
    // TODO: Rename and change types of parameters

private lateinit var mention : EditText
private lateinit var register : Button
private lateinit var a : PersonalDetailsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var binding = inflater.inflate(R.layout.fragment_additional_details, container, false)

        val interested : AutoCompleteTextView = binding.findViewById(R.id.interested)
        val languages1 = resources.getStringArray(R.array.choise)
        val arrayAdapter1 = ArrayAdapter(requireContext(), R.layout.blood_group, languages1)
       interested.setAdapter(arrayAdapter1)

        val aware_sadhnaCard : AutoCompleteTextView = binding.findViewById(R.id.aware_sadhnaCard)
        val languages2 = resources.getStringArray(R.array.choise)
        val arrayAdapter2 = ArrayAdapter(requireContext(), R.layout.blood_group, languages2)
        aware_sadhnaCard.setAdapter(arrayAdapter2)

        val badHabbits : AutoCompleteTextView = binding.findViewById(R.id.badHabbits)
        val languages3 = resources.getStringArray(R.array.choise)
        val arrayAdapter3 = ArrayAdapter(requireContext(), R.layout.blood_group, languages3)
        badHabbits.setAdapter(arrayAdapter3)

        val visitedTemple : AutoCompleteTextView = binding.findViewById(R.id.visitedTemple)
        val languages4 = resources.getStringArray(R.array.choise)
        val arrayAdapter4 = ArrayAdapter(requireContext(), R.layout.blood_group, languages4)
        visitedTemple.setAdapter(arrayAdapter4)

        mention = binding.findViewById(R.id.mentionBadHabits)
        register = binding.findViewById(R.id.register)
        register.setOnClickListener {
            val p = AdditionalDetails(interested.text.toString(),aware_sadhnaCard.text.toString(),badHabbits.text.toString(), mention.text.toString(),visitedTemple.text.toString())
            val c = FirebaseClass(AdminUser("a","a","a","a"), activity!!, Personaldetails("a","a","a",1,"A","b"),SpiritualDetails("a","a","a",1,"a","A"),p)
            c.registerUserDetailsAdditionalDetails()

        }
        return binding
    }




}