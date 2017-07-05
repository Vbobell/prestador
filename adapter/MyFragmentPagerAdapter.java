package com.lucas.senac.topicosavancados.adapter;


import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.lucas.senac.topicosavancados.ActPrincipal;
import com.lucas.senac.topicosavancados.bean.PrestadorServico;
import com.lucas.senac.topicosavancados.fragment.FragmentA;
import com.lucas.senac.topicosavancados.fragment.FragmentB;


public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] mTabTitles;
    private ActPrincipal ac;
    private PrestadorServico ps;


    public MyFragmentPagerAdapter(FragmentManager fm, String[] mTabTitles, PrestadorServico ps) {
        super(fm);
        this.mTabTitles = mTabTitles;
        this.ps = ps;
    }

    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FragmentA fa = new FragmentA();
                fa.setPs(ps);
                return fa;
            case 1:
                return new FragmentB();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return this.mTabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.mTabTitles[position];
    }
}
