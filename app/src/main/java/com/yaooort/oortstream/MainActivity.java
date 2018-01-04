package com.yaooort.oortstream;

import android.content.pm.ActivityInfo;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.yaooort.oort.RtmpListener;
import com.yaooort.oort.SrsCameraView;
import com.yaooort.oort.SrsEncodeHandler;
import com.yaooort.oort.SrsPublisher;
import com.yaooort.oort.SrsRecordHandler;

public class MainActivity extends AppCompatActivity implements SrsEncodeHandler.SrsEncodeListener {


    private SrsCameraView cameraView;

    private SrsPublisher srsPublisher;

    private String rtmpUrl = "rtmp://10.1.100.110:2935/proxypublish/16563555216751293|BA96A92762B92B63E683B2372FAF0E13";

    private Button button;

    private Button switchCa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
        setContentView(R.layout.activity_main);
        cameraView = this.findViewById(R.id.cameraView);
        srsPublisher = new SrsPublisher(cameraView);
        button = this.findViewById(R.id.start_push);
        switchCa = this.findViewById(R.id.switch_cam);
        srsPublisher.setRtmpHandler(new RtmpListener() {
            @Override
            public void callRtmpState(int msg) {
                switch (msg) {
                    case MSG_RTMP_CONNECTING:
                        Log.e("TTTT", "rtmp连接中");
                        break;
                    case MSG_RTMP_CONNECTED:
                        Log.e("TTTT", "rtmp连接成功");
                        break;
                    case MSG_RTMP_VIDEO_STREAMING:
                        Log.e("TTTT", "视频流推送中");
                        break;
                    case MSG_RTMP_AUDIO_STREAMING:
                        Log.e("TTTT", "音频流推送中");
                        break;
                    case MSG_RTMP_STOPPED:
                        Log.e("TTTT", "rtmp已停止");
                        break;
                    case MSG_RTMP_DISCONNECTED:
                        Log.e("TTTT", "rtmp连接失败");
                        break;
                    case MSG_RTMP_VIDEO_FPS_CHANGED:
                        Log.e("TTTT", "视频帧率切换");
                        break;
                    case MSG_RTMP_VIDEO_BITRATE_CHANGED:
                        Log.e("TTTT", "视频码率切换");
                        break;
                    case MSG_RTMP_AUDIO_BITRATE_CHANGED:
                        Log.e("TTTT", "音频码率切换");
                        break;
                    case MSG_RTMP_IO_EXCEPTION:
                        Log.e("TTTT", "rtmp I/O错误");
                        break;
                    case MSG_RTMP_EXCEPTION:
                        Log.e("TTTT", "rtmp中断");
                        break;
                    case MSG_RTMP_RECONNECTION:
                        Log.e("TTTT", "rtmp 正在重连");
                        break;
                    case MSG_RTMP_NET_ERROR:
                        Log.e("TTTT", "rtmp 网络质量差，发送当前帧失败");
                        break;
                }
            }
        });

        srsPublisher.setEncodeHandler(new SrsEncodeHandler(this));
        srsPublisher.setRecordHandler(new SrsRecordHandler(null));
        srsPublisher.setPreviewResolution(1280, 720);
        srsPublisher.setOutputResolution(720, 1280);
        srsPublisher.setVideoSmoothMode();
        srsPublisher.startCamera();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(button.getText().equals("推流")){
                    srsPublisher.startPublish(rtmpUrl);
                    button.setText("结束");
                }else if(button.getText().equals("结束")){
                    srsPublisher.stopPublish();
                    button.setText("推流");
                    srsPublisher.startCamera();
                }
            }
        });

        switchCa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                srsPublisher.switchCameraFace((srsPublisher.getCamraId() + 1) % Camera.getNumberOfCameras());
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        srsPublisher.resumeRecord();
    }

    @Override
    protected void onPause() {
        super.onPause();
        srsPublisher.pauseRecord();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        srsPublisher.stopPublish();
        srsPublisher.stopRecord();
    }

    @Override
    public void onNetworkWeak() {

    }

    @Override
    public void onNetworkResume() {

    }

    @Override
    public void onEncodeIllegalArgumentException(IllegalArgumentException e) {

    }

}
