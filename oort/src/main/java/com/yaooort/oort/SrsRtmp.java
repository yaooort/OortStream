package com.yaooort.oort;


public class SrsRtmp {


    static {
        System.loadLibrary("resrtmp");
    }

    public static native long open(String url, boolean isPublishMode);

    public static native int read(long rtmpPointer, byte[] data, int offset, int size);

    public static native int write(long rtmpPointer, byte[] data, int size, int type, int ts);

    public static native int close(long rtmpPointer);

    public static native String getIpAddr(long rtmpPointer);
}
