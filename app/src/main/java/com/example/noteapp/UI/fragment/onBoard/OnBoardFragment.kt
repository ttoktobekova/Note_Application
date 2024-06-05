package com.example.noteapp.UI.fragment.onBoard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.noteapp.R
import com.example.noteapp.UI.adapter.OnBoardViewPagerAdapter
import com.example.noteapp.databinding.FragmentOnBoardBinding


class OnBoardFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            initialize()
            setupListener()
        } catch (e: Exception) {
            Log.e("OnBoardFragment", "Error in onViewCreated: ${e.message}", e)
        }
    }
    private fun initialize() {
        binding.viewPager2.adapter = OnBoardViewPagerAdapter(this@OnBoardFragment)
    }

    private fun setupListener() = with(binding.viewPager2) {
        binding.btnToStart.visibility = View.INVISIBLE
        binding.btnToStart.setOnClickListener {
            //при нажатии на эту кнопку страница свайпается
            if (binding.viewPager2.currentItem < 3) {
                setCurrentItem(1 + currentItem, true)
            }
            if (currentItem < 2) {
                setCurrentItem(2 + currentItem, true)
            }

        }

    }

}


