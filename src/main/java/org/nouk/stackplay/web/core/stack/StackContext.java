package org.nouk.stackplay.web.core.stack;

import com.google.gson.JsonObject;
import lombok.Getter;

/**
 * @Description: 每一个stack的上下文
 * @author: dell
 * @date: 2021/7/16 15:22
 **/
@Getter
public class StackContext {

    private String stackId;
    private String stackName;
    private String execId;
    private StackGroup stackGroup;
    private String paragraphId;
    private String curFrameId;
    private Integer frameProgress;
    private Integer stackProgress;
    private JsonObject jsonObject;


    /**
     * Builder class for StackContext
     */
    public static class Builder {
        private StackContext context;

        public Builder() {
            context = new StackContext();
            context.frameProgress=0;
            context.stackProgress=0;
            context.jsonObject = new JsonObject();
        }

        public StackContext setStackId(String stackId) {
            context.stackId = stackId;
            return context;
        }

        public StackContext setStackName(String stackName) {
            context.stackName = stackName;
            return context;
        }

        public StackContext setExecId(String execId) {
            context.execId = execId;
            return context;
        }

        public StackContext setStackGroup(StackGroup stackGroup) {
            context.stackGroup = stackGroup;
            return context;
        }

        public StackContext setParagraphId(String paragraphId) {
            context.paragraphId = paragraphId;
            return context;
        }

        public StackContext setCurFrameId(String curFrameId) {
            context.curFrameId = curFrameId;
            return context;
        }
        public StackContext build() {
            return context;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private StackContext() {

    }


}
