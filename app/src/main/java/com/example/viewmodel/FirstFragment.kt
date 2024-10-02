package com.example.mvvmexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.viewmodel.R
import com.example.viewmodel.utils.Event
import com.example.viewmodel.utils.EventObserver

class FirstFragment : Fragment() {

    private lateinit var viewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        // ViewModelを取得
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        // LiveDataを監視して、TextViewにデータを表示
        val textView: TextView = view.findViewById(R.id.textView)
        viewModel.text.observe(viewLifecycleOwner, { text ->
            textView.text = text
        })

        // SecondFragmentへ遷移するボタン
        view.findViewById<Button>(R.id.buttonToSecondFragment).setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        view.findViewById<Button>(R.id.eventBtn).setOnClickListener {
            viewModel.onClickButton1()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.onTransit.observe(viewLifecycleOwner, EventObserver {
            findNavController().navigate(R.id.action_firstFragment_to_thirdFragment)
        })
    }


}
