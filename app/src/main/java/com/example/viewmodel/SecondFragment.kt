package com.example.mvvmexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.viewmodel.R

class SecondFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        // ViewModelを取得
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        // データを更新するボタン
        view.findViewById<Button>(R.id.buttonUpdateText).setOnClickListener {
            viewModel.updateText("Updated from Second Fragment")
        }

        // FirstFragmentに戻るボタン
        view.findViewById<Button>(R.id.buttonBackToFirstFragment).setOnClickListener {
            findNavController().navigateUp()
        }

        return view
    }
}
