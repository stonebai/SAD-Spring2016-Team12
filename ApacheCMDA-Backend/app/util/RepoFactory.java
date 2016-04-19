package util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by baishi on 4/19/16.
 */
public class RepoFactory {
    private static final Map<String, CrudRepository> repoMap = new ConcurrentHashMap<>();

    public static CrudRepository getRepo(String name) {
        return repoMap.get(name);
    }

    public static void putRepo(String name, CrudRepository repo) {
        repoMap.put(name, repo);
    }
}
