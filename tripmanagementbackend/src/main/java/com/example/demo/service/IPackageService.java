package com.example.demo.service;


import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Package;
import com.example.demo.repository.IPackageRepository;

@Service
@Transactional
public class IPackageService {
 
	@Autowired
	private IPackageRepository repo;
	
//	public IPackageService(){
//		this.repo.save(new Package(1,"pk1","pd1","ptype1",100));
//	}
	
	public  List<Package> listAll() {
        return repo.findAll();
    }
     
    public void save(Package ipackage) {
        repo.save(ipackage);
    }
     
    public Package get(Long packageId) {
        return repo.findById(packageId).get();
    	//Optional<Package> temp=  repo.findById(packageId);

    	//return temp.isPresent()?temp.get():null;
    }
     
    public void delete(Long packageId) {
        repo.deleteById(packageId);
    }
	

}
/*Optional<Package> temp=  repo.findById(packageId);

return temp.isPresent()?temp.get():null;*/
