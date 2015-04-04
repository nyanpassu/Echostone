package kirisame.android.echostone.core;

/**
 * Created by 雾雨 on 2015/3/30.
 */
public class AudioPlayer {

    private static volatile AudioPlayer sInstance;

    private static Object mLock = new Object();

    public static AudioPlayer getInstance() {
        if (sInstance == null) {
            synchronized (mLock) {
                if (sInstance == null) {
                    sInstance = new AudioPlayer();
                }
            }
        }
        return sInstance;
    }
}
