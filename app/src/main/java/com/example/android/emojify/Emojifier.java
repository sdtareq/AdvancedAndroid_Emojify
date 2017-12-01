package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;


/**
 * Created by tareq on 1/12/17.
 */

public class Emojifier {
    public static final String TAG = Emojifier.class.getSimpleName();
    public static void detectFaces(Context context, Bitmap bitmap){

        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();
        Frame frame = new Frame.Builder().setBitmap(bitmap).build();
        SparseArray<Face> faces = detector.detect(frame);

        int count = faces.size();
        if (count > 0) {
            Toast.makeText(context , "Face Detected = " + String.valueOf(count) , Toast.LENGTH_SHORT).show();

            Log.v(TAG,"Number of faces: "+ String.valueOf(count));
        }else {
            Toast.makeText(context , "No face Detected" , Toast.LENGTH_SHORT).show();
        }

        detector.release();
    }
}
