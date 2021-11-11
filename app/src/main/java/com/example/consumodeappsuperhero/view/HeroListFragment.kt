package com.example.consumodeappsuperhero.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.consumodeappsuperhero.R
import com.example.consumodeappsuperhero.databinding.FragmentHeroListBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HeroListFragment : Fragment(), OnItemClickListener {

    private val viewModel: HeroViewModel by viewModels()
    private lateinit var binding: FragmentHeroListBinding
    private lateinit var fabToUp: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHeroListBinding.inflate(layoutInflater)
        val adapter = HeroAdapter(this)

        binding.rvHeroes.adapter = adapter
        binding.rvHeroes.layoutManager = GridLayoutManager(this.context, 1)
        binding.rvHeroes.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        viewModel.heroes.observe(viewLifecycleOwner, {
            it?.let {
                adapter.update(it)
            }
        })

        fabToUp = binding.fabToUp
        fabToUp.setOnClickListener() {
            binding.rvHeroes.smoothScrollToPosition(0)
        }

        return binding.root
    }

    override fun onClick(id: Int) {
        activity
            ?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fmtContainer, HeroDetailFragment(id))
            ?.addToBackStack("back")
            ?.commit()
    }
}