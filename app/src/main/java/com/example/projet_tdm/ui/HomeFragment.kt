package com.example.projet_tdm.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projet_tdm.ArretAdapter
import com.example.projet_tdm.RecyclerViewInterface
import com.example.projet_tdm.database.AppDatabase
import com.example.projet_tdm.database.arret.Arret
import com.example.projet_tdm.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), RecyclerViewInterface {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val appDb: AppDatabase = AppDatabase.getInstance(requireContext())!!

        val adapter = ArretAdapter(appDb.arretDao().getAll(), this)
        mRecyclerView.adapter = adapter
        mRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                searchView.clearFocus()

                val arguments: List<String>? = p0?.split(" ")?.toList()

                if (arguments != null) {

                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                TODO("Not yet implemented")
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(arret: Arret) {
        Toast.makeText(requireContext(), "Item clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onFavClick(arret: Arret) {
        val appDb: AppDatabase = AppDatabase.getInstance(requireContext())!!
        appDb.arretDao().updateArret(arret)
        Toast.makeText(requireContext(), "Fav button clicked", Toast.LENGTH_SHORT).show()
    }
}