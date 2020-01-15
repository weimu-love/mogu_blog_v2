package com.moxi.mogublog.admin.feign;

import com.moxi.mogublog.admin.config.FeignConfiguration;
import com.moxi.mogublog.xo.entity.Blog;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@FeignClient(name = "mogu-elasticsearch", url = "http://localhost:8605/", configuration = FeignConfiguration.class)
public interface SearchFeignClient {

    /**
     * ElasticSearch添加博客
     * @param Eblog
     * @return
     */
    @PostMapping("/search/addBlogbyUid")
    public String addBlogIndex(@RequestBody Blog Eblog);

    /**
     * 通过ElasticSearch删除博客
     * @param uid
     * @return
     */
    @PostMapping("/search/delBlogbyUid")
    public String delBlog(@RequestParam(required = true) String uid);

    /**
     * 初始化ElasticSearch索引
     * @return
     */
    @PostMapping("/search/initElasticSearchIndex")
    public String initElasticSearchIndex();

}
