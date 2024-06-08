package com.example.noteapp.UI.fragment.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.noteapp.R
import com.example.noteapp.UI.utils.PreferenceHelper
import com.example.noteapp.databinding.FragmentNoteBinding

class NoteFragment : Fragment() {
    private lateinit var binding: FragmentNoteBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()


    }

    private fun setupListener() = binding.apply {
        val preferences = PreferenceHelper()
        preferences.unit(requireContext())
        preferences.isOnBoardShow = true
        btnSave.setOnClickListener {
            val et = etText.text.toString()
            preferences.textShared = et
            tvSave.text = et
        }
        tvSave.text = preferences.textShared
    }

}

