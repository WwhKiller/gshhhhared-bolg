package com.light.hexo.common.event;

import com.light.hexo.common.component.event.BaseEvent;
import com.light.hexo.common.component.event.EventEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @Author MoonlightL
 * @ClassName: NavEvent
 * @ProjectName hexo-boot
 * @Description: 导航修改事件
 * @DateTime 2021/1/5 10:01
 */
@Setter
@Getter
@Accessors(chain = true)
public class NavEvent extends BaseEvent {

    /**
     * 导航 id
     */
    private Integer id;

    /**
     * 类型
     */
    private Type type;

    @Getter
    public enum Type {

        LOAD(1, "加载"),
        READ(2, "浏览");

        Integer code;
        String remark;

        Type(int code, String remark) {
            this.code = code;
            this.remark = remark;
        }
    }

    public NavEvent(Object source, Type type) {
        super(source);
        this.type = type;
    }

    public NavEvent(Object source, Integer id, Type type) {
        super(source);
        this.id = id;
        this.type = type;
    }

    @Override
    protected String getEventType() {
        return EventEnum.NAV.getType();
    }
}
