package com.yaooort.googlecode.mp4parser.boxes.adobe;

import com.yaooort.coremedia.iso.boxes.Box;
import com.yaooort.coremedia.iso.boxes.sampleentry.SampleEntry;

import java.nio.ByteBuffer;

/**
 * Sample Entry as used for Action Message Format tracks.
 */
public class ActionMessageFormat0SampleEntryBox extends SampleEntry {
    public ActionMessageFormat0SampleEntryBox() {
        super("amf0");
    }

    @Override
    protected long getContentSize() {
        long size = 8;
        for (Box box : boxes) {
            size += box.getSize();
        }

        return size;
    }


    @Override
    public void _parseDetails(ByteBuffer content) {
        _parseReservedAndDataReferenceIndex(content);
        _parseChildBoxes(content);
    }

    @Override
    protected void getContent(ByteBuffer byteBuffer) {
        _writeReservedAndDataReferenceIndex(byteBuffer);
        _writeChildBoxes(byteBuffer);
    }
}
