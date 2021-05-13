package net.codejava.services;

import java.util.List;
import net.codejava.entity.IMC_Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import net.codejava.repositories.IMCRepository;

@Service
@Transactional
public class IMCService {

	@Autowired
	private IMCRepository repo;
	
	public List<IMC_Data> listAll() {
		return repo.findAll();
	}
	
	public void save(IMC_Data person) {
		repo.save(person);
	}
	
	public IMC_Data get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
}
