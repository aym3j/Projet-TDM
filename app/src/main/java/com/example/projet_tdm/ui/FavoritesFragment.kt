package com.example.projet_tdm.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projet_tdm.ArretAdapter
import com.example.projet_tdm.RecyclerViewInterface
import com.example.projet_tdm.database.AppDatabase
import com.example.projet_tdm.database.arret.Arret
import com.example.projet_tdm.databinding.FragmentFavoritesBinding
import kotlinx.android.synthetic.main.fragment_home.*

class FavoritesFragment : Fragment(), RecyclerViewInterface {

    private var _binding: FragmentFavoritesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val appDb: AppDatabase = AppDatabase.getInstance(requireContext())!!

        val adapter = ArretAdapter(appDb.arretDao().getFavorites(), this)
        mRecyclerView.adapter = adapter
        mRecyclerView.layoutManager = LinearLayoutManager(requireContext())
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