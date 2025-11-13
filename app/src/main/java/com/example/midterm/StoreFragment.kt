package com.example.midterm

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation


class StoreFragment : Fragment() {

    private var price: Int = 900


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_store, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn = view.findViewById<Button>(R.id.shop_addCartBtn)

        val controller = Navigation.findNavController(requireView())

        btn.setOnClickListener {
            controller.navigate(
                StoreFragmentDirections.actionStoreFragmentToCartFragment()
            )
        }

    }
}


