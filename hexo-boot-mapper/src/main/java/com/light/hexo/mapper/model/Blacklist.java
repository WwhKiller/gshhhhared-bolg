package com.light.hexo.mapper.model;

import com.light.hexo.mapper.annotation.CreateTime;
import com.light.hexo.mapper.annotation.UpdateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author MoonlightL
 * @ClassName: Blacklist
 * @ProjectName hexo-boot
 * @Description: 黑名单
 * @DateTime 2020/9/9 15:32
 */
@Setter
@Getter
@Accessors(chain = true)
@ToString
@Table(name = "t_blacklist")
public class Blacklist implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * ip 地址
     */
    private String ipAddress;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态 1:永久 2：临时
     */
    private Integer state;

    /**
     * 解除时间
     */
    private LocalDateTime expireTime;

    @CreateTime
    private LocalDateTime createTime;

    @UpdateTime
    private LocalDateTime updateTime;
}
