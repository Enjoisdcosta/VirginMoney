package com.example.virginmoney.ui.people

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoney.R
import com.example.virginmoney.databinding.FragmentPeopleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleFragment : Fragment() {

    private var _binding: FragmentPeopleBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val peopleViewModel =
            ViewModelProvider(this).get(PeopleViewModel::class.java)

        _binding = FragmentPeopleBinding.inflate(inflater, container, false)
        val root: View = binding.root



        binding.apply{
//            val textView: TextView = binding.peopleIdText
//            peopleViewModel.text.observe(viewLifecycleOwner) {
//                textView.text = it
//            peopleIdText.setOnClickListener{
//                findNavController().navigate(R.id.peopleIdText)
//
//            }
            peopleViewModel.peopleList.observe(viewLifecycleOwner){
                rvPeople.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = PeopleAdapter(it) {peopleItemModel ->
                        findNavController().navigate(R.id.action_peopleFragment_to_peopleDetailFragment,
                            bundleOf(
                                Pair("firstName",peopleItemModel.firstName),
                                Pair("lastName",peopleItemModel.lastName),
                                Pair("email",peopleItemModel.email),
                                Pair("jobTitle",peopleItemModel.jobtitle),
                                Pair("favoriteColor",peopleItemModel.favouriteColor),
                                Pair("profileImage",peopleItemModel.avatar)

                            )
                        )

                    }
                }
            }


        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}