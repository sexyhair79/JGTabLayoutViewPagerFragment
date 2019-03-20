package cm.jiege.jgcollection.tabFragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cm.jiege.jgtablayoutviewpagerfragment.R

class CinemaFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cinema, container, false)
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
                CinemaFragment().apply {
                    arguments = Bundle().apply {
                    }
                }
    }
}
