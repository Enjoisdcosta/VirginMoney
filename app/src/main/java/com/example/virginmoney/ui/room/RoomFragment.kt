package com.example.virginmoney.ui.room

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoney.databinding.FragmentPeopleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class RoomFragment : Fragment() {

    private var _binding: FragmentPeopleBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val roomViewModel =
            ViewModelProvider(this).get(RoomViewModel::class.java)

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
            roomViewModel.roomList.observe(viewLifecycleOwner){
                rvPeople.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = RoomAdapter(it)
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