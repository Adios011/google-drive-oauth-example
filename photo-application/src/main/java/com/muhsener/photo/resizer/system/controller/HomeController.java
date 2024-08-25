package com.muhsener.photo.resizer.system.controller;

import com.muhsener.photo.resizer.system.photo.service.domain.dto.PhotoDTO;
import com.muhsener.photo.resizer.system.photo.service.domain.entity.Photo;
import com.muhsener.photo.resizer.system.photo.service.domain.ports.input.PhotoApplicationService;
import com.muhsener.photo.resizer.system.photo.service.domain.ports.output.thirdparty.ThirdPartyAuthorizationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {

    private final PhotoApplicationService photoApplicationService;

    public HomeController(PhotoApplicationService photoApplicationService) {
        this.photoApplicationService = photoApplicationService;
    }

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }


    @GetMapping("/listPhotos/{userId}")
    public String listFiles(@PathVariable(name = "userId") String userId , Model model) throws IOException, ThirdPartyAuthorizationException {
        List<PhotoDTO> photoList = photoApplicationService.findPhotosFromExternalServices(userId);

        photoList.forEach(photoDTO -> System.out.println(photoDTO.getThumbnailLink()));
        photoList.forEach(photoDTO -> System.out.println(photoDTO.getId()));

        model.addAttribute("photoList" , photoList);
        return "photos";
    }




}
