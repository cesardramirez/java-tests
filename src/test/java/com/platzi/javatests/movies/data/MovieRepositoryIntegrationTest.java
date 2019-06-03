package com.platzi.javatests.movies.data;

import com.platzi.javatests.movies.model.Movie;
import org.junit.After;
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
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static com.platzi.javatests.movies.model.Genre.ACTION;
import static com.platzi.javatests.movies.model.Genre.THRILLER;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class MovieRepositoryIntegrationTest {

    @InjectMocks
    private MovieRepositoryJdbc movieRepository;

    @Mock
    private JdbcTemplate jdbcTemplate;

    private DataSource dataSource;

    @Before
    public void setUp() throws SQLException {
        // Database in-memory.
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
        jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepository = new MovieRepositoryJdbc(jdbcTemplate);

        // Insert test data into the in-memory database.
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
    }

    @After
    public void tearDown() throws Exception {
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("DROP ALL objects DELETE files");
    }

    @Test
    public void loadAllMovies() {
        Collection<Movie> movies = movieRepository.findAll();

        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, ACTION),
                new Movie(2, "Memento", 113, THRILLER),
                new Movie(3, "Matrix", 136, ACTION),
                new Movie(4, "Super 8", 112, THRILLER),
                new Movie(5, "Superman", 169, ACTION)
        )));
    }

    @Test
    public void loadMovieById() {
        Movie movie = movieRepository.findById(2);

        assertThat(movie, is(new Movie(2, "Memento", 113, THRILLER)));
    }

    @Test
    public void insertAMovie() {
        Movie movie = new Movie("Super 8", 112, THRILLER);
        movieRepository.saveOrUpdate(movie);
        Movie movieSavedInDB = movieRepository.findById(4);

        assertThat(movieSavedInDB, is(new Movie(4, "Super 8", 112, THRILLER)));
    }

    @Test
    public void loadMoviesByName() {
        Collection<Movie> movies = movieRepository.findByName("Super");

        assertThat(movies, is(Arrays.asList(
                new Movie(4, "Super 8", 112, THRILLER),
                new Movie(5, "Superman", 169, ACTION)
            ))
        );
    }
}