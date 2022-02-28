package io.red.naturassp.service;

import com.sun.xml.bind.api.impl.NameConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class UploadServiceImpl implements IUploadService {
    @Override
    public String upLoadFile(MultipartFile arquivo) {
        try {
            System.out.println(arquivo.getOriginalFilename());
            String caminho = "/home/red/mwdev/";
            Path path = Paths.get(caminho + File.separator + arquivo.getOriginalFilename());
            Files.copy(arquivo.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Copiou");
            return path.toString();
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
}
