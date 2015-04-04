package kirisame.android.echostone.core;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 雾雨 on 2015/3/27.
 */
public class AudioInfoManager {

    /**
     *
     */
    public interface OnAudioInfoUpdateListener {

        public void onAudioInfoAdded();

        public void onAudioInfoUpdated();

        public void onAudioInfoRemoved();
    }

    ContentResolver mResolver;



    private List<AudioInfo> getAudioList(Context context) {
        List<AudioInfo> audioInfoList = new ArrayList<>();

        Cursor cursor = mResolver.query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                null,
                null,
                null,
                MediaStore.Audio.Media.DEFAULT_SORT_ORDER);

        if (cursor != null && cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                AudioInfo info = new AudioInfo();
                info.id = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID));
                info.title = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE));
                info.album = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM));
                info.artist = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
                info.url = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
                info.duration = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION));
                info.size = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE));
                audioInfoList.add(info);
            }
            cursor.close();
        } else if (cursor != null) {
            cursor.close();
        }

        return audioInfoList;
    }

    private void updateAudioList() {

    }

    public List<AudioInfo> getRecentActivitiesList(int size) {
        return new ArrayList<AudioInfo>();
    }

    public void updateRecentActivitiesList() {

    }
}
