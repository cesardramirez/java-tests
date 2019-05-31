package com.platzi.javatests.movies.data;

import com.platzi.javatests.movies.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import static com.platzi.javatests.movies.model.Genre.ACTION;
import static com.platzi.javatests.movies.model.Genre.THRILLER;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class MovieRepositoryIntegrationTest {

    @InjectMocks
    MovieRepositoryJdbc movieRepository;

    @Mock
    JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() throws SQLException {
        // Database in-memory.
        DataSource dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
        jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepository = new MovieRepositoryJdbc(jdbcTemplate);

        // Insert test data into the in-memory database.
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
    }

    @Test
    public void loadAllMovies() {
        Collection<Movie> movies = movieRepository.findAll();

        assertThat(movies, is(Arrays.asList(
            new Movie(1, "Dark Knight", 152, ACTION),
            new Movie(2, "Memento", 113, THRILLER),
            new Movie(3, "Matrix", 136, ACTION)
        )));
    }
}