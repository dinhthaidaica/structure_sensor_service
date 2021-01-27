package com.nangtech.imotion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.nangtech.imotion.base.IView
import com.nangtech.imotion.heartrate.HeartRateViewModel
import com.nangtech.imotion.heartrate.model.HeartRateViewState
import org.koin.android.ext.android.inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HeartRateFragment : Fragment(), IView<HeartRateViewState> {

    private val viewModel: HeartRateViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        bindViewModel()
    }

    private fun bindViewModel() {
        viewModel.state.observe(viewLifecycleOwner) {
            renderView(it)
        }
    }

    override fun renderView(state: HeartRateViewState) {
        when {
            state.loading -> showLoadingDialog()
            !state.question.isNullOrEmpty() -> showQuestionDialog()
            !state.errorMessage.isNullOrEmpty() -> showErrorDialog()
        }
    }

    private fun showErrorDialog() {
        TODO("Not yet implemented")
    }

    private fun showQuestionDialog() {
        TODO("Not yet implemented")
    }

    private fun showLoadingDialog() {

    }
}