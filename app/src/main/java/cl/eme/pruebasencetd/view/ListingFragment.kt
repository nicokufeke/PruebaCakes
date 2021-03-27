package cl.eme.pruebasencetd.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import cl.eme.pruebasencetd.databinding.FragmentListingBinding
import cl.eme.pruebasencetd.viewmodel.ListingViewModel
import timber.log.Timber

class ListingFragment : Fragment() {

    private lateinit var binding: FragmentListingBinding

    private val viewModel by viewModels<ListingViewModel>()

    private lateinit var adapter: CakesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListingBinding.inflate(layoutInflater)

        initViews()

        registerObservers()

        return binding.root
    }

    private fun initViews() {
        adapter = CakesAdapter()
        binding.rvCakes.adapter = adapter
        binding.rvCakes.layoutManager = GridLayoutManager(context, 1)

    }

    private fun registerObservers() {
        viewModel.getCakes()

        viewModel.cakesList.observe(viewLifecycleOwner) { cake ->
            cake.let {
                adapter.update(cake)
            }
        }
        adapter.selected().observe(viewLifecycleOwner) {
            Timber.d("el pastel seleccionado es ${it.id}")

            /*
            activity?.supportFragmentManager?.
                    beginTransaction()?.
                    replace(R.id.main_container, DetailFragment.newInstance(it.id.toString()))?.
                    addToBackStack("detail")?.commit()

             */
        }
    }

}