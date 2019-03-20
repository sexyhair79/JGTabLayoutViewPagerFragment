package cm.jiege.jgtablayoutviewpagerfragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.content.res.AppCompatResources
import android.view.View
import android.widget.ToggleButton
import cm.jiege.jgcollection.tabFragment.CinemaFragment
import com.wangjie.demoimitationmoviekotlin.home.fragment.HomeFragment
import com.wangjie.demoimitationmoviekotlin.movie.MovieFragment
import com.wangjie.demoimitationmoviekotlin.movieinfo.MovieInfoFragment
import com.wangjie.demoimitationmoviekotlin.my.MyFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {

    var titleList: MutableList<String> = arrayListOf()
    var homeFragment: Fragment = HomeFragment()
    var movieFragment: Fragment = MovieFragment()
    var movieInfoFragment: Fragment = MovieInfoFragment()
    var cinemaFragment: Fragment = CinemaFragment()
    var myFragment: Fragment = MyFragment()
    var fragmentList: MutableList<Fragment> = mutableListOf(homeFragment, movieFragment, movieInfoFragment, cinemaFragment, myFragment)

    var mViewPagerAdapter: ViewPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }


    /**
     * 初始化方法
     * 设置TabLayout
     * 创建ViewPagerAdapter对象
     * 关联Tablayout与ViewPager
     * 给每一个TabView设置点击监听事件
     * 给ViewPager设置pageChange改变的事件
     */
    private fun initView() {
        //关联TabLayout和ViewPager
        tabLayout.setupWithViewPager(viewPager)
        //设置ViewPager
        mViewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = mViewPagerAdapter
        //设置监听
        viewPager.addOnPageChangeListener(TabViewOnPageChangeListener())

        //设置TabLayout
        titleList.add(getString(R.string.main_tab_home))
        titleList.add(getString(R.string.main_tab_movie))
        titleList.add(getString(R.string.main_tab_cinema))
        titleList.add(getString(R.string.main_tab_movieshow))
        titleList.add(getString(R.string.main_tab_my))
        tabLayout.tabMode = TabLayout.MODE_FIXED
        var i = 0
        while (i < titleList.size) {
            var tab: TabLayout.Tab? = tabLayout.getTabAt(i)
            if (tab != null) {
                var toggleBtn: ToggleButton = getTabView(i)

                if (toggleBtn != null) {
                    tab.customView = toggleBtn
                    toggleBtn.setOnClickListener(TabClickListener())
                    toggleBtn.tag = i
                }
            }
            i++
        }
    }

    /**
     * tabLayout中TablView的点击监听，
     * 更改当前显示的Fragment
     */
    private inner class TabClickListener : View.OnClickListener {
        override fun onClick(p0: View?) {
            var viewId: Int = p0?.tag as Int
            viewPager.currentItem = viewId
        }
    }

    private inner class TabViewOnPageChangeListener : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {
        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        }

        override fun onPageSelected(position: Int) {
            setTabShow(position)
        }
    }

    private fun setTabShow(id: Int) {
        var count = mViewPagerAdapter?.count as Int
        var i = 0
        while (i < count) {
            var btn: ToggleButton = tabLayout.getTabAt(i)?.customView as ToggleButton
            btn.isChecked = (i == id)
            i++
        }
    }

    inner class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        var fm: FragmentManager? = null

        init {
            this.fm = fm
        }

        override fun getItem(position: Int): Fragment {
            return fragmentList.get(position)
        }

        override fun getCount(): Int {
            return fragmentList.size
        }
    }

    fun getTabView(position: Int): ToggleButton {
        var resID: Int = 0
        var mToggleButton: ToggleButton =
                View.inflate(applicationContext, R.layout.main_tab_togglebutton, null) as ToggleButton
        when (position) {
            0 ->
                resID = R.drawable.main_tab_home_selector
            1 ->
                resID = R.drawable.main_tab_movie_selector
            2 ->
                resID = R.drawable.main_tab_vedio_selector
            3 ->
                resID = R.drawable.main_tab_movieinfo_selector
            4 ->
                resID = R.drawable.main_tab_person_selector

            else -> null

        }

        formatToggleButtonTab(mToggleButton, resID, titleList[position])
        return mToggleButton
    }

    fun formatToggleButtonTab(mToggleButton: ToggleButton, resId: Int, txt: String) {
        var width: Int = resources.getDimension(R.dimen.d40).toInt()
        var height = width
        var drawable = AppCompatResources.getDrawable(applicationContext, resId)
        if (drawable != null) {
            drawable.setBounds(0, 0, width, height)
            mToggleButton.setCompoundDrawables(null, drawable, null, null)
        }
        mToggleButton.textOff = txt
        mToggleButton.textOn = txt
        mToggleButton.text = txt
    }
}
