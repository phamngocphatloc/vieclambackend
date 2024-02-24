package group6.ecommerce.Repository;

import group6.ecommerce.model.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Integer> {
    Optional<RefreshToken> findByRefreshToken(String token);
    @Query(value = "SELECT * FROM refresh_token WHERE user_id = :userId", nativeQuery = true)
    Optional<RefreshToken> findByUserId(@Param("userId") int userId);

}
