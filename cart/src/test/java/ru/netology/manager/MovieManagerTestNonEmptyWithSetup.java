package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTestNonEmptyWithSetup {
  Movie first = new Movie(1, "Бладшот", "боевик", "12.03.20", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png?raw=true");
  Movie second = new Movie(2, "Вперед", "мультфильм", "05.03.20", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png?raw=true");
  Movie third = new Movie(3, "Отель Белград", "комедия", "05.03.20", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png?raw=true");
  Movie fourth = new Movie(4, "Джентельмены", "боевик", "13.02.20", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png?raw=true");
  Movie fifth = new Movie(5, "Человек-невидимка", "ужасы", "05.03.20", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png?raw=true");
  Movie sixth = new Movie(6, "Тролли. Мировой тур", "мультфильм", "19.03.20", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png?raw=true");
  Movie seventh = new Movie(7, "Номер один", "комедия", "19.03.20", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png?raw=true");
  Movie eighth = new Movie(8, "Белка и стрелка. Карибская тайна", "мультфильм", "27.09.20", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png?raw=true");
  Movie ninth = new Movie(9, "Мулан", "приключения", "10.09.20", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png?raw=true");
  Movie tenth = new Movie(10, "Довод", "триллер", "03.09.20", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png?raw=true");
  Movie eleventh = new Movie(11, "Супер крейзи", "комедия", "05.09.20", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png?raw=true");


  @Test
  public void addMovie(){
    MovieManager manager = new MovieManager();
    manager.add(first);
    manager.add(second);
    manager.add(third);
    Movie[] expected = new Movie[]{third, second, first};
    assertArrayEquals(expected, manager.getLastMovies());
  }

  @Test
  public void getLastMoviesDefaultCount(){
    MovieManager manager = new MovieManager();
    manager.add(first);
    manager.add(second);
    manager.add(third);
    Movie[] expected = new Movie[]{third, second, first};
    assertArrayEquals(expected, manager.getLastMovies());

    manager.add(fourth);
    manager.add(fifth);
    manager.add(sixth);
    manager.add(seventh);
    manager.add(eighth);
    manager.add(ninth);
    manager.add(tenth);
    manager.add(eleventh);
    expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
    assertArrayEquals(expected, manager.getLastMovies());
  }

  @Test
  public void getLastMoviesCustomCount(){
    MovieManager manager = new MovieManager(5);
    manager.add(first);
    manager.add(second);
    manager.add(third);
    Movie[] expected = new Movie[]{third, second, first};
    assertArrayEquals(expected, manager.getLastMovies());

    manager.add(fourth);
    manager.add(fifth);
    manager.add(sixth);
    manager.add(seventh);
    manager.add(eighth);
    manager.add(ninth);
    manager.add(tenth);
    manager.add(eleventh);
    expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh};
    assertArrayEquals(expected, manager.getLastMovies());

  }

  @Test
  public void getLastMoviesEmpty(){
    MovieManager manager = new MovieManager();
    Movie[] expected = new Movie[0];
    assertArrayEquals(expected, manager.getLastMovies());
  }

 /* @Test
  public void shouldRemoveIfExists() {
    int idToRemove = 1;
    manager.removeById(idToRemove);

    Movie[] actual = manager.getAll();
    Movie[] expected = new Movie[]{third, second};

//    assertEquals(expected, actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldNotRemoveIfNotExists() {
    int idToRemove = 4;

    manager.removeById(idToRemove);

    Movie[] actual = manager.getAll();
    Movie[] expected = new Movie[]{third, second, first};

    assertArrayEquals(expected, actual);
  }*/
}