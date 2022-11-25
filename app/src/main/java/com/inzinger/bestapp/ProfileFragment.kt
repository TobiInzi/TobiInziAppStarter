package com.inzinger.bestapp

import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.graphics.drawable.RippleDrawable
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.transition.MaterialFadeThrough
import com.inzinger.bestapp.databinding.FragmentProfileSettingsBinding


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ProfileFragment : NavHostFragment() {

    private var _binding: FragmentProfileSettingsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProfileSettingsBinding.inflate(inflater, container, false)

        //animations
        enterTransition = MaterialFadeThrough()
        exitTransition = MaterialFadeThrough()

        setupSettings()

        return binding.root
    }

    private fun setupSettings() {
        //setting up the click listeners
        val firstBar = binding.root.findViewById<LinearLayout>(R.id.first_settings_block)
        firstBar.setOnClickListener { Snackbar.make(binding.root, "First Bar", Snackbar.LENGTH_LONG).show() }

        val secondBlock = binding.root.findViewById<LinearLayout>(R.id.second_settings_block)

        val secondBar = secondBlock.findViewById<LinearLayout>(R.id.second_settings_bar)
        secondBar.setOnClickListener {
            Snackbar.make(binding.root, "Second Bar", Snackbar.LENGTH_LONG).show()

        }

        val thirdBar = secondBlock.findViewById<LinearLayout>(R.id.third_settings_bar)
        thirdBar.setOnClickListener { Snackbar.make(binding.root, "Third Bar", Snackbar.LENGTH_LONG).show() }

        //setting up the ripple effects
        val typedValue = TypedValue()
        val theme = requireContext().theme
        theme.resolveAttribute(com.google.android.material.R.attr.colorOnSecondaryContainer, typedValue, true)

        val imageAllCorners: Drawable = ResourcesCompat.getDrawable(requireContext().resources, R.drawable.rounded_corners, requireContext().theme)!!
        val imageUpperCorners: Drawable = ResourcesCompat.getDrawable(requireContext().resources, R.drawable.rounded_upper_corners, requireContext().theme)!!
        val imageLowerCorners: Drawable = ResourcesCompat.getDrawable(requireContext().resources, R.drawable.rounded_lower_corners, requireContext().theme)!!
        val rippleBackground = RippleDrawable(
            ColorStateList.valueOf(
                typedValue.data
            ), imageAllCorners, null
        )
        firstBar.background = rippleBackground

        val rippleBackground2 = RippleDrawable(
            ColorStateList.valueOf(
                typedValue.data
            ), imageUpperCorners, null
        )
        secondBar.background = rippleBackground2

        val rippleBackground3 = RippleDrawable(
            ColorStateList.valueOf(
                typedValue.data
            ), imageLowerCorners, null
        )
        thirdBar.background = rippleBackground3
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}