package com.example.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service {

    private final S3Client s3Client;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    public List<String> createGetPresignedGetUrls(List<String> fileNames) {

        try (S3Presigner presigner = S3Presigner.create()) {

            return fileNames.stream()
                    .map(fileName -> {
                        GetObjectRequest objectRequest = GetObjectRequest.builder()
                                .bucket(bucketName)
                                .key(fileName)
                                .build();

                        GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
                                .signatureDuration(Duration.ofMinutes(60))
                                .getObjectRequest(objectRequest)
                                .build();

                        PresignedGetObjectRequest presignedGetObjectRequest = presigner.presignGetObject(presignRequest);
                        return presignedGetObjectRequest.url().toExternalForm();
                    }).toList();
        }
    }

    public List<String> createPostPresignedUrls(List<String> fileNames) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();

        try (S3Presigner presigner = S3Presigner.create()) {

            return fileNames.stream()
                    .map(fileName -> {
                        String key = String.format("%s/%s-%s", name, fileName, UUID.randomUUID());

                        PutObjectRequest objectRequest = PutObjectRequest.builder()
                                .bucket(bucketName)
                                .key(key)
                                .build();

                        PutObjectPresignRequest presignRequest = PutObjectPresignRequest.builder()
                                .signatureDuration(Duration.ofMinutes(20))
                                .putObjectRequest(objectRequest)
                                .build();

                        PresignedPutObjectRequest presignedPutObjectRequest = presigner.presignPutObject(presignRequest);

                        return presignedPutObjectRequest.url().toExternalForm();
                    }).toList();
        }
    }

}
