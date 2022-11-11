package com.denisvieira05.spaceapp.ui.launchdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.denisvieira05.spaceapp.R
import com.denisvieira05.spaceapp.databinding.FragmentLaunchDescriptionBinding
import com.google.android.material.snackbar.Snackbar

class LaunchDescriptionFragment : Fragment() {

    private lateinit var _binding: FragmentLaunchDescriptionBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLaunchDescriptionBinding.inflate(inflater, container, false)

        binding.toolbar.navigationIcon = ResourcesCompat.getDrawable(resources, R.drawable.ic_back_24, null);
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        val text = arguments?.getString("amount")
        Snackbar.make(binding.root, "Texto: $text", Snackbar.LENGTH_LONG).show()

        return binding.root
    }

}