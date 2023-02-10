package com.example.projet_tdm.ui.update

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.projet_tdm.MainActivity
import com.example.projet_tdm.database.AppDatabase
import com.example.projet_tdm.databinding.FragmentUpdateBinding

class UpdateFragment : Fragment() {

    private var _binding: FragmentUpdateBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUpdateBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val appDb: AppDatabase = AppDatabase.getInstance(requireContext())!!

        binding.charge.setOnClickListener {
            if (appDb.arretDao().getAll().size == 0) {
                MainActivity.loadDataIntoDB(requireContext().applicationContext)
                Toast.makeText(requireContext().applicationContext, "La BDD a été chargée", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext().applicationContext, "La BDD est déja chargée", Toast.LENGTH_SHORT).show()
            }
        }

        binding.vide.setOnClickListener {
            Toast.makeText(requireContext().applicationContext, "La BDD a été vidée", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}