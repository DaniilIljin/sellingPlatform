package com.example.backend.controller;

import com.example.backend.dto.FileNamesDTO;
import com.example.backend.dto.PresignedUrlDTO;
import com.example.backend.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/s3")
public class S3Controller {

    private final S3Service s3Service;

    @PostMapping("/download")
    public ResponseEntity<List<String>> generateDownloadUrls(@RequestBody FileNamesDTO fileNames) {

        if (fileNames.getFileNames() == null) return ResponseEntity.badRequest().build();

        List<String> urls = s3Service.createGetPresignedGetUrls(fileNames.getFileNames());
        return ResponseEntity.ok(urls);
    }


    @PostMapping("/upload")
    public ResponseEntity<List<PresignedUrlDTO>> generateUploadUrls(@RequestBody FileNamesDTO fileNames) {

        if (fileNames.getFileNames() == null) return ResponseEntity.badRequest().build();

        List<PresignedUrlDTO> urls = s3Service.createPostPresignedUrls(fileNames.getFileNames());
        return ResponseEntity.ok(urls);
    }
}
