package com.xuandien369;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MvcConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		Path uploadMusicDir = Paths.get("./MusicStorage");
		String uploadMusicPath = uploadMusicDir.toFile().getAbsolutePath();
		
		registry.addResourceHandler("/MusicStorage/**").addResourceLocations("file:/"+uploadMusicPath+"/");
	}
	
	
}
