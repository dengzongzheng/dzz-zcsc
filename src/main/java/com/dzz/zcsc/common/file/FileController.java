package com.dzz.zcsc.common.file;

import com.alibaba.fastjson.JSONObject;
import com.dzz.zcsc.common.response.ResponseDzz;
import com.dzz.zcsc.config.UtilConfig;
import com.dzz.zcsc.service.IdService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 文件上传下载
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年04月25 21:54
 */
@Controller
@Slf4j
public class FileController {

    @Autowired
    private UtilConfig utilConfig;

    @Autowired
    private IdService idService;


    /**
     * 文件上传
     *
     * @param file file
     * @param request request
     */
    @RequestMapping(value = "/file/upload", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
    public void uploadFile(MultipartHttpServletRequest request,@RequestParam MultipartFile[] file,
            HttpServletResponse response) {

        String fileName = "";
        String originalFileName = "";
        Map<String, String> map = new HashMap<>(16);
        map.put("code", "1");
        map.put("message", "success");
        String uploadType = request.getParameter("uploadType");
        for (MultipartFile file1 : file) {
            try {
                if (!file1.isEmpty()) {
                    originalFileName = file1.getOriginalFilename();
                    assert originalFileName != null;
                    String fileType = originalFileName.substring(originalFileName.indexOf("."));
                    fileName = String.valueOf(idService.getId()) + fileType;
                    File file2 = new File(utilConfig.getUploadFilePath() + fileName);
                    file1.transferTo(file2);
                    originalFileName = file1.getOriginalFilename();
                }
            } catch (Exception e) {
                map.put("code", "0");
                map.put("message", "文件上传失败");
                log.error("文件上传失败!", e);
            }
        }
        map.put("originalFileName", originalFileName);
        map.put("fileName", fileName);
        map.put("imageServerPath", utilConfig.getImageServerPath());

        ResponseDzz responseDzz = ResponseDzz.ok(map);
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().write(JSONObject.toJSONString(responseDzz));
        } catch (IOException e) {
            log.error("文件上传写出结果异常", e);
        }
    }

    /**
     * 获取图片
     *
     * @param response  response
     * @param imageName imageName
     */
    @RequestMapping(value = "/file/pic", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity downPic(HttpServletResponse response, @RequestParam("imageName") String imageName)
            throws IOException {
        if (StringUtils.isBlank(imageName)) {
            return ResponseEntity.noContent().build();
        }
        String imageType = imageName.substring(imageName.indexOf(".") + 1);
        response.setContentType("image/" + imageType);
        try {
            String path = utilConfig.getUploadFilePath() + imageName;
            File file = new File(path);
            FileInputStream fileInputStream = new FileInputStream(file);
        } catch (Exception ex) {
            log.error("获取图片失败!", ex);
        }
        return ResponseEntity.noContent().build();
    }
}
