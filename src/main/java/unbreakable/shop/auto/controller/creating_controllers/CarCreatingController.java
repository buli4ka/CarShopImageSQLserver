package unbreakable.shop.auto.controller.creating_controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import unbreakable.shop.auto.entity.car_structure.Car;
import unbreakable.shop.auto.entity.car_structure.Image;
import unbreakable.shop.auto.entity.car_structure.Manufacturer;
import unbreakable.shop.auto.service.car_service.*;


import java.util.List;

@Controller
public class CarCreatingController {
    @Autowired
    private CarService carService;
    @Autowired
    private ManufacturerService manufacturerService;
    @Autowired
    private BodyTypeService bodyTypeService;
    @Autowired
    private CarModelService carModelService;
    @Autowired
    private ImageService imageService;


    @GetMapping("/admin/car")
    public String getAll(Model model) {

            List<Car> cars = carService.getCars();

            List<Manufacturer> manufacturers = manufacturerService.getManufacturers();


            List<Image> images = imageService.getImages();

            model.addAttribute("Cars", cars);
            model.addAttribute("Images", images);
            model.addAttribute("Manufacturers", manufacturers);


            return "car";

    }

    @PostMapping("/admin/car/add")
    public String addCar(@RequestParam("manufacturer") String manufacturerName
            , @RequestParam("carModel") String carModelName
            , @RequestParam("yearOfIssue") short yearOfIssue
            , @RequestParam("bodyType") String bodyTypeName
            , @RequestParam("carDescription") String carDescription
            , @RequestParam("price") double price
            , @RequestParam("images") MultipartFile[] images
    )  {
        Car car = carService.saveCar(price
                , manufacturerService.notExistCreate(manufacturerName)
                , bodyTypeService.notExistCreate(bodyTypeName)
                , yearOfIssue
                , carModelService.notExistCreate(carModelName, manufacturerService.notExistCreate(manufacturerName))
                , carDescription);
        for (MultipartFile image : images) {

            imageService.saveImage(image, car);
        }

        return "redirect:/admin/car";
    }
    @PostMapping("/admin/car/delete")
    public String deleteCar(@RequestParam("id") Integer id){
        carService.deleteCarById(id);
        return "redirect:/admin/car";
    }

//    @PostMapping("/admin/car/add/image")
//    public String uploadMultipleImages(@RequestParam("images") MultipartFile[] images) {
//        for (MultipartFile image : images) {
//            //imageService.saveImage(image);
//        }
//        return "redirect:/admin/car";
//    }

//    @GetMapping("/admin/car/downloadImage/{imageId}")
//    public ResponseEntity<ByteArrayResource> downloadImage(
//            @PathVariable Integer imageId) {
//        Image image = imageService.getImage(imageId).get();
//        return ResponseEntity
//                .ok()
//                .contentType(MediaType.parseMediaType(image.getImageType()))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment:imagename=\"" + image.getImageName() + "\"")
//                .body(new ByteArrayResource(image.getImage()));
//    }
    //    @GetMapping("/admin/add/car/image")
//    public String get(Model model){
//        List<Image> images = imageService.getImages();
//        model.addAttribute("Images",images);
//        return "image";
//    }


}
