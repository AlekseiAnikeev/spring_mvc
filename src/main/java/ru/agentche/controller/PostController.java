package ru.agentche.controller;

import org.springframework.web.bind.annotation.*;
import ru.agentche.model.Post;
import ru.agentche.service.PostService;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.util.List;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 07.12.2022
 */
@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public List<Post> all(HttpServletResponse resp) {
        return service.all();
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable long id, HttpServletResponse resp) {
        return service.getById(id);
    }

    @PostMapping
    public Post save(@RequestBody Post post) {
        return service.save(post);
    }

    @DeleteMapping("/{id}")
    public Post removeById(@PathVariable long id, HttpServletResponse resp) {
        return service.removeById(id);
    }

    public void save(BufferedReader reader, HttpServletResponse resp) {
    }
}
