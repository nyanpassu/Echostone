package kirisame.android.echostone.adapter;

import android.media.AudioManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import kirisame.android.echostone.R;
import kirisame.android.echostone.core.AudioInfo;

/**
 * Created by 雾雨 on 2015/4/1.
 */
public class AudioListAdapter extends RecyclerView.Adapter<AudioListAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        View root;

        ImageView albumCover;

        TextView trackTitle;

        TextView albumTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            root = itemView;
            albumCover = (ImageView) root.findViewById(R.id.album_cover);
            trackTitle = (TextView) root.findViewById(R.id.track_title);
            albumTitle = (TextView) root.findViewById(R.id.album_title);
        }
    }

    AudioManager mAudioManager;

    public AudioListAdapter(List<AudioInfo> list) {

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parentView, int i) {
        View view = View.inflate(parentView.getContext(),R.layout.item_audio_grid,null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
