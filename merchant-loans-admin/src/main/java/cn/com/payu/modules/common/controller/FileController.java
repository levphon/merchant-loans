package cn.com.payu.modules.common.controller;

import com.glsx.plat.common.utils.SnowFlake;
import com.glsx.plat.common.utils.StringUtils;
import com.glsx.plat.context.properties.UploadProperties;
import com.glsx.plat.core.web.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;

@Slf4j
@RestController
@RequestMapping(value = "/file")
public class FileController {

//    @Resource
//    private FileDfsUtils fileDfsUtils;

    @Resource
    private UploadProperties uploadProperties;

    /**
     * 文件上传
     */
    @RequestMapping(value = "/upload", headers = "content-type=multipart/form-data", method = RequestMethod.POST)
    public R upload(@RequestParam("file") MultipartFile file) throws Exception {
        String result;

//        String path = fileDfsUtils.upload(file);

        //获取文件存放路径
        String path = uploadProperties.getBasePath();

        File targetDir = new File(path);
        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }

        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.indexOf("."));
        String newFilename = SnowFlake.nextId() + suffix;

        String tempPath = targetDir + File.separator + newFilename;

        // 转存文件
        File desc = new File(tempPath);
        FileUtils.copyInputStreamToFile(file.getInputStream(), desc);

        path = tempPath;
        if (StringUtils.isNotEmpty(path)) {
            result = uploadProperties.getFilepath() + newFilename;
            return R.ok().data(result);
        } else {
            result = "上传失败";
            return R.error(result);
        }
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
