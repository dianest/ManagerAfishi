package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
  private Movie[] items = new Movie[0];
  private int lastMoviesCount = 10;

  public MovieManager() {
  }

  public MovieManager(int lastMoviesCount) {
    this.lastMoviesCount = lastMoviesCount;
  }

  public void add(Movie item) {
    int length = items.length + 1;
    Movie[] tmp = new Movie[length];
    System.arraycopy(items, 0, tmp, 0, items.length);
    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = item;
    items = tmp;
  }

  public Movie[] getLastMovies() {
    int count = Math.min(items.length, lastMoviesCount);
    Movie[] result = new Movie[count];
    for (int i = 0; i < count; i++) {
      int index = items.length - 1 - i;
      result[i] = items[index];
    }
    return result;
  }
}
