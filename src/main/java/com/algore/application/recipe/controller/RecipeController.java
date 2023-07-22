package com.algore.application.recipe.controller;

import com.algore.application.recipe.dto.*;
import com.algore.application.recipe.service.RecipeService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/recipe")

public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/view")
    public ModelAndView recipeDetailView(ModelAndView mv, int recipe, Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
        viewCount(request, response, recipe);
        RecipeviewDTO recipeviewDTO = recipeService.DetailView(recipe);
        List<CommentReadDTO> commentReadDTOList = recipeService.commentRead(recipe);
        mv.addObject("commentRead", commentReadDTOList);
        mv.addObject("recipevlew", recipeviewDTO);

        mv.setViewName("/recipe/view");
        return mv;
    }

    @GetMapping("/regist")
        public ModelAndView writeForm (ModelAndView mv, Authentication authentication, HttpServletRequest
        request, HttpServletResponse response){

            List<RecipeCategoryDTO> recipeCategory = recipeService.readcategory();
            List<RecipeUnitDTO> recipeUnit = recipeService.readUnit();
            List<IngredientDTO> recipeIng = recipeService.readIng();

            mv.addObject("CategoryList", new RecipeCategoryDTO());
            mv.addObject("recipeCategory", recipeCategory);
            mv.addObject("UnitList", new RecipeUnitDTO());
            mv.addObject("recipeUnit", recipeUnit);
            mv.addObject("IngList", new IngredientDTO());
            mv.addObject("recipeIng", recipeIng);

            mv.setViewName("/recipe/write");
            return mv;
        }
        @PostMapping("/registform")
        @ResponseBody
        public ModelAndView writeReci (ModelAndView model, RecipeWriteDTO recipeWriteDTO, HttpServletRequest request,
                                       @RequestParam(value = "rpFileName", required = false)List<MultipartFile> rpFile,
                                       @RequestParam(value = "rpContent", required = false)List <String> rpContent,
                                       @RequestParam(value = "ingName", required = false)int[] ingName,
                                       @RequestParam(value = "weigh", required = false)String[] weigh,
                                       @RequestParam(value = "riUnitNum", required = false) int[] riUnitNum
                                      )
        {
            try {
                String root = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\upload\\basic\\";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
                List<SelectProcedure> selectProcedures = new ArrayList<>();
                List<RecipeProcedureDTO> recipeProcedureDTOS = recipeWriteDTO.getRecipeProcedureDTOList();
                List<RecipePhotoWriteDTO> recipePhotoWriteDTOList = recipeWriteDTO.getRecipePhotoWriteDTOList();
                int recipeNum = recipeWriteDTO.getRecipeNum();

                // 메인 사진
                MultipartFile mainFile = recipeWriteDTO.getMainPhotoInputFile();
                String mainPhoto = mainFile.getOriginalFilename();

                if(!mainFile.isEmpty()){
                    File profileFile = new File(root);
                    System.out.println(profileFile);
                    if(profileFile.exists()){
                        profileFile.mkdir();
                    }

                    String mainPhotoName = simpleDateFormat.format(new Date(System.currentTimeMillis())) + "." + mainPhoto.substring(mainPhoto.lastIndexOf(".") + 1);

                    mainFile.transferTo(new File(root + "\\" + mainPhotoName));

                    recipeWriteDTO.setMainPhoto(mainPhotoName);
                    recipeWriteDTO.setPhotoPath("/upload/basic/");
                }

                // 요리 순서 로직
                int countStep = 1;
                for(int i=0; i < rpContent.size(); i++){
                    if(rpFile.get(i).getOriginalFilename().equals("")){
                        if(i < recipeProcedureDTOS.size()){
                            selectProcedures.add(new SelectProcedure(recipeNum, rpContent.get(i), recipeProcedureDTOS.get(i).getRpFileName(), recipeProcedureDTOS.get(i).getRpPath()));
                        }
                    }else{
                        if(i > recipeProcedureDTOS.size()){
                            File file = new File(root + "\\");

                            if(file.exists()){
                                file.mkdirs();
                            }
                        }

                    }
                }

                // 완성 사진
                for(int i = 0; i <recipePhotoWriteDTOList.size(); i++){
                    recipePhotoWriteDTOList.get(i).setRecipeNum(recipeWriteDTO.getRecipeNum());
                }




                System.out.println(rpFile.get(0).getOriginalFilename());
                int result = recipeService.writeRecipe(recipeWriteDTO);

                String path = "";

                if (result > 0) {
                    model.addObject("message", "등록이 완료되었습니다.");
                    model.setViewName("redirect:/view");
                } else {
                    model.addObject("message", "등록에 실패하였습니다.");
                    model.setViewName("redirect:/");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return model;
        }

        @ResponseBody
        @GetMapping("/modify")
        public ModelAndView modifyForm (ModelAndView mv, Authentication authentication,
        @RequestParam("recipe") int recipe){
            try {


                List<RecipeCategoryDTO> recipeCategoryDTO = recipeService.readcategory();

                String name = recipeService.getUserName(recipe);

                List<RecipeOrderDTO> newOrderDTO = new ArrayList<>();

                System.out.println(authentication.getDetails());
                System.out.println(authentication.isAuthenticated());
                System.out.println(authentication.getPrincipal());
                System.out.println(authentication.getAuthorities());

                if (!authentication.getName().equals(name)) {
                    //작성자만 수정가능
                    mv.addObject("message", "작성자만 수정 가능합니다.");
                    mv.setViewName("/common/error");
                    return mv;
                }

                RecipeviewDTO recipeviewDTO = recipeService.DetailView(recipe);
                List<RecipePhotoDTO> recipePhotoDTOList = recipeviewDTO.getRecipePhotoDTOList();
                if (recipePhotoDTOList.isEmpty()) {
                    for (int i = 0; i < 4; i++) {
                        recipePhotoDTOList.add(new RecipePhotoDTO());
                    }
                    recipeviewDTO.setRecipePhotoDTOList(recipePhotoDTOList);
                }
                mv.addObject("newOrder", newOrderDTO);
                mv.addObject("recipeCategory", recipeCategoryDTO);
                mv.addObject("recipevlew", recipeviewDTO);
                mv.setViewName("/recipe/modify");
            } catch (Exception e) {
                mv.addObject("message", e.getMessage());
                mv.setViewName("/common/error");
            }

            return mv;
        }

        @PostMapping("/modifyform")
        @ResponseBody
        public ModelAndView modifyRecipe (ModelAndView mv, RecipeviewDTO recipeviewDTO, HttpServletRequest
        request, @RequestParam(value = "oprderInputFile", required = false) List < MultipartFile > recipePicture,
                                          @RequestParam(value = "orderContent", required = false) List < String > orderContent,
                                          @RequestParam(value = "ingName", required = false) int[] ingName,
                                          @RequestParam(value = "weigh",required = false) String[] weigh,
                                          @RequestParam(value ="riUnitNum",required = false ) int[] riUnitNum,
                                          RedirectAttributes rttr)
        {

            try {
                String root = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\upload\\basic\\";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
                List<ModifyRecipeOrder> modifyRecipeOrders = new ArrayList<>();
                List<RecipeOrderDTO> recipeOrderDTOS = recipeviewDTO.getRecipeOrderList();
                List<RecipePhotoDTO> recipePhotoDTOList = recipeviewDTO.getRecipePhotoDTOList();
                int recipeNum = recipeviewDTO.getRecipeNum();

                //대표 사진 로직
                MultipartFile mainFile = recipeviewDTO.getMainInputFile();
                String mainFilename = mainFile.getOriginalFilename();
                //파일 이름이 널이 아닐때 만 실행

                if (!mainFile.isEmpty()) {
                    File profileFile = new File(root + recipeviewDTO.getMainFileName());
                    System.out.println(profileFile);
                    if (profileFile.exists()) {
                        profileFile.delete();
                    }
                    //이름 중복 해결하기 위해서 시간으로 이름 교체
                    String mainfileName = simpleDateFormat.format(new Date(System.currentTimeMillis())) + "." + mainFilename.substring(mainFilename.lastIndexOf(".") + 1);

                    mainFile.transferTo(new File(root + "\\" + mainfileName));
                    //교체한 이름 DTO에 세팅
                    recipeviewDTO.setMainFileName(mainfileName);
                    recipeviewDTO.setMainPath("/upload/basic/");
                }

                //요리순서 로직
                for (int i = 0; i < orderContent.size(); i++) {
                    if (recipePicture.get(i).getOriginalFilename().equals("")) {    //파일의 이름이 비어있으면
                        if (i < recipeOrderDTOS.size()) {
                            modifyRecipeOrders.add(new ModifyRecipeOrder(recipeNum, orderContent.get(i), recipeOrderDTOS.get(i).getFileName(), recipeOrderDTOS.get(i).getPath()));
                        }
                    } else {
                        if (i < recipeOrderDTOS.size()) {
                            File file = new File(root + "\\" + recipeOrderDTOS.get(i).getFileName()); // 이미 저장한 파일이름 가져오기

                            if (file.exists()) { // 파일 있는지 확인
                                file.delete(); // 파일 이 있으면 삭제하기
                            }
                        }
                        // list에 파일 이름 다시 등록해주기
                        // 파일 이름 안겹치게 하기
                        String newPhotoName = recipePicture.get(i).getOriginalFilename();
                        String newOrderFileName = simpleDateFormat.format(new Date(System.currentTimeMillis())) + "." + newPhotoName.substring(newPhotoName.lastIndexOf(".") + 1);

                        recipePicture.get(i).transferTo(new File(root + "\\" + newOrderFileName));
                        modifyRecipeOrders.add(new ModifyRecipeOrder(recipeNum, orderContent.get(i), newOrderFileName, "/upload/basic/"));

                    }
                }

                //완성사진
                for (int i = 0; i < recipePhotoDTOList.size(); i++) {
                    //레시피 넘버 세팅
                    recipePhotoDTOList.get(i).setRecipeNum(recipeviewDTO.getRecipeNum());

                    //등록된 파일의 이름을 가져오기
                    String photoName = recipePhotoDTOList.get(i).getPhotoInputFile().getOriginalFilename();
                    //등록된 파일이 있는지 검사
                    if (photoName != null && !photoName.equals("")) {
                        System.out.println(photoName);
                        //등록된 파일이 있으면 기존에 있던 파일 삭제해주고 이름 바꿔주기
                        File file = new File(root + "//" + recipePhotoDTOList.get(i).getRecipeFileName());
                        if (file.exists()) { //파일이 있으면
                            file.delete(); //삭제 해주기
                        }
                        //list에 파일 이름 다시 등록해주기
                        String newPhotoName = simpleDateFormat.format(new Date(System.currentTimeMillis())) + "." + photoName.substring(photoName.lastIndexOf(".") + 1);
                        System.out.println(newPhotoName);
                        recipePhotoDTOList.get(i).getPhotoInputFile().transferTo(new File(root + "\\" + newPhotoName));
                        recipePhotoDTOList.get(i).setRecipePhotoPath(("/upload/basic/"));
                        recipePhotoDTOList.get(i).setRecipeFileName(newPhotoName);
                        System.out.println(newPhotoName);
                    }


                }

                //재료 로직

                List<RecipeIngredientDTO> recipeIngredientDTOS = new ArrayList<>();
                for (int i=0;i<ingName.length;i++ ){
                    if(!(ingName[i] ==0)){
                        recipeIngredientDTOS.add(new RecipeIngredientDTO(ingName[i],recipeNum,Integer.parseInt(weigh[i]),riUnitNum[i]));
                        System.out.println(ingName[i]+"이름");
                        System.out.println(weigh[i]+"용량");
                        System.out.println(riUnitNum[i]+"단위");

                    }
                }

                for (RecipeIngredientDTO recipeIngredientDTO:recipeIngredientDTOS) {
                    System.out.println(recipeIngredientDTO);
                }
                recipeviewDTO.setRecipeIngredientDTOS(recipeIngredientDTOS);
                recipeviewDTO.setModifyRecipeOrders(modifyRecipeOrders);
                recipeviewDTO.setRecipePhotoDTOList(recipePhotoDTOList);
                int result = recipeService.modifyRecipe(recipeviewDTO);


                if (result > 0) {
                    rttr.addFlashAttribute("message","게시글 수정 성공");
                    mv.setViewName("redirect:/recipe/view?recipe=" + recipeviewDTO.getRecipeNum());
                } else {
                    mv.addObject("message", "수정 실패하였습니다.");
                    mv.setViewName("/common/error");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return mv;
        }


        @GetMapping("/delete")
        public ModelAndView recipeDelete (ModelAndView mv, Authentication authentication,
        @RequestParam("recipe") int recipe){
            try {


                String name = recipeService.getUserName(recipe);
                if (!authentication.getName().equals(name)) {
                    //작성자만 삭제가능
                    mv.addObject("message", "작성자만 삭제 가능합니다.");
                    mv.setViewName("/home");
                    return mv;
                }
                int result = recipeService.recipeDelete(recipe);
                mv.setViewName("redirect:/home/?page=1");
                return mv;
            } catch (Exception e) {
                return mv;
            }
        }


        private void viewCount (HttpServletRequest request, HttpServletResponse response,int recipeNum){
            Cookie oldCookie = null;

            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("recipeView")) {
                        oldCookie = cookie;
                    }
                }
            }

            if (oldCookie != null) {
                if (!oldCookie.getValue().contains("[" + recipeNum + "]")) {
                    recipeService.viewCount(recipeNum);
                    oldCookie.setValue(oldCookie.getValue() + "_[" + recipeNum + "]");
                    oldCookie.setPath("/");
                    oldCookie.setMaxAge(60 * 60 * 24);
                    response.addCookie(oldCookie);
                }
            } else {
                recipeService.viewCount(recipeNum);
                Cookie newCookie = new Cookie("recipeView", "[" + recipeNum + "]");
                newCookie.setPath("/");
                newCookie.setMaxAge(60 * 60 * 24);
                response.addCookie(newCookie);
            }
        }


    }
