package com.example.demo.Controller;

import com.example.demo.Entity.Production;
import com.example.demo.Service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductionController {
    @Autowired
    ProductionService productionService;
    //get all the products
    @GetMapping("/getAllProducts")
    private List<Production> getAllProduct(){
        return productionService.getAllProduct();
    }
    @GetMapping("/sorting/{field}/{order}")
    private  List<Production> getAllProductByOrder(@PathVariable String field,@PathVariable String order){

        if(order.equals("asc")){
            System.out.println("asc");
          return productionService.sortDataAsc(field);
        }else if(order.equals("dsc")){
            System.out.println("dsc");
            return    productionService.sortDataDsc(field);
        }
        else{
            System.out.println("here");
            return null;
        }
    }
    @GetMapping("/pagination/{offset}/{pagesize}")
    private Page<Production> pagination(@PathVariable int offset,@PathVariable int pagesize){
        return productionService.pagination(offset,pagesize);
    }
    @GetMapping("/pagination_sorting/{offset}/{pagesize}/{field}/{order}")
    private Page<Production> paginationWithSortingAsc(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field,@PathVariable String order) {
        if (order.equals("asc")) {
            return productionService.paginationWithSortingAsc(offset, pagesize, field);
        }else if(order.equals("dsc")){
            return productionService.paginationWithSortingDsc(offset, pagesize, field);
        }else{
            return null;
        }
    }
}
