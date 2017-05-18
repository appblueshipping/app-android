package br.com.blueshipping.blueshipping.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.blueshipping.blueshipping.R;
import br.com.blueshipping.blueshipping.fragment.AboutUsFragment;
import br.com.blueshipping.blueshipping.fragment.ContactUsFragment;
import br.com.blueshipping.blueshipping.fragment.TrakingFragment;
import br.com.blueshipping.blueshipping.utils.Utils;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private ImageView btnSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        viewPager.setCurrentItem(1);

        btnSetting = (ImageView) findViewById(R.id.activity_main_btnSetting);
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish();
                Intent intent;
                intent = new Intent(getApplicationContext(), SettingActivity.class);
                startActivity(intent);
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

    }


    /**
     * Adding custom view to tab
     */
    private void setupTabIcons() {

        String stringTabGrupos = getResources().getString(R.string.tabAboutUs);
        String stringTabAreas = getResources().getString(R.string.tabTracking);
        String stringTabPesquisa = getResources().getString(R.string.tabContactUs);

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText(stringTabGrupos);
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_ic_blueshipping_about, 0, 0);
        tabOne.setTypeface(Utils.customFont("CoreSansD35Regular.otf"));
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText(stringTabAreas);
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_ic_blueshipping_tracking, 0, 0);
        tabTwo.setTypeface(Utils.customFont("CoreSansD35Regular.otf"));
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText(stringTabPesquisa);
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_ic_blueshipping_contact, 0, 0);
        tabThree.setTypeface(Utils.customFont("CoreSansD35Regular.otf"));
        tabLayout.getTabAt(2).setCustomView(tabThree);
    }


    /**
     * Adding fragments to ViewPager
     * @param viewPager
     */
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new AboutUsFragment(), "About");
        adapter.addFrag(new TrakingFragment(), "Tracking");
        adapter.addFrag(new ContactUsFragment(), "Contact");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


}
