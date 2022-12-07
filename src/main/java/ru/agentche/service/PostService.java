package ru.agentche.service;

import org.springframework.stereotype.Service;
import ru.agentche.exception.NotFoundException;
import ru.agentche.model.Post;
import ru.agentche.repository.PostRepository;

import java.util.List;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 07.12.2022
 */
@Service
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> all() {
        return repository.all();
    }

    public Post getById(long id) {
        return repository.getById(id).orElseThrow(NotFoundException::new);
    }

    public Post save(Post post) {
        return repository.save(post);
    }

    public Post removeById(long id) {
        return repository.removeById(id);
    }
}
