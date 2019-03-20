package com.wangjie.demoimitationmoviekotlin.movieinfo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cm.jiege.jgtablayoutviewpagerfragment.R

class MovieInfoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie_info, container, false)
    }


    companion object {
        fun newInstance(param1: String, param2: String) =
                MovieInfoFragment().apply {
                    arguments = Bundle().apply {
                    }
                }
    }
}
