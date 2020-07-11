package com.simpleapp.samplemvvmapp.ui.mainfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.simpleapp.samplemvvmapp.databinding.SimpleFragmentBinding
import com.simpleapp.samplemvvmapp.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SimpleFragment : BaseFragment() {

    private val simpleViewModel : SimpleViewModel by viewModel()
    private var _binding: SimpleFragmentBinding? = null
    private val binding get() = _binding

    companion object {
        @JvmStatic
        fun newInstance() = SimpleFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = SimpleFragmentBinding.inflate(inflater, container, false)
        binding?.simpleViewModel = simpleViewModel
        binding?.lifecycleOwner = this
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    override fun setUp() {

    }

    override fun showProgress() {
    }

    override fun hideProgress() {
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
