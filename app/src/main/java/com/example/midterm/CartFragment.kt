package com.example.midterm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.compose.animation.scaleOut
import androidx.navigation.Navigation

class CartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val price= 900
        var count = 1

        updateItemcount(count)
        updateFinalPrice(900.0,count)

        updateItemcount(count)

        val plusButton = view.findViewById<ImageButton>(R.id.cart_countIncreaseImageButton)
        val minusButton = view.findViewById<ImageButton>(R.id.cart_countDecreaseImageButton)

        minusButton.setOnClickListener {
            if (count > 1) count--;
            updateItemcount(count)
            updateFinalPrice(900.0, count)
        }
        plusButton.setOnClickListener {
            count++;
            updateItemcount(count)
            updateFinalPrice(900.0, count)
        }


        val controller = Navigation.findNavController(requireView())
        val btn = view.findViewById<Button>(R.id.cart_placeOrderButton)
        btn.setOnClickListener {
            controller.navigate(
                CartFragmentDirections.actionCartFragmentToSuccessFragment()
            )
        }

        val backButton = view.findViewById<ImageButton>(R.id.cart_backButton)
        backButton.setOnClickListener {
            // use finish() function to go back
            controller.popBackStack()
        }



    }


    private fun updateItemcount(count: Int) {
        val countTextView = view?.findViewById<TextView>(R.id.cart_itemCountTextView)
        val totalTextview = view?.findViewById<TextView>(R.id.cart_textTotalTextview)
        countTextView?.text = count.toString()
        totalTextview?.text = "Subtotal: (${count} items)"

    }

    private fun updateFinalPrice(price: Double, count: Int) {
        val finalPriceTextView = view?.findViewById<TextView>(R.id.cart_finalPriceTextview)
        finalPriceTextView?.text = (price * count).toString()
    }
}