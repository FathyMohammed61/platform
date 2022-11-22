package dead.code.theplatform.adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import dead.code.theplatform.data.OnboardData
import dead.code.theplatform.databinding.OnBoradingItemViewBinding

class OnBoardingAdaptor : RecyclerView.Adapter<OnBoardingAdaptor.OnBoardingViewHolder>() {
    private lateinit var binding: OnBoradingItemViewBinding

    inner class OnBoardingViewHolder : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: OnboardData) {
            binding.apply {
                imageOnBoarding.setImageResource(item.imageIndex)
                tvMain.text=item.mainTitle
                tvSub.text=item.subText
            }

        }
    }

    private val diffCallback = object : DiffUtil.ItemCallback<OnboardData>() {
        override fun areItemsTheSame(oldItem: OnboardData, newItem: OnboardData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: OnboardData, newItem: OnboardData): Boolean {
            return oldItem == newItem
        }
    }
     val differ = AsyncListDiffer(this, diffCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        binding = OnBoradingItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OnBoardingViewHolder()
    }

    override fun getItemCount() = differ.currentList.size

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
        holder.setIsRecyclable(false)
    }
}