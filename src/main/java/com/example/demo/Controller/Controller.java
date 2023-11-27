package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;

@RestController
@CrossOrigin(origins = "http://localhost:5173") // Enable CORS
public class Controller {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/")
	public List<User> getUsers() {

		final String QUERY = "SELECT * FROM user;";

		List<Map<String, Object>> result = jdbcTemplate.queryForList(QUERY);

		List<User> userList = new ArrayList<>();

		for (Map<String, Object> row : result) {
			User user = new User();
			user.setId((Integer) row.get("id"));
			user.setFirstName((String) row.get("firstName"));
			user.setLastName((String) row.get("lastName"));
			user.setAge((Integer) row.get("age"));
			user.setPhone((Integer) row.get("phone"));
			user.setCreationDate((Integer) row.get("creationDate"));

			userList.add(user);
		}
		return userList;
	}

	@PostMapping("/addUser")
	public String addUser(@RequestBody User user) {
		try {
			final String INSERT_QUERY = "INSERT INTO user (firstName, lastName, age, phone) VALUES (?, ?, ?, ?)";

			int rowsAffected = jdbcTemplate.update(INSERT_QUERY, user.getFirstName(), user.getLastName(), user.getAge(),
					user.getPhone());

			if (rowsAffected > 0) {
				return "true";
			} else {
				return "false";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	@DeleteMapping("/deleteUser")
	public String delUser(@RequestBody User user) {

		System.out.println(user.toString());
		String result = "";

		try {
			final String DELETE_QUERY = "Delete from user where id = ?";

			int rowsAffected = jdbcTemplate.update(DELETE_QUERY, user.getId());
			
			result = rowsAffected > 0 ? "true" : "false"; 
		} catch (Exception e) {
			result = e.getMessage();
		}

		return result;
	}
	
	@PutMapping("/updateUser")
	public String updateUser(@RequestBody User newUser) {
		System.out.println(newUser.toString());
	    try {
	        final String UPDATE_QUERY = "UPDATE user SET firstName = ?, lastName = ?, age = ?, phone = ? WHERE id = ?";
	        int rowsAffected = jdbcTemplate.update(
	                UPDATE_QUERY,
	                newUser.getFirstName(),
	                newUser.getLastName(),
	                newUser.getAge(),
	                newUser.getPhone(),
	                newUser.getId()
	        );

	        if (rowsAffected > 0) {
	            return "true";
	        } else {
	            return "false";
	        }
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        return e.getMessage();
	    }
	}

}
