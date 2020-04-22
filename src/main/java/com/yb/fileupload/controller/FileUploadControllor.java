package com.yb.fileupload.controller;

import com.yb.fileupload.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @description:
 * @author: yangbo
 * @time: 2020/4/20 10:37
 */
@RestController()
@CrossOrigin("*")
@RequestMapping("/file")
public class FileUploadControllor {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadControllor.class);

    @Value("${upload.location}")
    private String path;

    @Value("${remote.url}")
    private String remote;

    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file) {
        if (file == null || file.isEmpty()) {
            return Result.error("please choose file!");
        }
        try {
            String fileName = UUID.randomUUID().toString() + file.getOriginalFilename();
            file.transferTo(new File(path + fileName));
            LOGGER.info("upload success："+ fileName);
            return Result.ok(remote +fileName);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error(e.toString(), e);
            return Result.error(e.getMessage());
        }
    }
    @PostMapping("/uploads")
    public Result uploads(@RequestParam("files") List<MultipartFile> files) {
        if (files == null || files.isEmpty()) {
            return Result.error("please choose file!");
        }
        List<String> s = new ArrayList<>();
        files.forEach(file -> {
            try {
                String fileName = UUID.randomUUID().toString() + file.getOriginalFilename();
                file.transferTo(new File(path + fileName));
                LOGGER.info("upload success："+ fileName);
                s.add(remote + fileName);
            } catch (IOException e) {
                e.printStackTrace();
                LOGGER.error(e.toString(), e);
            }
        });
        return Result.ok(s);
    }
    @GetMapping("/test")
    public Result test(){
        return Result.ok("fuck you");
    }
}
