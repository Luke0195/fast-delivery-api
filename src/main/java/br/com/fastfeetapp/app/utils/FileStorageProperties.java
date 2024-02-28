package br.com.fastfeetapp.app.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;


@Configuration
@ConfigurationProperties(prefix =  "file")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileStorageProperties {

    private Path uploadDir;



}
