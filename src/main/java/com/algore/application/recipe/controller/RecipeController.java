package com.algore.application.recipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/recipe")
public class RecipeController {
    @GetMapping("/view")
    public String view(){

        return "recipe/view";
    }


//    @GetMapping("/view")
//    public ModelAndView recipeview(ModelAndView mv){
//
////        List<SelectEmployeeDTO> empList = employeeService.selectAll();
//        TestDTO testDTO = new TestDTO();
//        TestDTO testDTO2 = new TestDTO();
//        List<TestDTO> testDTOList = new ArrayList<>();
//        testDTO.setRecipeOrder("안녕하세요");
//        testDTO2.setRecipeOrder("안녕못해요");
//        testDTOList.add(testDTO);
//        testDTOList.add(testDTO2);
//
//        mv.addObject("testList", testDTOList);
//        mv.setViewName("recipe/view");
//        return mv;
//
//    }

}
