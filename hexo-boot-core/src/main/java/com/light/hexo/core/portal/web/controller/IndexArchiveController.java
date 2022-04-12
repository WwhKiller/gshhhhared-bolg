package com.light.hexo.core.portal.web.controller;

import com.light.hexo.core.portal.common.CommonController;
import com.light.hexo.core.portal.model.HexoPageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Map;

/**
 * @Author MoonlightL
 * @ClassName: IndexArchiveController
 * @ProjectName hexo-boot
 * @Description: 归档控制器（首页）
 * @DateTime 2020/9/21 11:11
 */
@Controller
public class IndexArchiveController extends CommonController {

    /**
     * 归档
     * @param resultMap
     * @return
     */
    @GetMapping(value = {"archives", "archives/", "archives/index.html", "archives/page/{pageNum}/"})
    public String archives(@PathVariable(value="pageNum", required = false) Integer pageNum, Map<String, Object> resultMap) {
        pageNum = pageNum == null ? 1 : pageNum;
        HexoPageInfo pageInfo =  this.postService.archivePostsByIndex(pageNum, PAGE_SIZE);
        resultMap.put("pageInfo", pageInfo);
        resultMap.put("currentNav", this.navService.findByLink("/archives/"));
        return render("archives", false, resultMap);
    }
}
