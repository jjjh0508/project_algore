package com.algore.application.recipe.service;

import com.algore.application.recipe.dao.RecipeViewMapper;
import com.algore.application.recipe.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RecipeService {
    public final RecipeViewMapper mapper;

    public RecipeService(RecipeViewMapper mapper) {
        this.mapper = mapper;
    }

    public RecipeviewDTO DetailView(int recipeNum) {
        RecipeviewDTO recipeviewDTO = mapper.DetailView(recipeNum);
        List<RecipeOrderDTO> recipeOrderDTOList = mapper.recipeOrder(recipeNum);
        List<RecipePhotoDTO> recipePhotoDTOList = mapper.recipPhoto(recipeNum);
        recipeviewDTO.setRecipePhotoDTOList(recipePhotoDTOList);
        recipeviewDTO.setRecipeOrderList(recipeOrderDTOList);
        return recipeviewDTO;
    }


    public List<CommentReadDTO> commentRead(int recipeNum) {
        List<CommentReadDTO> commentReadDTOList = mapper.commentRead(recipeNum);
        return commentReadDTOList;
    }

    public int viewCount(int recipeNum) {
        int result = mapper.viewCount(recipeNum);
        return result;
    }

    public String getUserName(int recipeNum) {
        String name = mapper.getUserName(recipeNum);
        return name;
    }

    public int recipeDelete(int recipe) {
        int result = mapper.recipeDelete(recipe);
        return result;
    }

    public int writeRecipe(RecipeWriteDTO recipeWriteDTO) {

        int result = 0;
        try {
            result = mapper.writeRecipe(recipeWriteDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int modifyRecipe(RecipeviewDTO recipeviewDTO) {
        int result = 0;

        try {
            //대표사진 업로드 로직
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
            MultipartFile mainFile = recipeviewDTO.getMainInputFile();
            String mainFilename = mainFile.getOriginalFilename();
            String root = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\upload\\basic\\";
            //파일 이름이 널이 아닐때 만 실행

            if (!mainFile.isEmpty()) {
                File profileFile = new File(root + recipeviewDTO.getMainFileName());
                System.out.println(profileFile);
                if (profileFile.exists()) {
                    profileFile.delete();
                }
                //이름 중복 해결하기 위해서 시간으로 이름 교체
                String mainfileName = simpleDateFormat.format(new Date(System.currentTimeMillis())) + "."
                        + mainFilename.substring(mainFilename.lastIndexOf(".") + 1);

                mainFile.transferTo(new File(root + "\\" + mainfileName));
                //교체한 이름 DTO에 세팅
                recipeviewDTO.setMainFileName(mainfileName);
                recipeviewDTO.setMainPath("/upload/basic/");
            }


//            요리 순서 로직
            List<RecipeOrderDTO> recipeOrderDTOS = recipeviewDTO.getRecipeOrderList();
            for (int i = 0; i < recipeOrderDTOS.size(); i++) {
                recipeOrderDTOS.get(i).setRecipeNum(recipeviewDTO.getRecipeNum());
                String orderName = recipeOrderDTOS.get(i).getOprderInputFile().getOriginalFilename();
                if (orderName != null && !orderName.equals("")) {
                    File file = new File(root + "\\" + recipeOrderDTOS.get(i).getFileName()); // 이미 저장한 파일이름 가져오기

                    if (file.exists()) { // 파일 있는지 확인
                        file.delete(); // 파일 이 있으면 삭제하기
                    }

                    // list에 파일 이름 다시 등록해주기
                    // 파일 이름 안겹치게 하기
                    String newOrderFileName = simpleDateFormat.format(new Date(System.currentTimeMillis())) + "." + orderName.substring(orderName.lastIndexOf(".") + 1);

                    recipeOrderDTOS.get(i).getOprderInputFile().transferTo(new File(root + "\\" + newOrderFileName));
                    recipeOrderDTOS.get(i).setPath(("/upload/basic/"));
                    recipeOrderDTOS.get(i).setFileName(newOrderFileName);

                }

            }
            //완성 사진 로직
            List<RecipePhotoDTO> recipePhotoDTOList = recipeviewDTO.getRecipePhotoDTOList();

            //완성 사진 사이즈 만큼 반복
            for (int i = 0; i < recipePhotoDTOList.size(); i++) {
                System.out.println(i);
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

            for (RecipePhotoDTO recipePhotoDTO: recipePhotoDTOList) {
                System.out.println(recipePhotoDTO);
            }


            int orderDelete = mapper.orderDelete(recipeviewDTO.getRecipeNum());
            int photoDelete = mapper.photoDelete(recipeviewDTO.getRecipeNum());
            int orderResult = mapper.modifyOrder(recipeOrderDTOS);
            int photoResult = mapper.modifyPhoto(recipePhotoDTOList);
            int recipeResult = mapper.modifyRecipe(recipeviewDTO);

            if (recipeResult > 0) {
                System.out.println("성공");
                result = 1;
            }

        } catch (Exception e) {
            return 0;
        }
        return result;
    }
}

