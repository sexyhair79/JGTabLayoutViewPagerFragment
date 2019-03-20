package com.wangjie.demoimitationmoviekotlin.movie

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cm.jiege.jgtablayoutviewpagerfragment.R

class MovieFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    companion object {
        const val PARAMS_UID = "uid"
        const val PARAMS_SOURCE = "source"
        fun newInstance(param1: String, param2: String) =
                MovieFragment().apply {
                    arguments = Bundle().apply {
                        putString(PARAMS_UID, param1)
                        putString(PARAMS_UID, param2)
                    }
                }
    }
}
