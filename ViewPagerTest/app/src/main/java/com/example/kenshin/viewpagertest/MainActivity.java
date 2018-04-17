package com.example.kenshin.viewpagertest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends FragmentActivity {


//    AdapterView 각각의 View에 다양한 레이아웃을 적용할 수있다.
//    ViewPager를 사용하려면 Support Library가 필요혹시 포함되어있지 않았다면 [android-support-v4.jar] 파일은 SDK폴더에 extras 안에서 찾을 수 있다.
//
//            activity_main.xml
//– support library에 있는 View를 사용할 때는 android.support.v4.view.ViewPager 로 패키지 이름을 전부 적어야 합니다.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager vp = findViewById(R.id.pager);
        vp.setAdapter(new PagerAdapter(getSupportFragmentManager()));
    }


    // Inner Class로 Adapter 클래스를 만들고 ViewPager에 어댑터를 연결해줍니다.
    // PagerAdapter의 종류도 몇가지가 있습니다. FragmentPagerAdapter, FragmentStatePagerAdapter, PagerAdapter
    //    – 각각의 PagerAdapter는 조금다른 특징을 가지고 있습니다.
    //    Fragment를 다루는게 일반적이기 때문에 FragmentPagerAdapter 의 큰 다른점 이라면
    //    FragmentPagerAdapter는 화면을 슬라이딩으로 전환할 때 한 번 생성된(화면에 보인) Fragment를 계속 메모리상 가지고 있습니다. 이전 Fragment로 슬라이딩을 해서 돌아간다고 하면 이전에 생성된 Fragment로 돌아가는 겁니다.
    //    FragmentStatePagerAdapter는 화면이 전환될 때 이전(화면에서 보이지 않는) Fragment는 메모리상 제거(destroy)가 됩니다. Adapter의 Fragment가 많거나 갯수를 알수없을 때 메모리관련 이슈를 위해 사용하는것이 좋다고 하네요

    public class PagerAdapter extends FragmentStatePagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // 해당하는 page의 Fragment를 생성합니다.
            return new PageFragment().create(position);
        }

        @Override
        public int getCount() {
            return 3;  // 총 5개의 page를 보여줍니다.
        }
    }

}
