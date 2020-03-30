package com.isturiz.quarantine.views.games

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.isturiz.quarantine.R
import com.isturiz.quarantine.api.models.DeckWords
import com.isturiz.quarantine.mvp.CodenamesContract
import com.isturiz.quarantine.presenters.CodenamesPresenter
import kotlinx.android.synthetic.main.fragment_codenames.*


/**
 * A simple [Fragment] subclass.
 * Use the [CodenamesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CodenamesFragment : Fragment(), CodenamesContract.View {

    override val presenter: CodenamesPresenter = CodenamesPresenter(this)
    override lateinit var equipment: DeckWords

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            equipment = it.getParcelable(ARG_EQUIPMENT) ?: DeckWords()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_codenames, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewInitialized()
    }
    override fun newGame(cards: List<String>) {
        cards.forEachIndexed { index, word ->
            (grid.getChildAt(index) as TextView).text = word
        }
    }

    companion object {

        const val ARG_EQUIPMENT = "equipment"

        @JvmStatic
        fun newInstance(equipment: DeckWords) =
            CodenamesFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_EQUIPMENT, equipment)
                }
            }
    }
}
