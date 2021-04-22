package com.maximcode.leroymerlin.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.SearchView
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.fragment.findNavController
import com.maximcode.leroymerlin.databinding.FragmentSearchBinding
import android.widget.LinearLayout
import by.kirich1409.viewbindingdelegate.viewBinding
import com.maximcode.leroymerlin.R

class SearchFragment : Fragment(R.layout.fragment_search) {
    private val binding by viewBinding(FragmentSearchBinding::bind)
    private val list = listOf("Обои", "Ковер", "Люстры", "Стеллаж", "Шторы", "Зеркало",
        "Ламинат", "Столы", "Линолеум")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        removeSearchHintIcon()
        binding.searchView.showKeyboard()
        binding.listView.adapter = ArrayAdapter(
            requireContext(), android.R.layout.simple_list_item_1, list
        )
        binding.upBtn.setOnClickListener { findNavController().navigateUp() }
    }

    private fun removeSearchHintIcon() {
        val magImage = binding.searchView.findViewById<ImageView>(resources
            .getIdentifier("android:id/search_mag_icon", null, null))
        magImage.layoutParams = LinearLayout.LayoutParams(0, 0)
    }

    private fun SearchView.showKeyboard() {
        post {
            requestFocus()
            getSystemService(requireContext(), InputMethodManager::class.java)
                ?.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
        }
    }
}