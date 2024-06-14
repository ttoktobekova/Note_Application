package com.example.noteapp.UI.fragment.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp.DATA.model.NoteModel
import com.example.noteapp.Extension.getBackStakeData
import com.example.noteapp.R
import com.example.noteapp.UI.adapter.NoteAdapter
import com.example.noteapp.databinding.FragmentNoteBinding

class NoteFragment : Fragment() {
    private lateinit var binding: FragmentNoteBinding
    private val noteAdapter = NoteAdapter()
    private val list: ArrayList<NoteModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        getData()

    }

    private fun initialize() {
        binding.rvHome.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = noteAdapter

            binding.imgGridLl.setOnClickListener {
                layoutManager = GridLayoutManager(requireContext(), 2)
                adapter = noteAdapter
                binding.imgGridLl2.visibility = View.VISIBLE
                binding.imgGridLl.visibility = View.INVISIBLE
            }

            binding.imgGridLl2.setOnClickListener {
                binding.imgGridLl2.visibility = View.INVISIBLE
                binding.imgGridLl.visibility = View.VISIBLE
                layoutManager = LinearLayoutManager(requireContext())
                adapter = noteAdapter

            }

        }

    }


    private fun setupListener() {
        binding.fabBtnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_noteFragment_to_noteDetailFragment)
        }
    }

    private fun getData() {
        getBackStakeData<String>("key") { data ->
            val noteModel = NoteModel(data)
            list.add(noteModel)
            noteAdapter.submitList(list)
        }
    }


//    private fun setupListener() = binding.apply {
//        val preferences = PreferenceHelper()
//        preferences.unit(requireContext())
//        preferences.isOnBoardShow = true
//        btnSave.setOnClickListener {
//            val et = etText.text.toString()
//            preferences.textShared = et
//            tvSave.text = et
//        }
//        tvSave.text = preferences.textShared
//    }

}

