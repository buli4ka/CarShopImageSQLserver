package unbreakable.shop.auto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import unbreakable.shop.auto.entity.CarStructure.Image;
import unbreakable.shop.auto.service.ImageService;

import java.util.List;

@Controller
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping("/")
    public String get(Model model){
        List<Image> images = imageService.getImages();
        model.addAttribute("Images",images);
        return "image";
    }
    @PostMapping("/uploadImages")
    public String uploadMultipleImages(@RequestParam("images")MultipartFile[] images)
    {
        for(MultipartFile image : images){
            imageService.saveImage(image);
        }
        return "redirect:/";
    }
    @GetMapping("/downloadImage/{imageId}")
    public ResponseEntity<ByteArrayResource> downloadImage(
            @PathVariable Integer imageId)
    {
        Image image = imageService.getImage(imageId).get();
        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType(image.getImageType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment:imagename=\""+image.getImageName()+"\"")
                .body(new ByteArrayResource(image.getImage()));
    }
}