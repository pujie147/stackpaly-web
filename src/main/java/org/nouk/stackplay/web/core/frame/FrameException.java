package org.nouk.stackplay.web.core.frame;

/**
 * @Description: frame error
 * @author: dell
 * @date: 2021/7/16 15:20
 **/
public class FrameException  extends Exception {

    public FrameException() {
    }

    public FrameException(Throwable e) {
        super(e);
    }

    public FrameException(String m) {
        super(m);
    }

    public FrameException(String msg, Throwable t) {
        super(msg, t);
    }

    public FrameException(String message, Throwable cause, boolean enableSuppression,
                                boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
