package com.example.demo.service;



import java.util.List;


import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.dto.PackageDTO;
import com.example.demo.exception.EmptyListException;
import com.example.demo.exception.ResourceNotFoundException;

import com.example.demo.model.Package;
import com.example.demo.repository.IPackageRepository;

@Service
@Transactional
public class IPackageService {
 
	@Autowired
	private IPackageRepository repo;
	private ModelMapper modelMapper = new ModelMapper();
	private PackageDTO mapToDTO(Package packager) {
		return modelMapper.map(packager, PackageDTO.class);
	}
	
	private Package mapToEntity(PackageDTO packageDTO) {
		return modelMapper.map(packageDTO, Package.class);
	}

	public  List<Package> listAll() {
       List<Package> temp= repo.findAll();
       if(temp.isEmpty())
    	   throw new EmptyListException("No Packages!!!");
		return temp;
    }
     
    public PackageDTO save(PackageDTO packageDTO) {
		Package packager  = mapToEntity(packageDTO);
		//if(repo.)
		repo.save(packager);
		return mapToDTO(packager);
		//return mapToDTO(packager);
    }
     
    public Package get(Long packageId) {
        return repo.findById(packageId).orElseThrow(()->
                                           new ResourceNotFoundException("Package not found with id :" + packageId));
    	
    }
     
    public void delete(Long packageId) {
        repo.findById(packageId).orElseThrow(()->
        new ResourceNotFoundException("Package not found with id :" + packageId));
        repo.deleteById(packageId);
    }
	
    
    

}
//.orElseThrow(()->new ResourceNotFoundException("Package not found with id :"));
