package com.leonardo.webServices.resources;

import java.net.URI;
import java.util.List;

import com.leonardo.webServices.entities.User;
import com.leonardo.webServices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.leonardo.webServices.entities.Category;
import com.leonardo.webServices.service.CategoryService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

    @PostMapping()
    public ResponseEntity<User> insert (@RequestBody User user){
        user = userService.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> Delete(@PathVariable Long id){
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
}