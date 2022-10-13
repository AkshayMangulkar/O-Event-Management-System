package com.example.demo.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.services.Service_Provider_Service;
import com.example.demo.services.Services_Service;
import com.example.demo.entities.*;
import com.example.demo.repositories.Category_Repository;
import com.example.demo.repositories.Service_Providers_Repository;

@CrossOrigin(origins = "http://localhost:3000",allowedHeaders = "*")
@RestController
public class Service_controller {
	@Autowired
	Services_Service sc;
	
	@Autowired
	Category_Repository cr;
	
	@
	Autowired
	
	Service_Providers_Repository spr;
	@GetMapping("/getAllServices")
	public List<Services> getAll(){
		return sc.getAll();
	}
	
	@GetMapping("/getAllServicesByServ_pro")
	public List<Services> getAllByServiceProvider_id(@RequestParam int serv_Pro_id){
		return sc.getAllByServPro(serv_Pro_id);
	}
	
	@PostMapping("/saveService")
	public int saveService(@RequestBody Register_Service_POJO serv) {
	
		return sc.SaveService(serv).getService_id();
		
	}
	
	@PutMapping("/update_Service/{id}")
	public int UpdateService( @PathVariable String id, @RequestBody Register_Service_POJO serv) {
	
		return sc.UpdateService(Integer.parseInt(id), serv);
		
	}
	
	@RequestMapping(value="/getPath/{id}",method =RequestMethod.GET,produces = MediaType.IMAGE_JPEG_VALUE)
	public void saveServic(HttpServletResponse response,@PathVariable String id) throws IOException {
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//		Path p=Paths.get("images//image_"+1+".jpg"); 
		var img=new ClassPathResource("images//image_"+id+".jpg");
		StreamUtils.copy(img.getInputStream(),response.getOutputStream());
	}
	
////	@PostMapping("/saveAndUpload")
//	@RequestMapping(value = "/saveAndUpload", headers = "Content-Type= multipart/form-data", method = RequestMethod.POST)
//	public Services saveService(@RequestPart ("data") Register_Service_POJO data,@RequestPart("file") MultipartFile file) {
//	
//		Services service=sc.SaveService(data);
//		
//		boolean flag=true;
//		try {
//			byte [] data1=file.getBytes();
//			Path path=Paths.get("src//main//resources//images//image_"+service.getService_id()+".jpg");
//			Path p=Files.write(path, data1);
//			System.out.println(p);
//			
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			flag=false;
//			System.out.println("error occured");
//		}
//		if(flag)
//			return service;
//		else
//			return null;
//		
//		
//		
//	}
	
	@PostMapping(value="/addimage/{service_id}" ,consumes = "multipart/form-data")
	public int addProductImage(@PathVariable("service_id") int service_id,@RequestBody MultipartFile file)
	{
		System.out.println("hi");
		System.out.println(service_id);
		Services s=sc.getService(service_id);
		
		System.out.println(s);
		
//		Category category = catservice.getCategoryByName(pro.getCategoryName());
//		
//		System.out.println(category.getCategoryId());
//		
//		Product addProduct = new Product(artist, category, pro.getProductName(), pro.getProductDiscription(), pro.getPrice());

		
		
		
		
		boolean flag = true;
		
		if(file.getSize() > 10 && !(file.getContentType().equals("jpg"))) 
		{
			
			try 
			{
				
				byte[] data = file.getBytes();
				
				Path path=Paths.get("src//main//resources//images//image_"+s.getService_id()+".jpg");
				
				Files.write(path, data);
			
			
			
			}
			catch (Exception e) {
			
				flag = false;
			}
		}
		if(flag == true)
		{
			
//			int psave = pservice.addProduct(pro);
//			return psave;
			return 1;
		}
		else 
		{
			return 0;
		}
	
	}
}
