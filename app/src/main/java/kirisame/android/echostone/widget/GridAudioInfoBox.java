package kirisame.android.echostone.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import kirisame.android.echostone.R;
import kirisame.android.echostone.core.AudioInfo;

/**
 * Created by 雾雨 on 2015/4/1.
 */
public class GridAudioInfoBox extends GridLayout {

    public GridAudioInfoBox(Context context) {
        super(context);
    }

    public GridAudioInfoBox(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GridAudioInfoBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    AudioInfo[] mAudioInfos;

    int mChildViewInUseCount;

    boolean[] mPendingRemove;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public GridAudioInfoBox(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setAudioInfoList(@NonNull AudioInfo[] audioInfos) {

        markAudioInfoViewsNotInUse(audioInfos);
        performRemove();
        mAudioInfos = audioInfos;

        final int childCount = getChildCount();
        if (childCount < audioInfos.length) {
            for (int i = childCount; i < audioInfos.length; i++) {
                addNewAudioInfoView();
            }
        }

        final int newChildCount = getChildCount();
        for (int i = 0; i < newChildCount; i++) {
            renderChild(i, mAudioInfos[i]);
        }
    }

    private void markAudioInfoViewsNotInUse(AudioInfo[] audioInfos) {
        if (mAudioInfos == null) {
            return;
        }

        for (int i = 0; i < mAudioInfos.length; i++) {
            boolean isAlive = false;
            for (int j = 0; j < audioInfos.length; j++) {
                if (mAudioInfos[i] == audioInfos[j]) {
                    isAlive = true;
                    break;
                }
            }

            if (!isAlive) {
                ensurePendingRemoveArraySize(i);
                mPendingRemove[i] = true;
            }
        }
    }

    private void performRemove() {
        if (mPendingRemove == null) {
            return;
        }

        int size = 0;
        for (int i = 0; i < mPendingRemove.length; i++) {
            if (mPendingRemove[i]) {
                size++;
            }
        }

        View[] pendingRemoveViews = new View[size];

        int index = 0;
        for (int i = 0; i < mPendingRemove.length; i++) {
            if (mPendingRemove[i]) {
                pendingRemoveViews[index] = getChildAt(i);
            }
        }

        for (int i = 0; i < pendingRemoveViews.length; i++) {
            removeView(pendingRemoveViews[i]);
        }
    }

    private void ensurePendingRemoveArraySize(int size) {
        if (mPendingRemove == null) {
            mPendingRemove = new boolean[size];
        } else if (mPendingRemove.length < size) {
            boolean[] pendingRemove = new boolean[size];
            System.arraycopy(mPendingRemove, 0, pendingRemove, 0, mPendingRemove.length);
            mPendingRemove = pendingRemove;
        }
    }

    private void addNewAudioInfoView() {
        View view = View.inflate(getContext(), R.layout.item_audio_grid, this);
    }

    private void renderChild(int index, AudioInfo audioInfo) {
        View childView = getChildAt(index);
        ViewHolder viewHolder = (ViewHolder) childView.getTag();
        if (viewHolder == null) {
            viewHolder = new ViewHolder(childView);
            childView.setTag(viewHolder);
        }
        viewHolder.albumTitle.setText(audioInfo.album);
        viewHolder.trackTitle.setText(audioInfo.title);
    }

    private static class ViewHolder {

        ImageView albumCover;

        TextView trackTitle;

        TextView albumTitle;

        private ViewHolder(View view) {
            albumCover = (ImageView) view.findViewById(R.id.album_cover);
            trackTitle = (TextView) view.findViewById(R.id.track_title);
            albumTitle = (TextView) view.findViewById(R.id.album_title);
        }
    }
}
