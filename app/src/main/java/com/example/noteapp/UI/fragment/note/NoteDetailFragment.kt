package com.example.noteapp.UI.fragment.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.noteapp.Extension.setBackStackData
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentNoteDetailBinding

class NoteDetailFragment : Fragment() {
    private lateinit var binding: FragmentNoteDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAdd.setOnClickListener {
            val title = binding.etAdd.text.toString()
            setBackStackData("key", title, true)

        }
    }

}