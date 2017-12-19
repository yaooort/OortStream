package com.yaooort.coremedia.iso.boxes.apple;

import com.yaooort.coremedia.iso.IsoTypeReader;
import com.yaooort.coremedia.iso.Utf8;
import com.yaooort.googlecode.mp4parser.AbstractFullBox;

import java.nio.ByteBuffer;

/**
 * Apple Name box. Allowed as subbox of "----" box.
 *
 * @see AppleGenericBox
 */
public final class AppleNameBox extends AbstractFullBox {
    public static final String TYPE = "name";
    private String name;

    public AppleNameBox() {
        super(TYPE);
    }

    protected long getContentSize() {
        return 4 + Utf8.convert(name).length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void _parseDetails(ByteBuffer content) {
        parseVersionAndFlags(content);
        name = IsoTypeReader.readString(content, content.remaining());
    }

    @Override
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(Utf8.convert(name));
    }
}
