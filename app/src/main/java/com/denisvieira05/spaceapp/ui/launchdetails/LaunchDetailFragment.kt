package com.denisvieira05.spaceapp.ui.launchdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.denisvieira05.spaceapp.R
import com.denisvieira05.spaceapp.databinding.FragmentLaunchDetailBinding

class LaunchDetailFragment : Fragment() {
    private lateinit var _binding: FragmentLaunchDetailBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLaunchDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.navigationIcon = ResourcesCompat.getDrawable(resources, R.drawable.ic_back_24, null);
        binding.toolbar.setNavigationOnClickListener {
            activity?.finish()
        }

        binding.mainButton.setOnClickListener {
            val bundle = bundleOf("amount" to "TESTE JETPACK NAVIGATION ")
            findNavController().navigate(R.id.action_launchDetailFragment_to_launchDescriptionFragment, bundle)
        }
    }

}