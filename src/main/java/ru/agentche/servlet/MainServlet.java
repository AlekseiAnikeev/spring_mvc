package ru.agentche.servlet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.agentche.controller.PostController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 07.12.2022
 */
public class MainServlet extends HttpServlet {

    private PostController controller;
    private final static String API_PATH = "/api/posts";
    private final static String API_PATH_WITH_NUMBERS = API_PATH + "/\\d+";

    @Override
    public void init() {
        final var context = new AnnotationConfigApplicationContext("ru.agentche");
        final var repository = context.getBean("postRepository");
        final var service = context.getBean("postService");
        controller = context.getBean("postController", PostController.class);
        context.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final var path = req.getRequestURI();
        if (Pattern.matches(API_PATH_WITH_NUMBERS, path)) {
            final var id = extractId(path);
            controller.getById(id, resp);
            return;
        }
        controller.all(resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        controller.save(req.getReader(), resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final var path = req.getRequestURI();
        if (Pattern.matches(API_PATH_WITH_NUMBERS, path)) {
            final var id = extractId(path);
            controller.removeById(id, resp);
        }
    }

    private long extractId(String path) {
        String NUMBER_PATTERN = "[^0-9]";
        return Long.parseLong(path.replaceAll(NUMBER_PATTERN, ""));
    }
}