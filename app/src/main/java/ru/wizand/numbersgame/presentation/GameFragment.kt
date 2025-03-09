package ru.wizand.numbersgame.presentation

import android.content.res.ColorStateList
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ru.wizand.numbersgame.databinding.FragmentGameBinding
import ru.wizand.numbersgame.domain.entity.GameResult


class GameFragment : Fragment() {

    // Или так
    private val args by navArgs<GameFragmentArgs>()

    //    private lateinit var level: Level
    private val viewModelFactory by lazy {
        // или так
//        val args = GameFragmentArgs.fromBundle(requireArguments())
        GameViewModelFactory(args.level, requireActivity().application)
    }
    private val viewModel: GameViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[GameViewModel::class.java]
    }


    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = _binding ?: throw RuntimeException("FragmentGameBinding == null")

    //    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        parseArgs()
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        observeViewModel()


    }


    private fun observeViewModel() {

        viewModel.gameResult.observe(viewLifecycleOwner) {
            launchGameFinishedFragment(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


//    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
//    private fun parseArgs() {
//
////        level = requireArguments().getSerializable(KEY_LEVEL, Level::class.java) as Level
//
//        level = if (Build.VERSION.SDK_INT > Build.VERSION_CODES.TIRAMISU) {
//            requireArguments().getParcelable(KEY_LEVEL, Level::class.java)
//        } else {
//            requireArguments().getParcelable(KEY_LEVEL, Level::class.java) as? Level
//        } ?: throw RuntimeException("Level is null")
//    }


//    private fun parseArgs() {
//        val args = requireArguments()
//
//        // Используйте getParcelable без второго аргумента
//        level = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            args.getParcelable(KEY_LEVEL, Level::class.java) ?: throw IllegalArgumentException(
//                "Level is required"
//            )
//        } else {
//            @Suppress("DEPRECATION")
//            args.getParcelable(KEY_LEVEL) ?: throw IllegalArgumentException("Level is required")
//        }
//    }


    private fun launchGameFinishedFragment(gameResult: GameResult) {
        findNavController().navigate(
            GameFragmentDirections.actionGameFragmentToGameFinishedFragment(gameResult)
        )

    }
}