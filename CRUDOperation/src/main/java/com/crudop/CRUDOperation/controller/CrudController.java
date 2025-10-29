package com.crudop.CRUDOperation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudop.CRUDOperation.entity.CrudEntity;
import com.crudop.CRUDOperation.repository.CrudRepository;
import com.crudop.CRUDOperationexception.CrudException;

@RestController
@RequestMapping("/goat")
public class CrudController
{
	@Autowired
	private CrudRepository crudrepo;
	/*@GetMapping
	public String show()
	{
		return "saravanan";
	}*/

	/*@GetMapping
	public List<CrudData> show()
	{
		return Arrays.asList(new CrudData(1L,"saravanan","saravanan@gmail"),
				             (new CrudData(2l,"siav","siva@gamil.com")));
	}*/

	@GetMapping
	public List<CrudEntity> getuser()
	{
		return crudrepo.findAll();
	}

	@PostMapping
	public CrudEntity createuser(@RequestBody CrudEntity user)
	{
		return crudrepo.save(user);
	}

	@GetMapping("/{id}")
	public CrudEntity getuserid(@PathVariable Long id)
	{
		return crudrepo.findById(id).orElseThrow(()-> new CrudException("Your Required Field is Not Found..!  " +  id));
	}

	@PutMapping("/{id}")
		public CrudEntity changedata(@PathVariable Long id, @RequestBody CrudEntity user)
		{
		CrudEntity userdata=crudrepo.findById(id).orElseThrow(()-> new CrudException("Your Required Field is Not Found..!  " +  id));
		userdata.setName(user.getName());
		userdata.setEmail(user.getEmail());
		return crudrepo.save(userdata);
		}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removedata(@PathVariable Long id)
	{
		CrudEntity userdata=crudrepo.findById(id).orElseThrow(()-> new CrudException("Your Required Field is Not Found..!  " +  id));
		crudrepo.delete(userdata);
		return ResponseEntity.ok().build();
	}

}
