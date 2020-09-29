package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {
  @Mock
  private AfishaRepository repository;
  @InjectMocks
  private AfishaManager manager = new AfishaManager(repository);
  @InjectMocks
  private AfishaManager managerCustom = new AfishaManager(5, repository);

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
  public void addMovie() {
    Movie[] returned = new Movie[]{first, second, third};
    doReturn(returned).when(repository).findAll();
    doNothing().when(repository).save(first);
    doNothing().when(repository).save(second);
    doNothing().when(repository).save(third);

    manager.add(first);
    manager.add(second);
    manager.add(third);

    Movie[] expected = new Movie[]{third, second, first};
    assertArrayEquals(expected, manager.getLastMovies());
  }

  @Test
  public void getLastMoviesDefaultCount() {
    doNothing().when(repository).save(first);
    doNothing().when(repository).save(second);
    doNothing().when(repository).save(third);
    doNothing().when(repository).save(fourth);
    doNothing().when(repository).save(fifth);
    doNothing().when(repository).save(sixth);
    doNothing().when(repository).save(seventh);
    doNothing().when(repository).save(eighth);
    doNothing().when(repository).save(ninth);
    doNothing().when(repository).save(tenth);
    doNothing().when(repository).save(eleventh);

    Movie[] returned = new Movie[]{first, second, third};
    doReturn(returned).when(repository).findAll();

    manager.add(first);
    manager.add(second);
    manager.add(third);
    Movie[] expected = new Movie[]{third, second, first};
    assertArrayEquals(expected, manager.getLastMovies());

    returned = new Movie[]{second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
    doReturn(returned).when(repository).findAll();

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
  public void getLastMoviesCustomCount() {
    doNothing().when(repository).save(first);
    doNothing().when(repository).save(second);
    doNothing().when(repository).save(third);
    doNothing().when(repository).save(fourth);
    doNothing().when(repository).save(fifth);
    doNothing().when(repository).save(sixth);
    doNothing().when(repository).save(seventh);
    doNothing().when(repository).save(eighth);
    doNothing().when(repository).save(ninth);
    doNothing().when(repository).save(tenth);
    doNothing().when(repository).save(eleventh);

    Movie[] returned = new Movie[]{first, second, third};
    doReturn(returned).when(repository).findAll();

    managerCustom.add(first);
    managerCustom.add(second);
    managerCustom.add(third);
    Movie[] expected = new Movie[]{third, second, first};
    assertArrayEquals(expected, manager.getLastMovies());

    returned = new Movie[]{second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
    doReturn(returned).when(repository).findAll();

    managerCustom.add(fourth);
    managerCustom.add(fifth);
    managerCustom.add(sixth);
    managerCustom.add(seventh);
    managerCustom.add(eighth);
    managerCustom.add(ninth);
    managerCustom.add(tenth);
    managerCustom.add(eleventh);
    expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh};
    assertArrayEquals(expected, managerCustom.getLastMovies());
  }

  @Test
  public void getLastMoviesEmpty() {
    Movie[] returned = new Movie[0];
    doReturn(returned).when(repository).findAll();

    Movie[] expected = new Movie[0];
    assertArrayEquals(expected, manager.getLastMovies());
  }

}