package org.nouk.stackplay.web.core.frame;

import org.nouk.stackplay.web.annotation.StackPlayApi;
import org.nouk.stackplay.web.core.stack.StackContext;


/**
 * @Description: stackFrame
 * 每个组件的最小单位
 *  fame 最好可以 无状态 方便实例的复用
 * @author: dell
 * @date: 2021/7/16 15:12
 **/
public abstract class Frame {

    /**
     * Opens interpreter. You may want to place your initialize routine here.
     * open() is called only once
     */
    @StackPlayApi
    public abstract void open() throws FrameException;

    /**
     * Closes interpreter. You may want to free your resources up here.
     * close() is called only once
     */
    @StackPlayApi
    public abstract void close() throws FrameException;

    /**
     * Run code and return result, in synchronous way.
     *
     * @param st statements to run
     */
    @StackPlayApi
    public abstract void interpret(String st,
                                                StackContext context)
            throws FrameException;
    /**
     * Optionally implement the canceling routine to abort interpret() method
     */
    @StackPlayApi
    public abstract void cancel(StackContext context) throws FrameException;

    /**
     * get interpret() method running process in percentage.
     *
     * @return number between 0-100
     */
    @StackPlayApi
    public abstract int getProgress(StackContext context) throws FrameException;


}
