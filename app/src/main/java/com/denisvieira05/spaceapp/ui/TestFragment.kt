package com.denisvieira05.spaceapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denisvieira05.spaceapp.R
import com.denisvieira05.spaceapp.databinding.ActivityTestBinding
import com.denisvieira05.spaceapp.databinding.FragmentNextLaunchesBinding
import com.denisvieira05.spaceapp.databinding.FragmentTestBinding
import com.denisvieira05.spaceapp.ui.home.launchlist.LaunchListAdapter
import com.google.android.material.snackbar.Snackbar

class TestFragment : Fragment() {

    private lateinit var _binding: FragmentTestBinding
    private val binding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTestBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.phoneNumber.addTextChangedListener(MaskWatcher.buildCellphone())

        binding.testButton.setOnClickListener {
            binding.colorOptionsView.setColorBox(R.color.purple_200)
        }

//        binding.colorOptionsView.onBoxClick

//        binding.colorOptionsView.onBoxClick {
//            Snackbar.make(binding.root, "BOX 1", Snackbar.LENGTH_LONG).show()
//        }

        binding.colorOptionsView1.onBoxClick("text", ::onAction)

//        binding.colorOptionsView.

//        supportFragmentManager.commit {
//            setReorderingAllowed(true)
//            add(binding.fragmentContainer, LaunchDetailFragment())
//        }

//        supportFragmentManager.commit {
//            replace<LaunchDetailFragment>(R.id.fragment_container, "tag")
//            setReorderingAllowed(true)
//            addToBackStack(null)
//        }
//        binding.phoneNumber.addTextChangedListener {
//            println("TEXT SENDO ESCRITO: ${it.toString()}")
////            it.toString()
//        }
//
//        binding.phoneNumber.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                println("DNS: beforeTextChanged  ${p0.toString()}")
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                println("DNS: onTextChanged  ${p0.toString()}")
//
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//                println("DNS: afterTextChanged  ${p0.toString()}")
//            }
//
//        })
    }

    private fun onAction() {

    }
}