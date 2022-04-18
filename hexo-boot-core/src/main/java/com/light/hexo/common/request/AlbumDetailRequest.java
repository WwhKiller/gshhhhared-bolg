package com.light.hexo.common.request;

import com.light.hexo.mapper.model.AlbumDetail;
import com.light.hexo.common.base.BaseRequest;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author MoonlightL
 * @ClassName: AlbumDetailRequest
 * @ProjectName hexo-boot
 * @Description: 专辑详情请求对象
 * @DateTime 2021/12/23, 0023 14:01
 */
@Setter
@Getter
public class AlbumDetailRequest extends BaseRequest<AlbumDetail> {

    /**
     * 主键
     */
    @NotNull(message = "主键不能为空", groups = {BaseRequest.Update.class})
    private Integer id;

    /**
     * 名称
     */
    @NotEmpty(message = "名称不能为空", groups = {BaseRequest.Save.class, BaseRequest.Update.class})
    private String name;

    /**
     * 地址
     */
    @NotEmpty(message = "地址不能为空", groups = {BaseRequest.Save.class, BaseRequest.Update.class})
    private String url;

    /**
     * 封面地址
     */
    private String coverUrl;

    /**
     * 专辑 id
     */
    private Integer albumId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 备注
     */
    private String remark;
}
