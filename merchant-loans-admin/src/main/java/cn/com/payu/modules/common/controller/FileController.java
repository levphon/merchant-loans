package cn.com.payu.modules.common.controller;

import com.glsx.plat.common.utils.StringUtils;
import com.glsx.plat.core.web.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/file")
public class FileController {

//    @Resource
//    private FileDfsUtils fileDfsUtils;

    /**
     * 文件上传
     */
    @RequestMapping(value = "/upload", headers = "content-type=multipart/form-data", method = RequestMethod.POST)
    public R upload(@RequestParam("file") MultipartFile file) throws Exception {
        String result;
        String path = "";//fileDfsUtils.upload(file);
        if (StringUtils.isNotEmpty(path)) {
            result = path;
        } else {
            result = "上传失败";
        }
        return R.ok().data(result);
    }

    /**
     * 文件删除
     */
    @RequestMapping(value = "/deleteByPath", method = RequestMethod.GET)
    public R deleteByPath() {
        String filePathName = "group1/M00/00/00/wKhIgl0n4AKABxQEABhlMYw_3Lo825.png";
        //fileDfsUtils.deleteFile(filePathName);
        return R.ok();
    }

}
