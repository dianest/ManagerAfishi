package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class AfishaRepositoryTest {

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
    void findAll() {
        AfishaRepository repository = new AfishaRepository();
        repository.save(first);
        repository.save(third);
        repository.save(sixth);
        repository.save(ninth);
        Movie[] expected = new Movie[]{first, third, sixth, ninth};
        assertArrayEquals(expected, repository.findAll());
    }


    @Test
    void save() {
        AfishaRepository repository = new AfishaRepository();
        repository.save(eleventh);
        Movie[] expected = new Movie[]{eleventh};
        assertArrayEquals(expected, repository.findAll());
    }


    @Test
    void findById() {
        AfishaRepository repository = new AfishaRepository();
        repository.save(first);
        repository.save(third);
        repository.save(sixth);
        repository.save(ninth);
        repository.save(eleventh);

        assertEquals(ninth, repository.findById(9));
        assertNull(repository.findById(2));
    }


    @Test
    void removeById() {
        AfishaRepository repository = new AfishaRepository();
        repository.save(first);
        repository.save(third);
        repository.save(sixth);
        repository.save(ninth);
        repository.save(eleventh);

        Movie[] expected = new Movie[]{first, third, ninth, eleventh};
        repository.removeById(6);

        assertArrayEquals(expected, repository.findAll());

        Assertions.assertThrows(IllegalStateException.class, () -> {
            repository.removeById(2);
        });
    }


    @Test
    void removeAll() {
        AfishaRepository repository = new AfishaRepository();
        repository.save(first);
        repository.save(third);
        repository.save(sixth);
        repository.save(ninth);
        repository.save(eleventh);

        Movie[] expected = new Movie[0];

        repository.removeAll();

        assertArrayEquals(expected, repository.findAll());
    }
}