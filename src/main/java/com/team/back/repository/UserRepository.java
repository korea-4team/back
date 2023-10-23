package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team.back.entity.UserEntity;
import com.team.back.entity.resultSet.UserListResultSet;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
    boolean existsByTelNumber(String telNumber);

    UserEntity findByEmail(String email);
    UserEntity findByTelNumber(String telNumber);
    UserEntity findByEmailAndTelNumber(String email, String telNumber);

    @Query(
		value =
			"SELECT " +
			"email, " +
			"password, " +
			"nickname, " +
			"address, " +
			"address_detail as addressDetail, " +
			"role, " +
			"tel_number as telNumber " +
			"FROM user ",
		nativeQuery = true
	)
    List<UserListResultSet> getUserList(Integer section);
}
