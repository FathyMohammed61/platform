@file:Suppress("DEPRECATION")

package dead.code.theplatform.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dead.code.theplatform.R
import dead.code.theplatform.databinding.FragmentSplashScreenBinding
import kotlinx.coroutines.*

@DelicateCoroutinesApi
@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : Fragment() {
    private lateinit var binding: FragmentSplashScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashScreenBinding.inflate(inflater)
        friezeAndContinue()
        return binding.root
    }

    private fun friezeAndContinue() {
        GlobalScope.launch(Dispatchers.Main) {
            delay(2000)
            findNavController().navigate(R.id.action_splashScreenFragment_to_onBoardingFragment2)
        }
    }
}

