package dead.code.theplatform.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dead.code.theplatform.R
import dead.code.theplatform.adaptors.OnBoardingAdaptor
import dead.code.theplatform.data.OnboardData
import dead.code.theplatform.databinding.FragmentOnBoardingBinding

class OnBoardingFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardingBinding

    private val onBoardingAdaptor by lazy { OnBoardingAdaptor() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBoardingAdaptor.differ.submitList(loadData())
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(inflater)
        collectAllFun()
        return binding.root
    }

    private fun collectAllFun() {
        handlingAdaptor()
        setUpIndicator()
        navToLogin()
    }

    private fun handlingAdaptor() {
        binding.apply {
            vp2.apply {
                adapter = onBoardingAdaptor
            }
        }
    }

    private fun loadData(): MutableList<OnboardData> {
        val dataList: MutableList<OnboardData> = mutableListOf()
        dataList.add(
            OnboardData(
                R.drawable.on_boarding_two,
                "قم بتمكين تجربة التعلم الخاصة بك",
                "هذا النص هو مثال لنص يمكن أن يستبدل في نفس المساحة، لقد تم توليد هذا النص.",
            ),
        )
        dataList.add(
            OnboardData(
                R.drawable.on_boarding_three,
                "قم بتمكين تجربة التعلم الخاصة بك",
                "هذا النص هو مثال لنص يمكن أن يستبدل في نفس المساحة، لقد تم توليد هذا النص."
            ),
        )
        return dataList
    }

    private fun setUpIndicator() {
        binding.apply {
            vp2.adapter = onBoardingAdaptor
            dotsIndicator.apply {
                attachTo(vp2)
            }
        }
    }

    private fun navToLogin() {
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingFragment2_to_loginFragment)
        }
    }
}