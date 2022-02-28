package io.red.naturassp.service;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadService {
    public String upLoadFile(MultipartFile arquivo);
}
