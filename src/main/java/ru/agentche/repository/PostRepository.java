package ru.agentche.repository;

import ru.agentche.model.Post;

import java.util.List;
import java.util.Optional;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 07.12.2022
 */
public interface PostRepository {

    List<Post> all();

    Optional<Post> getById(long id);

    Post save(Post post);

    Post removeById(long id);
}
