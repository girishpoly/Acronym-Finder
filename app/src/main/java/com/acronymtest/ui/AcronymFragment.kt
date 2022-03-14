package com.acronymtest.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.acronymtest.R
import com.acronymtest.databinding.FragmentAcronymBinding
import com.acronymtest.viewmodel.MainViewModel

class AcronymFragment : Fragment() {

    private val acronymViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = DataBindingUtil.inflate<FragmentAcronymBinding>(
            inflater,
            R.layout.fragment_acronym,
            container,
            false
        ).apply {
            viewModel = acronymViewModel
        }

        return view.root
    }
}