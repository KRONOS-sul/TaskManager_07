package com.example.taskmanager_07.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.taskmanager_07.R
import com.example.taskmanager_07.databinding.FragmentHomeBinding
import com.example.taskmanager_07.model.Task
import com.example.taskmanager_07.ui.task.TaskFragment.Companion.RESULT_KEY
import com.example.taskmanager_07.ui.task.TaskFragment.Companion.RESULT_REQUEST_KEY
import com.example.taskmanager_07.ui.task.adapter.TaskAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val adapter = TaskAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter

        setFragmentResultListener(RESULT_REQUEST_KEY) { _, bundle ->
            val data = bundle.getSerializable(RESULT_KEY) as Task
            adapter.addTask(data)
            Log.e("shamal", "onViewCreated: ")
        }

        binding.fabBtn.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}