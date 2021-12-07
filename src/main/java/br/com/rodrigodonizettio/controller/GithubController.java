package br.com.rodrigodonizettio.controller;

import br.com.rodrigodonizettio.client.GithubApiClient;
import br.com.rodrigodonizettio.client.GithubLowLevelClient;
import br.com.rodrigodonizettio.entity.GithubRelease;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import java.util.List;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

@Controller("/github")
public class GithubController {
  private final GithubLowLevelClient githubLowLevelClient;
  private final GithubApiClient githubApiClient;

  public GithubController(GithubLowLevelClient githubLowLevelClient,
    GithubApiClient githubApiClient) {
    this.githubLowLevelClient = githubLowLevelClient;
    this.githubApiClient = githubApiClient;
  }

  @Get("/releases-lowlevel")
  Mono<List<GithubRelease>> releasesWithLowLevelClient() {
    return githubLowLevelClient.fetchReleases();
  }

  @Get(uri = "/releases", produces = MediaType.APPLICATION_JSON_STREAM)
  Publisher<GithubRelease> fetchReleases() {
    return githubApiClient.fetchReleases();
  }
}
