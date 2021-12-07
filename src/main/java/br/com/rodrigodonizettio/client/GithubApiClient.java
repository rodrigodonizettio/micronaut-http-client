package br.com.rodrigodonizettio.client;

import static io.micronaut.http.HttpHeaders.ACCEPT;
import static io.micronaut.http.HttpHeaders.USER_AGENT;

import br.com.rodrigodonizettio.config.GithubConfiguration;
import br.com.rodrigodonizettio.entity.GithubRelease;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.client.annotation.Client;
import org.reactivestreams.Publisher;

@Client(GithubConfiguration.GITHUB_API_URL)
@Header(name = USER_AGENT, value = "Micronaut HTTP Client")
@Header(name = ACCEPT, value = "application/vnd.github.v3+json, application/json")
public interface GithubApiClient {
  @Get("/repos/${github.organization}/${github.repo}/releases")
  Publisher<GithubRelease> fetchReleases();
}
