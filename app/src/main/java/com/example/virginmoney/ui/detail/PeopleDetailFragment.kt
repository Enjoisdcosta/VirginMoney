package com.example.virginmoney.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.virginmoney.R
import com.example.virginmoney.databinding.FragmentPeopleBinding
import com.example.virginmoney.databinding.FragmentPeopleDetailBinding

class PeopleDetailFragment : Fragment() {

    lateinit var binding: FragmentPeopleDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPeopleDetailBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        val firstName = arguments?.getString("First Name")
        val lastName = arguments?.getString("Last Name")
        val email = arguments?.getString("Email")
        val jobTitle = arguments?.getString("Job Title")
        val favoriteColor = arguments?.getString("Fav color")
        val profileImage = arguments?.getString("Fav color")

        binding.apply {
            firstNameDetail.text = firstName
            lastNameDetail.text = lastName
            emailDetail.text = email
            jobTitleDetail.text = jobTitle
            favoriteColorDetail.text = favoriteColor
            Glide.with(requireContext()).load(profileImage).into(profileImageDetail)

        }


        return binding.root
    }
}