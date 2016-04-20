package util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by baishi on 4/19/16.
 */

/**
 * This class is used to store the repository instances and provide repository instantly
 */
public class RepoFactory {
    /**
     * This map is used to map repository name with real repository
     */
    private static final Map<String, CrudRepository> repoMap = new ConcurrentHashMap<>();

    /**
     * This function is used to fetch a repository from the factory
     * @param name
     * @return
     */
    public static CrudRepository getRepo(String name) {
        return repoMap.get(name);
    }

    /**
     * This function is used to store a repository to the factory
     * @param name
     * @param repo
     */
    public static void putRepo(String name, CrudRepository repo) {
        repoMap.put(name, repo);
    }
}
