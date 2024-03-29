package com.example.userservice.repository;

import com.example.userservice.model.CompositeId;
import com.example.userservice.model.WatchedMovie;
import javafx.util.Pair;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface WatchedMovieRepo extends JpaRepository<WatchedMovie, CompositeId> {

    @Query("select m from WatchedMovie m where m.movieId = :id and m.username = :uname")
    Optional<WatchedMovie> findByUsernameAndMovieId(@Param("uname") String username,
                                                    @Param("id") String movieId);

    List<WatchedMovie> findAllByUsername(String username, Pageable pageable);

    int countByUsername(String username);

    @Query(nativeQuery = true,
            value = "select w.movie_id, w.rating from watched_movie w where w.username = :username")
    List<Map<String, Object>> findWatchedIdsByUsername(@Param("username") String username);

    void deleteByUsernameAndMovieId(String username, String movieId);
}
