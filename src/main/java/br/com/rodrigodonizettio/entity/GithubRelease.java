package br.com.rodrigodonizettio.entity;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class GithubRelease {
  private String name;
  private String url;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
