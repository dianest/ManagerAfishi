package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
  private AfishaRepository repository;
  private int lastMoviesCount = 10;

  public AfishaManager(AfishaRepository repository) {
    this.repository = repository;
  }

  public AfishaManager(int lastMoviesCount, AfishaRepository repository) {

    this.lastMoviesCount = lastMoviesCount;
    this.repository = repository;
  }

  public void add(Movie item) {
    repository.save(item);
  }

  public Movie[] getLastMovies() {
    Movie[] items = repository.findAll();
    int count = Math.min(items.length, lastMoviesCount);
    Movie[] result = new Movie[count];
    for (int i = 0; i < count; i++) {
      int index = items.length - 1 - i;
      result[i] = items[index];
    }
    return result;
  }
}
