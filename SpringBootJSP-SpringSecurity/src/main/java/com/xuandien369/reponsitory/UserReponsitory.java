package com.xuandien369.reponsitory;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.xuandien369.entity.AuthenticationProvider;
import com.xuandien369.entity.User;

public interface UserReponsitory extends CrudRepository<User, Integer> {
	@Query("SELECT u FROM User u WHERE u.username=:username")
	public User getUserByUsername(@Param("username")String username);
	
	public User findByResetPassordToken(String token);
	@Query("SELECT u FROM User u WHERE u.email=:email")
	public User findByEmail(String email);
	
	@Query("SELECT u FROM User u WHERE u.username=:username AND u.authProvider =:provider")
	public User getUserByUsernameAndProvider(@Param("username")String username,@Param("provider") AuthenticationProvider provider);
}
