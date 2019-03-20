package com.wangjie.demoimitationmoviekotlin.my

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cm.jiege.jgtablayoutviewpagerfragment.R

class MyFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view: View = inflater.inflate(R.layout.fragment_my, container, false)

        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    companion object {
        fun newInstance(param1: String, param2: String) =
                MyFragment().apply {
                    arguments = Bundle().apply {
                    }
                }
    }


}
