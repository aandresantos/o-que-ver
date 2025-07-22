package com.oquever.api.domain.model;

public class Movie {

  private String title;
  private String year;
  private String plot;
  private String posterUrl;
  private String imdbId;

  private Movie(Builder builder) {
    this.title = builder.title;
    this.year = builder.year;
    this.plot = builder.plot;
    this.posterUrl = builder.posterUrl;
    this.imdbId = builder.imdbId;
  }

  public String getTitle() {
    return title;
  }

  public String getYear() {
    return year;
  }

  public String getPlot() {
    return plot;
  }

  public String getPosterUrl() {
    return posterUrl;
  }

  public String getImdbId() {
    return imdbId;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private String title;
    private String year;
    private String plot;
    private String posterUrl;
    private String imdbId;

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder year(String year) {
      this.year = year;
      return this;
    }

    public Builder plot(String plot) {
      this.plot = plot;
      return this;
    }

    public Builder posterUrl(String posterUrl) {
      this.posterUrl = posterUrl;
      return this;
    }

    public Builder imdbId(String imdbId) {
      this.imdbId = imdbId;
      return this;
    }

    public Movie build() {
      return new Movie(this);
    }
  }

  public boolean isRecent() {
    try {
      int movieYear = Integer.parseInt(this.year);
      int rulerYear = java.time.Year.now().getValue() - 5;
      boolean isRecent = movieYear >= rulerYear;

      return isRecent;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
