package com.example.demo.Service;

import com.example.demo.Entity.Production;
import com.example.demo.Repository.ProductionRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductionService {
    ProductionRepo productionRepo;

    public ProductionService(ProductionRepo productionRepo) {
        this.productionRepo = productionRepo;
    }
    public List<Production> getAllProduct(){
        return productionRepo.findAll();
    }
    //sorting data
    public List<Production> sortDataAsc(String field ) {
       return productionRepo.findAll(Sort.by(Sort.Direction.ASC, field));
    }
    public List<Production> sortDataDsc(String field ) {
        return productionRepo.findAll(Sort.by(Sort.Direction.DESC, field));
    }
    //pagination
    public Page<Production> pagination(int offSet,int pageSize){
          Page<Production> product = productionRepo.findAll(PageRequest.of(offSet,pageSize));
          return product;
    }

    //pagination with sorting asc
    public Page<Production> paginationWithSortingAsc(int offSet,int pageSize,String field){
        Page<Production> product = productionRepo.findAll(PageRequest.of(offSet,pageSize).withSort(Sort.by(field).ascending()));
        return product;
    }

    //pagination with sorting dsc
    public Page<Production> paginationWithSortingDsc(int offSet,int pageSize,String field){
        Page<Production> product = productionRepo.findAll(PageRequest.of(offSet,pageSize).withSort(Sort.by(field).descending()));
        return product;
    }

    //using this function to create data automatically for 200 product
//        @PostConstruct
//    public void initDB() {
//        List<Production> products = IntStream.rangeClosed(1, 200)
//                .mapToObj(i -> new Production("product" + i, new Random().nextInt(100), new Random().nextInt(50000)))
//                .collect(Collectors.toList());
//        productionRepo.saveAll(products);
//    }
}
