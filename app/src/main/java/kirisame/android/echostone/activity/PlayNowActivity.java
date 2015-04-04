package kirisame.android.echostone.activity;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import kirisame.android.echostone.R;
import kirisame.android.echostone.core.AudioInfo;
import kirisame.android.echostone.fragment.NavigationDrawerFragment;
import kirisame.android.echostone.widget.GridAudioInfoBox;


public class PlayNowActivity extends ActionBarActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    public static final String PLAY_NOW = "play_now";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_now);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.drawer_layout_content, new PlayNowFragment(),PLAY_NOW)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_play_now, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {

    }

    public static class PlayNowFragment extends Fragment {

        View mRootView;

        GridAudioInfoBox mRecentAdded;

        GridAudioInfoBox mRecentPlayed;

        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            mRootView = inflater.inflate(R.layout.fragment_play_now, container, false);
            initViews();
            return mRootView;
        }

        private void initViews() {
            mRecentAdded = (GridAudioInfoBox) mRootView.findViewById(R.id.grid_recent_add);
            mRecentPlayed = (GridAudioInfoBox) mRootView.findViewById(R.id.grid_recent_played);
        }

        private void fakeDate() {
            AudioInfo[] infos = new AudioInfo[6];
            for (int i = 0; i < 6; i++) {
                AudioInfo info = new AudioInfo();
                info.title = "fake title";
                info.album = "fake album";
            }

            mRecentPlayed.setAudioInfoList(infos);
        }
    }
}
