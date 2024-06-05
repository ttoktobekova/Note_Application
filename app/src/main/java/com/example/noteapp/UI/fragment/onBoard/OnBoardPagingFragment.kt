package com.example.noteapp.UI.fragment.onBoard

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentOnBoardPagingBinding


class OnBoardPagingFragment : Fragment() {
private lateinit var binding:FragmentOnBoardPagingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardPagingBinding.inflate(layoutInflater)
      return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
           initialize()

    }
        @SuppressLint("ResourceType")
    private fun initialize() = with(binding) {
        when (requireArguments().getInt(ARGS_ON_BOARD_POSITION)) {
            0 -> {
                imgHost.load(R.drawable.img_one)
                tvOn.text = getString(R.string.one)
                btnSkip.setOnClickListener {
                    findNavController().navigate(R.id.action_onBoardFragment_to_noteFragment)
                }
                btnToStart.visibility = View.INVISIBLE

            }

            1 -> {
                imgHost.load(R.drawable.img_two)
                tvOn.text = getString(R.string.two)
                btnSkip.setOnClickListener {
                    findNavController().navigate(R.id.action_onBoardFragment_to_noteFragment)
                }
                btnToStart.visibility = View.INVISIBLE


            }

            2 -> {
                imgHost.load(R.drawable.img_three)
                tvOn.text = getString(R.string.three_txt)
                btnSkip.visibility = View.INVISIBLE
                btnToStart.visibility = View.VISIBLE
                btnToStart.setOnClickListener {
                    findNavController().navigate(R.id.action_onBoardFragment_to_noteFragment)
                }

            }

        }


    }


    companion object {
        const val ARGS_ON_BOARD_POSITION = "ON_BOARD"
    }


}
